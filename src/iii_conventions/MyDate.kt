package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int): Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int = when {
        year - other.year != 0 -> year - other.year
        month - other.month != 0 -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = todoTask27()

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate)
