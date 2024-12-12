package com.maiplace

import com.maiplace.TimeSlot.Companion.availableTimeSlot
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime

class CalendarDay(
    private val date: LocalDate,
    start: LocalTime = LocalTime(4, 0),
    end: LocalTime = LocalTime(0, 0)
) {
    private val availableTimeSlots = listOf(TimeSlot(start, end))

    constructor(
        dateString: String,
        start: LocalTime = LocalTime(4, 0),
        end: LocalTime = LocalTime(0, 0)
    ): this(LocalDate.parse(dateString), start, end)

    fun timeSlots(filter: Filter = Filter.TrueFilter) =
        if (filter isMetBy date) availableTimeSlots else emptyList()

    fun book(timeSlot: TimeSlot) = Appointment(availableTimeSlots.availableTimeSlot(timeSlot))
}