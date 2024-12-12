package com.maiplace

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime

class CalendarDay(date: LocalDate) {
    companion object {
        private val defaultStart = LocalTime(4, 0)
        private val defaultEnd = LocalTime(0, 0)
    }
    fun timeSlots() = listOf(TimeSlot(defaultStart, defaultEnd))
}