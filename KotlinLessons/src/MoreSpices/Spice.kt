package MoreSpices

fun main(args: Array<String>) {
    val curry = Curry("Special Curry", "spicy")

    curry.prepareSpice()

    val spiceCabinet = listOf(SpiceContainer(Curry("Yellow Curry", "mild")),
            SpiceContainer(Curry("Red Curry", "medium")),
            SpiceContainer(Curry("Green Curry", "spicy")))

    for(element in spiceCabinet) println(element.label)
}

data class SpiceContainer(var spice: Spice) {
    val label = spice.name
}

abstract class Spice(val name: String, val spiciness: String = "mild", color: SpiceColor) : SpiceColor by color {
    abstract fun prepareSpice()
}

class Curry(name: String, spiciness: String,
            color: SpiceColor = YellowSpiceColor) : Spice(name, spiciness, color), Grinder {

    init {
        println("Just made a curry with name \"${this.name}\" and with spiciness level \"${this.spiciness}\".")
    }

    override fun grind() {
        println("Grinding")
    }

    override fun prepareSpice() {
        grind()
    }
}

interface Grinder {
    fun grind()
}

enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF), YELLOW(0xFFFF00);
}

interface SpiceColor {
    val color: Color
}

object YellowSpiceColor : SpiceColor {
    override val color = Color.YELLOW
}