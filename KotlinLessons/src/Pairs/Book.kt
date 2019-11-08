package Pairs

import java.util.*

fun main(args: Array<String>) {

    var book = Book()

    println("The book \"${book.getTitleAuthorYear().first}\" was written by ${book.getTitleAuthorYear().second} in ${book.getTitleAuthorYear().third}.")


    val allBooks = setOf("Macbeth", "Romeo and Juliet", "Hamlet", "A Midsummer Night's Dream")
    val library = mapOf("Shakespeare" to allBooks)
    println(library.any { it.value.contains("Hamlet") })


    val moreBooks = mutableMapOf<String, String>("Wilhelm Tell" to "Schiller")
    moreBooks.getOrPut("Jungle Book") { "Kipling" }
    moreBooks.getOrPut("Hamlet") { "Shakespeare" }
    println(moreBooks)


    println(book.borrowBook())
    println(book.borrowBook())
    println(book.borrowBook())
    println(book.borrowBook())

    book.printUrl()
    book.printUrl()


    val puppy = Puppy()
    val book2 = Book("Oliver Twist", "Charles Dickens", 1837, 540)

    println("${book2.title} weighs ${book2.weight()}.")

    while (book2.pages > 0) {
        puppy.playWithBook(book2)
        println("${book2.pages} left in ${book2.title}")
    }
    println("Sad puppy, no more pages in ${book2.title}. ")

    println("${book2.title} weighs ${book2.weight()}.")
}

class Book(var title: String = "Kotlin-Bootcamp", var author: String = "Google", var year: Int = 2019, var pages: Int = 100) {

    object Constants {
        const val BASE_URL = "http://www.turtlecare.net/"
    }

    companion object {
        const val MAXBOOKS = 5
        val BASE_URL = "http://www.turtlecare.net/"
    }

    private var borrowedBooks = 3

    fun getTitleAuthor(): Pair<String, String> {
        return Pair(title, author)
    }

    fun getTitleAuthorYear(): Triple<String, String, Int> {
        return Triple(title, author, year)
    }

    fun borrowBook(): Boolean {
        if (canBorrow()) {
            borrowedBooks++
            return true
        }
        return false
    }

    fun canBorrow(): Boolean {
        if (borrowedBooks < MAXBOOKS) {
            return true
        }
        return false
    }

    fun printUrl() {
        println(Constants.BASE_URL + title + ".html")
    }
}

fun Book.weight() : Double { return (pages * 1.5) }

fun Book.tornPages(torn: Int) = if (pages >= torn) pages -= torn else pages = 0

class Puppy() {
    fun playWithBook(book: Book) {
        book.tornPages(Random().nextInt(12))
    }
}