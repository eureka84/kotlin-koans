package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int = when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }

    operator fun plus(ri: RepeatedTimeInterval): MyDate = this.addTimeIntervals(ri.timeInterval, ri.times)
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

enum class TimeInterval(private val equivalentNumberOfDays: Int) {
    DAY(1),
    WEEK(7),
    YEAR(365);

    operator fun plus(that: TimeInterval): RepeatedTimeInterval =
            RepeatedTimeInterval(DAY, this.equivalentNumberOfDays + that.equivalentNumberOfDays)

    operator fun times(i: Int): RepeatedTimeInterval = RepeatedTimeInterval(this, i)

}

class RepeatedTimeInterval(val timeInterval: TimeInterval, val times: Int)

class DateRange(
        override val start: MyDate,
        override val endInclusive: MyDate) : ClosedRange<MyDate>, Iterable<MyDate> {

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
