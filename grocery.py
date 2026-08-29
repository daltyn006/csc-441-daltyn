#!/usr/bin/env python3
import datetime
import unittest

TAX_RATE = 0.08

class InventoryError(Exception):
    pass

class OutOfStockError(InventoryError):
    pass

class InvalidItemNumberError(InventoryError):
    pass

class GroceryItem:
    def __init__(self, name: str, price: float, amount: int, refresh_interval_days: int):
        if not isinstance(name, str) or not name.strip():
            raise ValueError("Item name must be a non-empty string.")

        try:
            price = float(price)
            amount = int(amount)
            refresh_interval_days = int(refresh_interval_days)
        except (ValueError, TypeError) as e:
            raise TypeError(f"Values must be numeric. Details: {e}")

        if price < 0:
            raise ValueError("Price cannot be negative.")
        if amount < 0:
            raise ValueError("Stock amount cannot be negative.")
        if refresh_interval_days < 0:
            raise ValueError("Refresh interval cannot be negative.")

        self.item = name.strip()
        self.price = price
        self.amount = amount
        self.refresh = datetime.timedelta(days=refresh_interval_days)
        self.stocked = self.status()

    def alter_price(self, difference: float) -> None:
        try:
            diff = float(difference)
        except (ValueError, TypeError):
            print(f"[Error] Price difference '{difference}' must be a valid number.")
            return

        self.price = max(0.0, self.price + diff)

    def status(self) -> bool:
        self.stocked = self.amount > 0
        return self.stocked

    def get_refresh_schedule(self):
        today = datetime.date.today()
        days_since_last = today.toordinal()
        days_interval = self.refresh.days

        if days_interval == 0:
            return 0, 0

        remainder = days_since_last % days_interval
        prev_date = datetime.date.fromordinal(days_since_last - remainder)
        next_date = prev_date + self.refresh

        return prev_date, next_date

    get_refresh = get_refresh_schedule

    def restock(self, quantity: int) -> None:
        prev_date, next_date = self.get_refresh_schedule()
        if prev_date != 0 or next_date != 0:
            self.amount += int(quantity)
            self.status()

    def get_item(self) -> str:
        return self.item

    def get_amount(self) -> int:
        return self.amount

    def get_price(self, include_tax: bool = True) -> float:
        if include_tax is True:
            return round(self.price * (1 + TAX_RATE), 2)
        elif include_tax is False:
            return round(self.price, 2)
        else:
            return -1.0

    def decrement_stock(self, quantity: int = 1) -> None:
        if quantity <= 0:
            raise ValueError("Quantity to decrement must be greater than zero.")
        if self.amount < quantity:
            raise OutOfStockError(f"Cannot remove {quantity} units. Only {self.amount} left in stock.")
        self.amount -= quantity
        self.status()

    @staticmethod
    def sort_inventory(inventory_list, sort_by="price"):
        if sort_by == "price":
            return sorted(inventory_list, key=lambda x: x.price)
        elif sort_by == "amount":
            return sorted(inventory_list, key=lambda x: x.amount, reverse=True)
        return inventory_list

    def __str__(self):
        return f"{self.item}: ${self.price:.2f} ({self.amount} in stock)"


def prompt_positive_int(prompt_text: str) -> int:
    while True:
        raw_input = input(prompt_text).strip()
        try:
            val = int(raw_input)
            if val <= 0:
                print("Input error: Value must be greater than zero.")
                continue
            return val
        except ValueError:
            print(f"Input error: '{raw_input}' is not a valid whole number. Try again.")


def add_item_to_cart(inventory: dict, cart: list) -> None:
    item_number = input("\nEnter item name to purchase: ").strip().upper()

    try:
        if item_number not in inventory:
            raise InvalidItemNumberError(f"Item '{item_number}' does not exist in store records.")

        item = inventory[item_number]
        qty = prompt_positive_int(f"Enter quantity for {item.item}: ")

        item.decrement_stock(qty)

        for _ in range(qty):
            cart.append(item)

        print(f"Success: Added {qty}x {item.item} to cart.")

    except InvalidItemNumberError as err:
        print(f"[Lookup Failed] {err}")
    except OutOfStockError as err:
        print(f"[Stock Failure] {err}")


def checkout(cart_list: list) -> float:
    total = 0.0
    print("\n--- RECEIPT ---")
    for item in cart_list:
        item_cost = item.get_price(include_tax=True)
        print(f"- {item.get_item()}: ${item_cost:.2f}")
        total += item_cost

    print(f"Total (incl. tax): ${round(total, 2):.2f}")
    return round(total, 2)


class TestGroceryStore(unittest.TestCase):
    def setUp(self):
        self.inventory = {
            "MILK": GroceryItem("Milk", price=3.50, amount=2, refresh_interval_days=7),
            "BREAD": GroceryItem("Bread", price=2.00, amount=5, refresh_interval_days=3),
        }

    def test_valid_item_creation(self):
        item = GroceryItem("Apple", 1.50, 10, 7)
        self.assertEqual(item.item, "Apple")
        self.assertEqual(item.price, 1.50)
        self.assertEqual(item.amount, 10)

    def test_invalid_price_initialization(self):
        with self.assertRaises(ValueError):
            GroceryItem("Banana", price=-1.00, amount=5, refresh_interval_days=5)

    def test_invalid_amount_initialization(self):
        with self.assertRaises(ValueError):
            GroceryItem("Orange", price=1.00, amount=-3, refresh_interval_days=5)

    def test_non_numeric_initialization(self):
        with self.assertRaises(TypeError):
            GroceryItem("Grape", price="abc", amount=5, refresh_interval_days=5)

    def test_alter_price_valid(self):
        item = self.inventory["MILK"]
        item.alter_price(0.50)
        self.assertEqual(item.price, 4.00)

    def test_alter_price_negative_floor(self):
        item = self.inventory["MILK"]
        item.alter_price(-10.00)
        self.assertEqual(item.price, 0.0)

    def test_decrement_stock_success(self):
        item = self.inventory["MILK"]
        item.decrement_stock(1)
        self.assertEqual(item.amount, 1)

    def test_decrement_stock_out_of_stock_error(self):
        item = self.inventory["MILK"]
        with self.assertRaises(OutOfStockError):
            item.decrement_stock(5)

    def test_decrement_stock_invalid_quantity(self):
        item = self.inventory["MILK"]
        with self.assertRaises(ValueError):
            item.decrement_stock(0)

    def test_get_price_with_and_without_tax(self):
        item = self.inventory["BREAD"]
        self.assertEqual(item.get_price(include_tax=False), 2.00)
        self.assertEqual(item.get_price(include_tax=True), 2.16)


if __name__ == "__main__":
    suite = unittest.TestLoader().loadTestsFromTestCase(TestGroceryStore)
    runner = unittest.TextTestRunner(verbosity=0)
    test_result = runner.run(suite)

    if test_result.wasSuccessful():
        inventory = {
            "OATS": GroceryItem("Oats", price=4.50, amount=15, refresh_interval_days=14),
            "BROCCOLI": GroceryItem("Broccoli", price=2.99, amount=20, refresh_interval_days=4),
            "APPLE": GroceryItem("Apple", price=1.20, amount=30, refresh_interval_days=7),
            "MILK": GroceryItem("Milk", price=3.50, amount=12, refresh_interval_days=5),
            "CHICKEN": GroceryItem("Chicken", price=9.50, amount=8, refresh_interval_days=3)
        }
        cart = []

        while True:
            display_items = [item.item for item in inventory.values()]
            print(f"\nAvailable Items: {', '.join(display_items)}")
            add_item_to_cart(inventory, cart)

            again = input("Add another item? (y/n): ").strip().lower()
            if again != 'y':
                break

        if cart:
            checkout(cart)
        else:
            print("\nCart is empty. Goodbye!")
