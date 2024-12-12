package com.maiplace

import com.maiplace.TimeSlot.Companion.availableTimeSlot
import kotlinx.datetime.LocalDate

class CalendarDay(
    private val date: LocalDate,
    start: CalendarTime = 4.AM,
    end: CalendarTime = 12.PM
) {
    private val availableTimeSlots = listOf(TimeSlot(start, end))

    constructor(
        dateString: String,
        start: CalendarTime = 4.AM,
        end: CalendarTime = 12.PM
    ): this(LocalDate.parse(dateString), start, end)

    fun timeSlots(filter: Filter = Filter.TrueFilter) =
        if (filter isMetBy date) availableTimeSlots else emptyList()

    fun book(timeSlot: TimeSlot) = Appointment(availableTimeSlots.availableTimeSlot(timeSlot))
}