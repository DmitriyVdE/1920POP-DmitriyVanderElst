import java.util.*

fun main (args: Array<String>) {
    println("Your fortune is: " + getFortuneCookie())
    println("\nYour fortune is: ${getFortuneCookieOnline()}")
}

fun getFortuneCookie() : String {
    val fortunes = listOf("You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune.")

    print("Enter your birthday: ")

    val birthday = readLine()?.toIntOrNull()

    return fortunes[ if (birthday != null) birthday.rem(fortunes.count()) else Random().nextInt(fortunes.count())]
}

fun getFortuneCookieOnline() : String {
    val fortunes = listOf( "You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends, because they are your greatest fortune.")
    print("\nEnter your birthday: ")
    val birthday = readLine()?.toIntOrNull() ?: 1
    return fortunes[birthday.rem(fortunes.size)]
}
