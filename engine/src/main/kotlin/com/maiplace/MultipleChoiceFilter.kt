package com.maiplace

import java.time.DayOfWeek
import java.time.DayOfWeek.SATURDAY
import java.time.DayOfWeek.SUNDAY
import java.time.LocalDate

abstract class MultipleChoiceFilter: Filter {
    abstract override infix fun isMetBy(date: LocalDate): Boolean

    companion object {
        fun daysOfWeek(dayOfWeek: DayOfWeek): MultipleChoiceFilter = DayOfWeekFilter(dayOfWeek)
        fun weekend(): Filter = WeekendFilter()
        fun weekday(): Filter = NotFilter(WeekendFilter())
    }
}

internal class DayOfWeekFilter(private val dayOfWeek: DayOfWeek): MultipleChoiceFilter() {
    override fun isMetBy(date: LocalDate) = date.dayOfWeek == dayOfWeek
}

internal class WeekendFilter(): MultipleChoiceFilter() {
    override fun isMetBy(date: LocalDate) = date.dayOfWeek == SATURDAY || date.dayOfWeek == SUNDAY
}
