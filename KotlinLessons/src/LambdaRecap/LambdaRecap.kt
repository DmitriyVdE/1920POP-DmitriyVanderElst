package LambdaRecap

fun main (args: Array<String>) {
    println(waterFilter(30))

    val myFish = listOf(Fish("Flipper"), Fish("Moby Dick"), Fish("Dory"))
    println(myFish.filter{it.name.contains("i")}.joinToString(" "){it.name})

    val theGame = Game()
    println(theGame.path)
    theGame.north()
    theGame.south()
    theGame.east()
    theGame.west()
    theGame.end()
    println(theGame.path)

    val game = Game()
    while (true) {
        print("Enter a direction: n/s/e/w: ")
        game.makeMove(readLine())
    }
}

val waterFilter = {dirty: Int -> dirty / 2 }

data class Fish (val name: String)

enum class Direction { NORTH, SOUTH, EAST, WEST, START, END }

class Game() {
    var path = mutableListOf<Direction>(Direction.START)
    val north = {path.add(Direction.NORTH)}
    val south = {path.add(Direction.SOUTH)}
    val east = {path.add(Direction.EAST)}
    val west = {path.add(Direction.WEST)}
    val end = {path.add(Direction.END); println("Game Over:"); print(path); path.clear(); false}

    fun move(where: () -> Boolean ) {
        where.invoke()
    }

    fun makeMove(command:String?) {
        if (command.equals("n")) move(north)
        else if (command.equals("s")) move(south)
        else if (command.equals("e")) move(east)
        else if (command.equals("w")) move(west)
        else move(end)
    }
}