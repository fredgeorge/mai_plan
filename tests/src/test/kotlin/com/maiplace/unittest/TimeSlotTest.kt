package com.maiplace.unittest

import com.maiplace.TimeSlot
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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

    @Test
    fun blocking() {
        assertEquals(emptyList<TimeSlot>(), timeSlot(10, 12).block(timeSlot(10, 12)))
        assertEquals(listOf(timeSlot(11, 12)), timeSlot(10, 12).block(timeSlot(10, 11)))
        assertEquals(listOf(timeSlot(10, 11)), timeSlot(10, 12).block(timeSlot(11, 12)))
        assertEquals(listOf(timeSlot(4, 10), timeSlot(12, 24)), timeSlot(4, 24).block(timeSlot(10, 12)))
    }

    @Test
    fun validate() {
        assertThrows<IllegalArgumentException> { timeSlot(4, 0) }
    }
}