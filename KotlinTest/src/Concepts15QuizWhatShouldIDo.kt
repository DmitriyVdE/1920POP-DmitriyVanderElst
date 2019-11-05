fun main(args: Array<String>) {
    println(whatShouldIDoTodayOnline("happy", "sunny"))
    println(whatShouldIDoTodayOnline("sad"))
    print("How do you feel?")
    println(whatShouldIDoTodayOnline(readLine()!!))
}

fun isVeryHot (temperature: Int) = temperature > 35
fun isSadRainyCold (mood: String, weather: String, temperature: Int) = mood == "sad" && weather == "rainy" && temperature == 0
fun isHappySunny (mood: String, weather: String) = mood == "happy" && weather == "sunny"

fun whatShouldIDoTodayOnline(mood: String, weather: String = "sunny", temperature: Int = 24) : String {
    return when {
        isVeryHot(temperature) -> "go swimming"
        isSadRainyCold(mood, weather, temperature) -> "stay in bed"
        isHappySunny(mood, weather) -> "go for a walk"
        else -> "Stay home and read."
    }
}