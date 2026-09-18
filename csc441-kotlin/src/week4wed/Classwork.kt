fun main() {
    println("\n\nStep 1 | function returning nothing\n")
    whyDoesThisExist()

    println("\n\nStep 2 | function returning a value\n")
    println("This is a ${todaysExercise1()}")
    println("This is not a ${todaysExercise1()}")

    println("\n\nStep 3 | a parameter\n")
    println(" It is time to do ${todaysExercise2(3)}")
    println(" It is time to do ${todaysExercise2(4)}")
    
    println("\n\nStep 4 | short form\n")
    println("Today is ${todaysExercise3(3)} day")
    println("Today is ${todaysExercise3(9)} day")

    println("\n\nStep 5 | default value\n" )
    println(todaysExercicse4())
    println(todaysExercicse4(3))

    println("\n\n Step 6 | mutiple values\n")
    println(todaysExercicse5(2, "Delten"))
    println(todaysExercicse5(8, "Doltan"))
}

fun whyDoesThisExist(){
    println("I am a useless println")
}

fun todaysExercise1(): String {
    return "string"
}

fun todaysExercise2(dayNumber: Int): String{
    return when(dayNumber){
        1 -> "Push Ups"
        2 -> "Running'"
        3 -> "Swimming"
        4 -> "Cycling"
        5 -> "Climbing"
        6 -> "Jim"
        else -> "Rest day"
    }
}

fun todaysExercise3(dayNumber: Int): String = when(dayNumber){
        1 -> "Push Ups"
        2 -> "Running'"
        3 -> "Swimming"
        4 -> "Cycling"
        5 -> "Climbing"
        6 -> "Jim"
        else -> "Rest day"
    }

fun todaysExercicse4(dayNumber: Int = 6): String = when (dayNumber) {
    1 -> "Push Ups"
    2 -> "Running'"
    3 -> "Swimming"
    4 -> "Cycling"
    5 -> "Climbing"
    6 -> "Jim"
    else -> "Rest day"
}
fun todaysExercicse5(dayNumber: Int = 6, name: String="You"): String{
    val exercise = when (dayNumber){
        1 -> "Push Ups"
        2 -> "Running'"
        3 -> "Swimming"
        4 -> "Cycling"
        5 -> "Climbing"
        6 -> "Jim"
        else -> "Rest day"
    }
    return "$name; $dayNumber"
}