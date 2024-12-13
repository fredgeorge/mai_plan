package com.maiplace

import com.maiplace.TimeSlot.Companion.availableTimeSlot
import com.maiplace.TimeSlot.Companion.consolidate
import kotlinx.datetime.LocalDate

class CalendarDay(
    private val date: LocalDate,
    start: CalendarTime = 4.AM,
    end: CalendarTime = 12.AM
) {
    private val availableTimeSlots = mutableListOf(TimeSlot(start, end))
    private val appointments = mutableListOf<Appointment>()

    constructor(
        dateString: String,
        start: CalendarTime = 4.AM,
        end: CalendarTime = 12.AM
    ): this(LocalDate.parse(dateString), start, end)

    fun timeSlots(filter: Filter = Filter.TrueFilter) =
        if (filter isMetBy date) availableTimeSlots else emptyList()

    fun book(timeSlot: TimeSlot): Appointment {
        availableTimeSlots.availableTimeSlot(timeSlot).also { selectedTimeSlot ->
            availableTimeSlots.remove(selectedTimeSlot)
            availableTimeSlots.addAll(selectedTimeSlot.block(timeSlot))
            return Appointment(this, timeSlot).also {appointments.add(it)}
        }
    }

    fun appointments(): List<Appointment> {
        return appointments.toList()
    }

    fun remove(appointment: Appointment, timeSlot: TimeSlot) {
        appointments.remove(appointment)
        availableTimeSlots.add(timeSlot).also { availableTimeSlots.consolidate() }
    }
}