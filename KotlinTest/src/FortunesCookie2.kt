import java.util.*

fun main (args: Array<String>) {
    val fortune : String
    fortune = getFortuneCookie2(getBirthday())
    println("\nYour fortune is: $fortune")
}

fun getBirthday() : Int {
    print("\nEnter your birthday: ")
    return readLine()?.toIntOrNull() ?: 1
}

fun getFortuneCookie2(birthday : Int) : String {
    val fortunes = listOf( "You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends, because they are your greatest fortune.")

    return when (birthday) {
        in 1..5 -> "The early bird gets the worm"
        20 -> "Smozzy fwa"
        27, 29 -> "Kloon of de 29e"
        else -> fortunes[birthday.rem(fortunes.size)]
    }
}
