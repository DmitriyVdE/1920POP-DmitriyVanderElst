fun main(args: Array<String>) {
    println(whatShouldIDoToday("happy"))
}

fun whatShouldIDoToday(mood : String, weather : String ="sunny", temperature : Int = 24) : String {
    return when {
        goForWalk(mood, weather) -> "go for a walk"
        stayInBed(mood, weather, temperature) -> "stay in bed"
        goSwimming(temperature) -> "go swimming"
        else -> "Stay home and read."
    }
}


fun goForWalk(mood: String, weather: String) = mood == "happy" && weather == "sunny"
fun stayInBed(mood : String, weather: String, temperature: Int) = mood == "sad" && weather == "rainy" && temperature == 0
fun goSwimming(temperature: Int) = temperature > 35
