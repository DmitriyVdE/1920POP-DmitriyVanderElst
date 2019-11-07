fun main(args: Array<String>) {
    if (args[1].toInt() < 12){
        println("Good morning, ${args[0]}!")
    } else {
        println("Good night, ${args[0]}.")
    }

    println("Good ${ if (args[1].toInt() < 12) "morning" else "night"}, ${args[0]}!")
}

