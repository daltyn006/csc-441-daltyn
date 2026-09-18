package week4wed

fun main() {
    println("\n\n Step 1 | Describe Morning \n")
    describeToday()
    println("\n\n Step 2 | Favorite Thing \n")
    println(favoriteThing())
    println("\n\n Step 3 | Pick a line\n")
    println(pickOne(4))
    println("\n\n Step 4 | More quotes \n")
    println(pickOneShort(4))
    println("\n\n Step 5 | Movies\n")
    println(pickWithDefault())


}

fun describeToday(){
    println("Just waking up in the mornin' gotta thank God; I don't know but today seems kinda odd-")
}

fun favoriteThing(): String{
    return "no barking from the dog, no smog; and mama cooked the breakfast with no hog!"
}

fun pickOne(number: Int): String{
    return when(number){
        1 -> "Take your intergalactic asses back home! Back home!"
        2 -> "I don't have alien invasion insurance!"
        3 -> "They blew up my house, man."
        4 -> "You risked all of our lives just to spy on people's Amazon carts!"
        5 -> "HOW COULD YOU, MAN? HOW COULD YOU? MY OWN SON IS HACKING THE GOVERNMENT!"
        6 -> "Touchdown! Touchdown! TOUCHDOWN! Kiss my ass, Briggs!"
        7 -> "Alright, Disruptor. Let's disrupt some shit."
        else -> "Daughter: Dad, when's the last time you left the office? William: that's classified"
    }
}

fun pickOneShort(number: Int): String = when (number){
    1 -> "Where you at, light roast?"
    2 -> "Get your Rush Hour asses to class!"
    3 -> "Actions have consequences"
    4 -> "I'll see you at three o'clock"
    5 -> "COFFEE! (yelled at the machine thinking it's voice activated)"
    6 -> "We're gonna handle our differences like real men"
    7 -> "Campbell, packing lot after school. One man wins when the other one is unconscious."
    else -> "we are going to handle our differences"
}

fun pickWithDefault(number: Int = 4, boolean: Boolean = true): String {
    val movie = when (number){
        1 -> if (boolean) "Boyz n the Hood" else "Friday"
        2 -> if (boolean) "Barbershop" else "21 Jump Street"
        3 -> if (boolean) "Three Kings" else "Thicker Than Water"
        4 -> if (boolean) "War of Worlds" else "Fist Fight"
        else -> "Ice Cube is $boolean"
    }
    return movie
}







