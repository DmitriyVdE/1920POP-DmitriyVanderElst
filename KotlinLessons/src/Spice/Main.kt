package Spice

fun main (args: Array<String>) {
    val simpleSpice = SimpleSpice()
    println("${simpleSpice.name} is ${simpleSpice.spiciness}")

    val spices1 = listOf(
            Spice("curry", "mild"),
            Spice("pepper", "medium"),
            Spice("cayenne", "spicy"),
            Spice("ginger", "mild"),
            Spice("red curry", "medium"),
            Spice("green curry", "mild"),
            Spice("hot pepper", "extremely spicy")
    )

    val spice = Spice("cayenne", spiciness = "spicy")

    val spicelist = spices1.filter {it.heat < 5}

    fun makeSalt() = Spice("Salt")
}