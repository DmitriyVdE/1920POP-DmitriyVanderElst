import java.util.*

fun main (args: Array<String>) {
    feedTheFish()

    //swim(50)
    //swim(20, speed = "slow")

    println(fitMoreFish(10.0, listOf(3,3,3)))
    println(fitMoreFish(8.0, listOf(2,2,2), hasDecorations = false))
    println(fitMoreFish(9.0, listOf(1,1,3), 3))
    println(fitMoreFish(10.0, listOf(), 7, true))
    println()
    println(canAddFish(10.0, listOf(3,3,3)))
    println(canAddFish(8.0, listOf(2,2,2), hasDecorations = false))
    println(canAddFish(9.0, listOf(1,1,3), 3))
    println(canAddFish(10.0, listOf(), 7, true))
    println()

    eagerExample()
}

var dirty = 20

val waterFilter: (Int) -> Int = { dirty -> dirty /2 }
fun feedFish(dirty: Int) = dirty + 10

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun dirtyProcessor() {
    dirty = updateDirty(dirty, waterFilter)
    dirty = updateDirty(dirty, ::feedFish)
    dirty = updateDirty(dirty, { dirty ->
        dirty + 50
    })
}

// Filter
fun eagerExample() {
    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flower pot", "pink grass")

    val eager = decorations.filter { it[0] == 'p' }
    println(eager)

    // apply filter lazily
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println(filtered)
    println(filtered.toList())

    // apply map lazily
    val lazyMap = decorations.asSequence().map {
        println("map $it")
        it
    }

    println(lazyMap)
    println("first: ${lazyMap.first()}")
    println("all: ${lazyMap.toList()}")
}

fun fitMoreFish(tankSize : Double, currentFish : List<Int>, fishSize : Int =2, hasDecorations: Boolean =true) : Boolean {
    var usable : Double = tankSize
    if (hasDecorations) {
        usable = (tankSize * 0.8)
    }

    var totalFish = 0.0
    if (currentFish != null) {
        for (fish in currentFish) {
            totalFish += fish
        }
    }

    if ((usable - totalFish) >= fishSize) {
        return true
    }

    return false
}

fun canAddFish(tankSize: Double, currentFish: List<Int>, fishSize: Int = 2, hasDecorations: Boolean = true): Boolean {
    return (tankSize * if (hasDecorations) 0.8 else 1.0) >= (currentFish.sum() + fishSize)
}

fun getDirtySensorReading() = 20

fun shouldChangeWater(
        day: String,
        temperature: Int = 22,
        dirty: Int = getDirtySensorReading()) : Boolean {

    // If in val/var declaration
    val isTooHot = temperature > 30
    val isDirty = dirty > 30
    val isSunday = day == "Sunday"

    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

// One line functions
fun isTooHot(temperature: Int) = temperature > 30
fun isDirty(dirty: Int) = dirty > 30
fun isSunday(day: String) = day == "Sunday"

fun makeNewAquarium() = println("Building a new aquarium......")

fun aquariumStatusReport(aquarium : Any = makeNewAquarium()) {

}

fun shouldChangeWater2(
    day: String,
    temperature: Int = 22,
    dirty: Int = 20
) {
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println ("Today is $day and the fish eat $food")
    shouldChangeWater(day, 20, 50)
    shouldChangeWater(day)
    shouldChangeWater(day, dirty=50)
    shouldChangeWater2(day="Monday")

    if (shouldChangeWater(day)) {
        println("Change the water today")
    }

    dirtyProcessor()
}

fun swim(time: Int, speed: String = "fast") {
    println("swimming $speed")
}

fun randomDay(): String {
    val week = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return (week[Random().nextInt(7)])
}

fun fishFood(day : String): String {
    return when (day) {
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "nothing"
    }
}
