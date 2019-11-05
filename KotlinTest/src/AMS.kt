import java.util.*

fun main(args: Array<String>) {
    println("Hello, ${args[0]}!")

    dayOfWeek()

    val isUnit = println("This is an expression")
    println(isUnit)

    val temperature = 10
    val isHot = if (temperature > 50 ) true else false
    println( isHot )

    val message = "You are ${ if (temperature > 50) "fried" else "safe"} fish"
    println(message)
}

fun dayOfWeek() {
    println("What day is it today?")
    val today = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    println( when (today) {
        1 -> "Sunday"
        2 -> "Monday"
        3 -> "Tuesday"
        4 -> "Wednesday"
        5 -> "Thursday"
        6 -> "Friday"
        7 -> "Saturday"
        else ->  "Time has stopped!"
    })
}