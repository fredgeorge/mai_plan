package com.maiplace.unittest

import com.maiplace.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class CalendarDayTest {

    @Test
    fun `Time Slots` () {
        assertEquals(timeSlots(4, 24), CalendarDay("2024-12-10").timeSlots(DayFilter.weekday()))
        assertEquals(emptyList<TimeSlot>(), CalendarDay("2024-12-07").timeSlots(DayFilter.weekday()))
        assertEquals(timeSlots(4, 24), CalendarDay("2024-12-10").timeSlots())
        assertEquals(timeSlots(4, 24), CalendarDay("2024-12-10").timeSlots())
        assertEquals(timeSlots(7, 21), CalendarDay("2024-12-10", time(7), time(21)).timeSlots())
    }

    @Test
    fun appointments () {
        CalendarDay("2024-12-10", 4.AM, 12.PM).book(timeSlot(10, 12))
    }
}