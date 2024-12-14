package com.maiplace.unittest

import com.maiplace.CalendarDay
import com.maiplace.CalendarDay.DayFilter
import com.maiplace.TimeSlot
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.DayOfWeek.*

class DayFilterTest {

    @Test
    fun `Day Of Week`() {
        assertEquals(timeSlots(4, 24),DayFilter.daysOfWeek(TUESDAY) availableSlots CalendarDay("2024-12-10"))
        assertEquals(timeSlots(4, 24),DayFilter.daysOfWeek(TUESDAY, WEDNESDAY) availableSlots CalendarDay("2024-12-10"))
        assertEquals(timeSlots(4, 24), DayFilter.daysOfWeek(TUESDAY, WEDNESDAY) availableSlots CalendarDay("2024-12-11"))
        assertEquals(emptyList<TimeSlot>(), DayFilter.daysOfWeek(MONDAY) availableSlots CalendarDay("2024-12-10"))
    }

    @Test
    fun `Weekend or Weekday`() {
        assertEquals(timeSlots(4, 24),DayFilter.weekend() availableSlots CalendarDay("2024-12-07"))
        assertEquals(emptyList<TimeSlot>(),DayFilter.weekend() availableSlots CalendarDay("2024-12-10"))
        assertEquals(emptyList<TimeSlot>(), DayFilter.weekday() availableSlots CalendarDay("2024-12-07"))
        assertEquals(timeSlots(4, 24), DayFilter.weekday() availableSlots CalendarDay("2024-12-10"))
    }
}