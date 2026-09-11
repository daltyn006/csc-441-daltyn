package week3wed
fun main() {

    println("CSC 441")
    print("Kotlin, first day")
    println()

    val course = "CSC 441"
    var weekNumber = 3

    weekNumber = weekNumber + 1
    println(course)
    println(weekNumber)

    val name = "Daltyn"
    val age = 20
    val gpa = 50
    val teaching = false

    println(name)
    println(age)
    println(gpa)
    println(teaching)
    println("$name teaches $course")
    println("Next year: ${age + 1}")
    println("Name length: ${name.length}")
    print("What's your name? ")

    val yourName = readlnOrNull()
    println("Hello, $yourName")
}