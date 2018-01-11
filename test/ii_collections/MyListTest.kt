package ii_collections

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author asciarra
 */
class MyListTest {

    @Test(expected = NoSuchElementException::class)
    fun emptyListHead() {
        Nil.head()
    }

    @Test
    fun emptyListTail() {
        assertEquals(Nil, Nil.tail())
    }

    @Test
    fun nonEmptyListHead() {
        assertEquals(10, Cons(10, Nil).head())
    }

    @Test
    fun nonEmptyListTail() {
        assertEquals(Cons(10, Nil), Cons(11, Cons(10, Nil)).tail())
    }

    @Test
    fun addElementToEmptyList() {
        assertEquals(Cons(10, Nil), Nil.prepend(10))
    }

    @Test
    fun addElementToNonEmptyList() {
        val base = Cons(9, Nil)
        assertEquals(Cons(10, base), base.prepend(10))
    }

    @Test
    fun foldLeftOnEmptyList() {
        assertEquals(10, Nil.foldLeft(10, { a, _ -> a }))
    }
}
