package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int): Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int = when {
        year - other.year != 0 -> year - other.year
        month - other.month != 0 -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(
        override val start: MyDate,
        override val endInclusive: MyDate): ClosedRange<MyDate>, Iterable<MyDate> {

    override fun iterator(): Iterator<MyDate> {

        return object : Iterator<MyDate> {
            var current: MyDate = start

            override fun hasNext(): Boolean = current <= endInclusive

            override fun next(): MyDate {
                val next = current
                current = current.nextDay()
                return next
            }
        }
    }
}
