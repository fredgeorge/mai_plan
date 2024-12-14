package com.maiplace

import com.maiplace.TimeSlot.Companion.availableTimeSlot
import com.maiplace.TimeSlot.Companion.consolidate
import kotlinx.datetime.LocalDate
import java.time.DayOfWeek
import java.time.DayOfWeek.*

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

    fun timeSlots(filter: Filter = NullFilter) = filter.availableSlots(this)

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
    // Understands a constraint with fixed choices
    class DayFilter private constructor(private val days: List<DayOfWeek>): Filter {

        companion object {
            fun daysOfWeek(dayOfWeek: DayOfWeek, vararg days: DayOfWeek): DayFilter = DayFilter(listOf(dayOfWeek) + days)
            fun weekend(): Filter = daysOfWeek(SATURDAY, SUNDAY)
            fun weekday(): Filter = daysOfWeek(MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY)
        }
        override fun availableSlots(day: CalendarDay): List<TimeSlot> = if(day.date.dayOfWeek in days) day.availableTimeSlots else emptyList()
    }
    class TimeFilter(private val start: CalendarTime, private val end: CalendarTime): Filter {
        override fun availableSlots(day: CalendarDay): List<TimeSlot> {
            TODO("Not yet implemented")
        }

    }
    object NullFilter: Filter {
        override fun availableSlots(day: CalendarDay): List<TimeSlot> = day.availableTimeSlots
    }
}