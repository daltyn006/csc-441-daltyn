package week3wed
//purpose: fulfill a needed requirement for lab
//inputs: favorite food as string
//outputs: many different unrelated strings including one that responds to users favorite foods
//assumptions: user does not attempt to inject malware into the readln.
fun main() {
    val myName = "Daltyn Landas"
    val myMajor = "Computer Science"
    val myFavoriteFood = "Red Herring"
    var majorCourseCount = 5

    println("---Section 1--- | Where am I?")

    println("my name is $myName, yo! I like $myFavoriteFood, yo! yeah- uh huh~ I know a little about $myMajor")
    println("I currently report having a knowledge in $myMajor of: $majorCourseCount")
    println("but at the end of the semester I will know: ${majorCourseCount + 1}")
    majorCourseCount += 2 //CYS is technically an aspect of computer science
    println("---Section 2--- | Food and numbers?")

    val aSentence = "Okay, dig it, wonderful!"
    val favoriteNumber = 27
    val piShort = 3.14159265358979
    var theTruth = false

    println("I am going to guess your music taste: if $piShort is pi, and my lucky number is $favoriteNumber...\n\n then you must enjoy Rush.\n")
    println("I know how to count up to ${myName.length} and no further, which is the same as the characters in $myName")
    print("$aSentence and I enjoy $myFavoriteFood. What is your favorite food?\n Enter favorite food:   ")

    val realFavoriteFood = listOf("Fries", "Fry")
    val yourFavoriteFood = readlnOrNull()


    // func found while trying to figure out how to get an array
    // to lower tandem to prompt so that any responses
    // given actually changes the outcome in certain cases
    // e.g. if "realFavoriteFood[0] or [1]" is input -> then
    // if condition met, else: I don't like your food.
    if (realFavoriteFood.any{ it.equals(yourFavoriteFood, ignoreCase = true) }) {
        println("Why is your favorite food $yourFavoriteFood ? that is actually objectively ${!theTruth} ")
    }else if(yourFavoriteFood == null || yourFavoriteFood == ""){
        println("Well that's probably not an American food!🤠")
    }else {
        println("Well $yourFavoriteFood does vary in taste, but it's objectively $theTruth compared to ${realFavoriteFood[1]}")
    }
}
