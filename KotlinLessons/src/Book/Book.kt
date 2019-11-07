package Book

open class Book(val title: String, val author: String) {

    private var currentPage = 1

    open fun readPage() { this.currentPage += 1 }
}

class eBook(title: String, author: String, var format: String = "text"): Book(title, author) {

    private var wordsRead = 0

    override fun readPage() { this.wordsRead += 250 }
}