package com.maiplace

import java.time.DayOfWeek
import java.time.DayOfWeek.SATURDAY
import java.time.DayOfWeek.SUNDAY
import java.time.LocalDate

// Understands a constraint with fixed choices
abstract class MultipleChoiceFilter: Filter {
    abstract override infix fun isMetBy(date: LocalDate): Boolean

    companion object {
        fun daysOfWeek(dayOfWeek: DayOfWeek, vararg days: DayOfWeek): MultipleChoiceFilter = DayOfWeekFilter(listOf(dayOfWeek) + days)
        fun weekend(): Filter = daysOfWeek(SATURDAY, SUNDAY)
        fun weekday(): Filter = NotFilter(weekend())
    }
}

internal class DayOfWeekFilter(private val days: List<DayOfWeek>): MultipleChoiceFilter() {
    override fun isMetBy(date: LocalDate) = date.dayOfWeek in days
}
