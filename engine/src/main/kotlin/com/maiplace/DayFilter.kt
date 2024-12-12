package com.maiplace

import kotlinx.datetime.LocalDate
import java.time.DayOfWeek
import java.time.DayOfWeek.SATURDAY
import java.time.DayOfWeek.SUNDAY

// Understands a constraint with fixed choices
class DayFilter(private val days: List<DayOfWeek>): Filter {

    companion object {
        fun daysOfWeek(dayOfWeek: DayOfWeek, vararg days: DayOfWeek): DayFilter = DayFilter(listOf(dayOfWeek) + days)
        fun weekend(): Filter = daysOfWeek(SATURDAY, SUNDAY)
        fun weekday(): Filter = NotFilter(weekend())
    }
    override fun isMetBy(date: LocalDate) = date.dayOfWeek in days
}
