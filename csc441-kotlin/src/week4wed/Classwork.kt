fin main() {
    println( "Step 1 function returnng nothing")

    println("Step 2 funciton returning a value")
    println(todaysExercise1)
    println("Step 3 a parameter")
    println(todaysExercise2(3))
    prinln("Step 5default value" )
    println(todaysExercise4(2))
    //good practice to not use more than 7 parameters
    println(todaysExercise4(dayNumber=2))
    println(todaysExercise5(daynumber = 2, name = "Jamal"))

    println(todaysExercise5(daynumber = 5, name = "Jamaika"))
}

fun todaysExercise(){
    println("Today's Pushups")
}

fun todaysExercise1(): String {
    return "string"
}

fun todaysExercise2(daynumber: String): Int = when (daynumber){
    return when(daynumber){
        1 -> "Push Ups"
        2 -> "Running'"
        3 -> "Swimming"
        4 -> "Cycling"
        5 -> "Climbing"
        6 -> "Jim"
        else -> "Rest day"
    }
}

fun todaysExercise4(daynumber: Int =1): Int = when (daynumber){
    return when(daynumber){
        1 -> "Push Ups"
        2 -> "Running'"
        3 -> "Swimming"
        4 -> "Cycling"
        5 -> "Climbing"
        6 -> "Jim"
        else -> "Rest day"
    }


    fun todaysExercie5(daynumber: Int=0, name: String="you"){
        val exercise when(daynumber) {
            1 -> "Push Ups"
            2 -> "Running'"
            3 -> "Swimming"
            4 -> "Cycling"
            5 -> "Climbing"
            6 -> "Jim"
            else -> "Rest day"
        }
        return "$exercise, $you will do"
}