package com.maiplace.unittest

import com.maiplace.CalendarDay
import com.maiplace.MultipleChoiceFilter
import com.maiplace.TimeSlot
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CalendarDayTest {

    @Test
    fun `Time Slots` () {
        assertEquals(
            listOf(TimeSlot(LocalTime(4, 0), LocalTime(0, 0))),
            CalendarDay(LocalDate.parse("2024-12-10")).timeSlots(MultipleChoiceFilter.weekday())
        )
        assertEquals(
            emptyList<TimeSlot>(),
            CalendarDay(LocalDate.parse("2024-12-07")).timeSlots(MultipleChoiceFilter.weekday())
        )
        assertEquals(
            listOf(TimeSlot(LocalTime(4, 0), LocalTime(0, 0))),
            CalendarDay(LocalDate.parse("2024-12-10")).timeSlots()
        )
        assertEquals(
            listOf(TimeSlot(LocalTime(4, 0), LocalTime(0, 0))),
            CalendarDay("2024-12-10").timeSlots()
        )
        assertEquals(timeSlots(4, 0), CalendarDay("2024-12-10").timeSlots())
        assertEquals(
            timeSlots(7, 21),
            CalendarDay("2024-12-10", LocalTime(7, 0), LocalTime(21, 0)).timeSlots()
        )
    }

    private fun timeSlots(startHour: Int, endHour: Int) =
        listOf(TimeSlot(LocalTime(startHour, 0), LocalTime(endHour, 0)))
}