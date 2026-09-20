package week4fri

fun main (){
    //JESSE JORDAN
    println("\n\nStep 1 | String and Null\n")
    val absoluteString: String = "Full 12"
    val possibleString: String? = null
    println("${possibleString?: "Empty"}, $absoluteString")


    println("\n\nStep 2 | Safe Calls\n")
    println("String has: ${possibleString?.length} characters")
    println("I am $possibleString")


    println("\n\nStep 3 | Elvis Operators\n")
    println("I have an ${possibleString?: "empty"} string.")
    println("If this is empty try instead ${possibleString?: "to reassign"}")


    println("\n\nStep 4 | ?. let block\n")
    possibleString?.let { println("This is $it") }
    absoluteString?.let { println("This is $it") }  //"unnecessary safe call" warning


    println("\n\nStep 5 | toIntOrNull\n")
    println(absoluteString.toIntOrNull()?: "That was not an integer")
    println(absoluteString[absoluteString.length-1].digitToIntOrNull()?: "That was not an integer") // why does this need to be digit to int instead of int or null


    println("\n\nStep 6 and 7 | Lists\n")

    val mutableList = mutableListOf<String>("one", "two", "three", "four")
    val normalList = listOf<String>("is", "a", "normal", "list")

    println("$mutableList $normalList")
    mutableList.removeAt(2)
    println("$mutableList has ${mutableList.size} items")
    mutableList.add(1, "nine")
    println("$mutableList has ${mutableList.size} items")

    println("\n\nStep 8 | A list of Numbers\n")

    val aListOfNumbers = mutableListOf<Int>(1, 2, 3, 4, 5)
    println(aListOfNumbers.sumOf { it * 2 })
    println(aListOfNumbers.average())
    println(aListOfNumbers.filter { it % 2 == 0 })
    println(aListOfNumbers.filter { (it % 2) - 1 == 0 })
}