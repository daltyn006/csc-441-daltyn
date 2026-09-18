package week3fri

import kotlin.random.Random

fun main() {
    println("---Print Numbers---")
    for (idx in 1..10)
        print("$idx ")
    println()

    for (countdown in 20 downTo 1 step 3)
        print("$countdown ")

    println("\n -- Printing Lists -- \n")

    val packingList = mutableListOf<String>("Map", "Backpack", "Universal Axe", "Cooking Kit with Lighter")

    for (item in packingList)
        println("A $item would be smart to bring on a camping trip")
    println()
    packingList.forEachIndexed { index, string -> println("$index: $string") }
    println()
    for (item in 0 until packingList.size)
        println("$item: ${packingList[item]} ")

//    println("-- Weekday Challenge-- | days of the week conditional with explicit dates\n")
//    println("Enter the current day of the week:     ")
//    var day = readln().lowercase().trim()// lowercase --> .toLower && trim --> .Strip() in python
//    val weekdays = listOf(monday, tuesday, wednesday, thursday, friday, saturday, sunday)
//    while (true) {
//        if (day in weekdays) {
//            when (day) {
//                "monday" -> println("5 days until the weekend")
//                "tuesday" -> println("4 days until the weekend")
//                "wednesday" -> println("3 days until the weekend")
//                "thursday" -> println("2 days until the weekend")
//                "friday" -> println("1 day until the weekend")
//                else -> println("it is currently the weekend")
//            }; break
//        } else {
//            println("Day $day is not specified, please explicitly state full weekday.")
//            day = readln().lowercase()
//        }
//    }

    println("-- Weekday Challenge-- | days of the week conditional with explicit dates\n")
    println("Enter the current numerical day of the week:     ")
    var day = readln().toInt()// send string to integer hopefully
    val weekdays = listOf(1, 2, 3, 4, 5, 6, 7)
    while (true) {
        if (day in weekdays) {
            when (day) {
                1 -> println("it is Monday, 5 days until the weekend")
                2 -> println("it is Tuesday, 4 days until the weekend")
                3 -> println("it is Wednesday, 3 days until the weekend")
                4 -> println("it is Thursday, 2 days until the weekend")
                5 -> println("it is Friday, 1 day until the weekend")
                6, -> println("it is Saturday, 0 days until the weekend")
                else -> println("it is currently the holy day, enjoy the weekend")
            }; break
        } else {
            println("Day $day is not specified, please explicitly state a day of the week inclusively between 1 and 7.")
            day = readln().toInt()
        }
    }
    println("--Part 5-- | If conditional for val assignment")

    val roulette = Random.nextInt(1, 10)
    val bankAccount = if (roulette % 2 == 0) true else false
    if (bankAccount){
        println("Good job! You have money!")
    }else{
        println("Your luck's ran out. $day is not your lucky number")
    }

}
