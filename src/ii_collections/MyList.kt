package ii_collections

/**
 * @author asciarra
 */
interface MyList<T> {
    fun head(): T
    fun tail(): MyList<T>
    fun prepend(elem: T): MyList<T>
    fun <R> foldLeft(initial: R, operation: (acc: R, elem: T) -> R): R
}

object Nil: MyList<Any> {
    override fun head(): Any {
        throw NoSuchElementException()
    }
    override fun tail(): MyList<Any> = this
    override fun prepend(elem: Any): MyList<Any> = Cons(elem, Nil)
    override fun <R> foldLeft(initial: R, operation: (acc: R, elem: Any) -> R): R = initial
}

data class Cons<T>(private val head: T, private val tail: MyList<T>): MyList<T> {
    override fun head(): T = head
    override fun tail(): MyList<T> = tail
    override fun prepend(elem: T): MyList<T> = Cons(elem, this)
    override fun <R> foldLeft(initial: R, operation: (acc: R, elem: T) -> R): R {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
