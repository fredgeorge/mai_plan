package com.maiplace.unittest

import com.maiplace.TimeSlot
import kotlinx.datetime.LocalTime
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

class TimeSlotTest {

    @Test
    fun equals() {
        assertEquals(timeSlot(10, 12), timeSlot(10, 12))
        assertNotEquals(timeSlot(10, 12), timeSlot(3, 4))
        assertNotEquals(timeSlot(10, 12), Object())
        assertNotEquals(timeSlot(10, 12), null)
    }

    @Test
    fun hash() {
        assertEquals(1, listOf(timeSlot(10, 12), timeSlot(10, 12)).toSet().size)
    }

    private fun timeSlot(startHour: Int, endHour: Int) =
        TimeSlot(LocalTime(startHour, 0), LocalTime(endHour, 0))
}