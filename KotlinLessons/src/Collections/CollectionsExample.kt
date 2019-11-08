package Collections

fun main(args: Array<String>) {

    val testList = listOf(11,12,13,14,15,16,17,18,19,20)

    // This works but is a slow solution, this can be done better with Kotlin Syntax
    println(reverseList(testList))

    // Uses Kotlin Syntax but is still a lot of code
    println(reverseListKotlin(testList))

    // Quick and easy, use a built-in function
    println(testList.reversed())
}

fun reverseList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (i in 0..list.size-1) {
        result.add(list[list.size-i-1])
    }
    return result
}

fun reverseListKotlin(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (i in list.size-1 downTo 0) {
        result.add(list.get(i))
    }
    return result
}