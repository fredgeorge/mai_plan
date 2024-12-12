package com.maiplace

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime

class CalendarDay(
    private val date: LocalDate,
    start: LocalTime = LocalTime(4, 0),
    end: LocalTime = LocalTime(0, 0)
) {
    private val timeSlots = listOf(TimeSlot(start, end))

    constructor(
        dateString: String,
        start: LocalTime = LocalTime(4, 0),
        end: LocalTime = LocalTime(0, 0)
    ): this(LocalDate.parse(dateString), start, end)

    fun timeSlots(filter: Filter = Filter.TrueFilter) =
        if (filter isMetBy date) timeSlots else emptyList()
}