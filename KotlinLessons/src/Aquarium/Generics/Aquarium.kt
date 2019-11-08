package Aquarium.Generics

open class WaterSupply(var needsProcessed: Boolean)

class TapWater: WaterSupply(true) {
    fun addChemicalCleaners() {
        needsProcessed = false
    }
}

class FishStoreWater: WaterSupply(false)

class LakeWater: WaterSupply(true) {
    fun filter() {
        needsProcessed = false
    }
}

// By default T will be of type Any? which is a nullable any type.
// Make sure T can only be of type WaterSupply and all it's children (Top of hierarchy)
class Aquarium<out T: WaterSupply>(val waterSupply: T) {
    fun addWater(cleaner: Cleaner<T>) {
        if (waterSupply.needsProcessed) {
            cleaner.clean(waterSupply)
        }
        println("adding water from $waterSupply")
    }
}

// Extension function to check if the watersupply of aquarium is of given type
inline fun <reified R: WaterSupply> Aquarium<*>.hasWaterSupplyOfType() = waterSupply is R

interface Cleaner<in T: WaterSupply> {
    fun clean(waterSupply: T)
}

class TapWaterCleaner: Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }
}

class LakeWaterCleaner: Cleaner<LakeWater> {
    override fun clean(waterSupply: LakeWater) {
        waterSupply.filter()
    }
}

fun <T: WaterSupply> isWaterClean(aquarium: Aquarium<T>) {
    println("aquarium water is clean: ${aquarium.waterSupply.needsProcessed}")
}

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("item added")

inline fun <reified T: WaterSupply> WaterSupply.isOfType() = this is T

fun genericExample() {
    val aquarium = Aquarium(TapWater()) // will automatically set the type of Aquarium<T> to Aquarium<TapWater>
    aquarium.waterSupply.addChemicalCleaners()

    val lakeWaterCleaner = LakeWaterCleaner()
    val aquarium2 = Aquarium(LakeWater())
    aquarium2.waterSupply.filter()
    aquarium2.addWater(lakeWaterCleaner)

    val tapWaterCleaner = TapWaterCleaner()
    val aquarium3 = Aquarium(TapWater())
    addItemTo(aquarium3)
    aquarium3.addWater(tapWaterCleaner)

    isWaterClean(aquarium3)
    println(aquarium3.hasWaterSupplyOfType<TapWater>())
    println(aquarium3.waterSupply.isOfType<LakeWater>())
}

fun main(args: Array<String>) {
    genericExample()
}