import java.util.*

fun main (args: Array<String>) {
    //println(rollDice(0))
    println(rollDice(10))
    println(rollDice(10))
    println(rollDice(10))
    println()
    println(rollDice0(0))
    println(rollDice0(10))
    println(rollDice0(10))
    println(rollDice0(10))
    println()
    println(rollDice2(0))
    println(rollDice2(10))
    println(rollDice2(10))
    println(rollDice2(10))
    println()

    gamePlay(rollDice2(10))
}

val rollDice = { sides: Int ->
    Random().nextInt(sides) + 1
}

val rollDice0 = { sides: Int ->
    if (sides == 0) 0
    else Random().nextInt(sides) + 1
}

val rollDice2: (Int) -> Int = { sides ->
    if (sides == 0) 0
    else Random().nextInt(sides) + 1
}

fun gamePlay(diceRoll: Int){
    // do something with the dice roll
    println(diceRoll)
}