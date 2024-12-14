package com.maiplace.unittest

import com.maiplace.AM
import com.maiplace.CalendarDay
import com.maiplace.CalendarDay.DayFilter
import com.maiplace.TimeSlot
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class CalendarDayTest {

    @Test
    fun `Time Slots`() {
        assertEquals(timeSlots(4, 24), CalendarDay("2024-12-10").timeSlots(DayFilter.weekday()))
        assertEquals(emptyList<TimeSlot>(), CalendarDay("2024-12-07").timeSlots(DayFilter.weekday()))
        assertEquals(timeSlots(4, 24), CalendarDay("2024-12-10").timeSlots())
        assertEquals(timeSlots(4, 24), CalendarDay("2024-12-10").timeSlots())
        assertEquals(timeSlots(7, 21), CalendarDay("2024-12-10", time(7), time(21)).timeSlots())
    }

    @Test
    fun appointments() {
        CalendarDay("2024-12-10", 4.AM, 12.AM).also {
            it.book(timeSlot(10, 12))
            assertEquals(1, it.appointments().size)
            assertThrows<IllegalArgumentException> { it.book(timeSlot(10, 12)) }
            assertEquals(2, it.timeSlots().size)
            it.book(timeSlot(13, 14))
            assertEquals(3, it.timeSlots().size)
            assertEquals(2, it.appointments().size)
        }
    }

    @Test
    fun `cancel only appointment`() {
        CalendarDay("2024-12-10", 4.AM, 12.AM).also { day ->
            day.book(timeSlot(10, 12)).also { appointment ->
                assertEquals(1, day.appointments().size)
                assertEquals(2, day.timeSlots().size)
                appointment.cancel()
                assertEquals(0, day.appointments().size)
                assertEquals(1, day.timeSlots().size)
            }
        }
    }

    @Test
    fun `cancel one appointment`() {
        CalendarDay("2024-12-10", 4.AM, 12.AM).also { day ->
            day.book(timeSlot(10, 11))
            day.book(timeSlot(11, 12)).also { appointment ->
                assertEquals(2, day.appointments().size)
                assertEquals(2, day.timeSlots().size)
                appointment.cancel()
                assertEquals(1, day.appointments().size)
                assertEquals(2, day.timeSlots().size)
            }
        }
    }
}