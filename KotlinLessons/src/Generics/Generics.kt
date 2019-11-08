package Generics

class MyIntList {
    fun get(post: Int): Int { return 0 }
    fun addItem(item: Int) { }
}

class MyShortList {
    fun get(post: Int): Short { return 0 }
    fun addItem(item: Short) { }
}

// In stead of making a list for every type, use generic types
class MyList<T> {
    fun get(pos: Int): T {
        TODO("implement")
    }
    fun addItem(item: T) {}
}

fun workWithMyList() {
    val stringList: MyList<String>
    val intList: MyList<Int>
}
