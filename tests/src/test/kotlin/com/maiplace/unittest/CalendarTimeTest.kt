package com.maiplace.unittest

import com.maiplace.AM
import com.maiplace.CalendarTime
import com.maiplace.CalendarTime.Companion.MIDNIGHT
import com.maiplace.CalendarTime.Companion.NOON
import com.maiplace.PM
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CalendarTimeTest {
    @Test
    fun comparison() {
        assertEquals(CalendarTime(10), CalendarTime(10))
        assert(CalendarTime(10) < CalendarTime(11))
        assert(CalendarTime(11) > CalendarTime(10))
        assert(CalendarTime(11) != CalendarTime(10))
        assertEquals(CalendarTime(11), 11.AM)
        assertEquals(CalendarTime(23), 11.PM)
        assertEquals(CalendarTime(23, 30), 11.30.PM)
        assertEquals(CalendarTime(11, 30), 11.30.AM)
        assertEquals(CalendarTime(24, 0), 12.AM)
        assertEquals(CalendarTime(12, 0), 12.PM)
        assertEquals(CalendarTime(12, 0), NOON)
        assertEquals(CalendarTime(24, 0), MIDNIGHT)
    }

    @Test
    fun validate() {
        assertThrows<IllegalArgumentException> { CalendarTime(-2) }
        assertThrows<IllegalArgumentException> { CalendarTime(24, 1) }
        assertThrows<IllegalArgumentException> { CalendarTime(10, 60) }
        assertThrows<IllegalArgumentException> { CalendarTime(10, -1) }
        assertThrows<IllegalArgumentException> { CalendarTime(25) }
        assertThrows<IllegalArgumentException> { 11.60.PM }
    }
}