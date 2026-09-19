package week4fri

fun main() {
    println("Step 1 | Two kinds of string.\n")

    val firstName: String = "Daltyn"
    val middleName: String? = "Checke"
    println(firstName.length)
    println(middleName?.length)


    println("\n\n Step 2 | Safe Call \n")

    println(middleName?.length)


    println("\n\nStep 3 | Elvis \n")

    println(middleName?.length ?: 0)
//    dead code but still used:
//    if (middleName == null) {
//        println("0")
//    } else{ println(middleName.length)}}


    println("\n\nStep 4 | let\n")

    middleName?.let {
        println("My middle name is $it")
    }


    println("\n\nStep 5 | The risky one\n")

    val maybeNumber: Int? = 0                                   // never really use this
    println(maybeNumber!! + 1)                                  // Do it anyways


    println("\n\nStep 6 | where nulls actually come from\n")

    val notANumber = "Chocolate".toIntOrNull()
    println(notANumber ?: "that was a NOT a number")             // ?: -> elvis operator

    val capitals = mapOf("France" to "Paris", "Japan" to "Tokyo")
    println(capitals["Canada"] ?: "off the grid")

    val emptyList = listOf<Int>()
    println(emptyList.maxOrNull() ?: "empty list")


    println("\n\nStep 7 | List and MutableList\n")

    val shoppingList = listOf("Cookies", "Ice Cream", "Soda")
    val toDoList = mutableListOf("Homework", "Chores", "Laundry")

    toDoList.add("Dishes")
    toDoList.remove("Laundry")
    println(shoppingList)
    println(toDoList)
    println("Items: ${toDoList.size}")


    println("\n\nStep 8 | things Lists can do\n")

    val scores = mutableListOf(34, 54, 59, 80)
    println(scores.sum())
    println(scores.average())
    println(scores.maxOrNull())
    println(scores.sorted())
    println(scores.filter { it in 55..70 })

}

