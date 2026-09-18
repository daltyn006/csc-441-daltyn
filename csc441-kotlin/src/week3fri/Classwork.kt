#!/usr/bin/env kotlin

package week3fri

fun main() {
    for (i in 1..5) {
        print("$i ")
    }
    println()
    for (letter in 'a'..'e') {
        print("$letter ")
    }
    println()
    for (i in 10 downTo 1) {
        print("$i ")
    }
    println()
    for (i in 0..100 step 25) {
        print("$i ")
    }
    println()
    val shoppingList = mutableListOf("Meat", "Treat", "Wheat")
    for (item in shoppingList) {
        println(item)
    }
    for ((index, item) in shoppingList.withIndex()) {
        println("$index: $item")
        shoppingList.forEachIndexed { index, item ->
            println("$index is $item")
        }
        for (i in 0 until shoppingList.size) {
            println("$i: ${shoppingList[i]}")
        }
        val day = "Tuesday"
        when (day) {
            "Monday" -> println("5 days till weekend")
            "Tuesday" -> println("4 days till weekend")
            "Wednesday" -> println("3 days till weekend")
            else -> println("weekend is close")
        }
        val age = 40
        val amIOld = when (age) {
            in 1..50 -> false
            in 20..100 -> true
            else -> true
        }
        println(amIOld)
        val years = 10
        val level = if (years > 20) "Senior" else "Junior"
        println(level)
    }
}
