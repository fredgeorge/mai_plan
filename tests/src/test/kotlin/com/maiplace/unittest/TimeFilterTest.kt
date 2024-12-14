package com.maiplace.unittest

import com.maiplace.CalendarDay
import com.maiplace.CalendarDay.TimeFilter
import com.maiplace.TimeSlot
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TimeFilterTest {

    @Test
    fun `Single Calendar TimeSlot`() {
        assertEquals(timeSlots(4, 24), TimeFilter(timeSlot(4, 24)) availableSlots CalendarDay("2024-12-01"))
        assertEquals(timeSlots(9, 10), TimeFilter(timeSlot(9, 10)) availableSlots CalendarDay("2024-12-01"))
        assertEquals(emptyList<TimeSlot>(), TimeFilter(timeSlot(2, 3)) availableSlots CalendarDay("2024-12-01"))
    }

    @Test
    fun `Multiple Calendar TimeSlots`() {
        CalendarDay("2024-12-01").also { day ->
            day.book(timeSlot(10, 11))
            day.book(timeSlot(13, 14))
            assertEquals(3, day.timeSlots().size)
            assertEquals(listOf(timeSlot(9, 10), timeSlot(11, 13), timeSlot(14, 15)), TimeFilter(timeSlot(9, 15)) availableSlots day)
            assertEquals(listOf(timeSlot(9, 10), timeSlot(11, 13)), TimeFilter(timeSlot(9, 14)) availableSlots day)
        }
    }
}