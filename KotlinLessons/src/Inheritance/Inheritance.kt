package Inheritance

fun main(args: Array<String>) {
    delegate()
}

fun delegate() {
    val pleco = Plecostomus()
    println("Fish has color ${pleco.color}")
    pleco.eat()
}

interface FishAction {
    fun eat()
}

interface FishColor {
    val color: String
}

class Plecostomus:
        FishAction by PrintFishAction("A lot of algae"),
        FishColor by GoldColor {
    override fun eat() {
        println("eat algae")
    }

    override val color: String
        get() = "gold"
}

object GoldColor: FishColor {
    override val color = "gold"
}

object RedColor: FishColor {
    override val color = "red"
}

class PrintFishAction(val food: String): FishAction {
    override fun eat() {
        println(food)
    }
}



/*
interface AquariumAction {
    fun eat()
    fun jump()
    fun clean()
    fun catchFish()
    fun swim() {
        println("swim")
    }
}
*/

/*
interface FishAction {
    fun eat()
}
*/

/*
abstract class AquariumFish: FishAction {

    abstract val color: String
    override fun eat() = println("yum")
}
*/