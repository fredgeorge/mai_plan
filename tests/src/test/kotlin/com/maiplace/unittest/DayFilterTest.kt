package com.maiplace.unittest

import com.maiplace.DayFilter
import kotlinx.datetime.LocalDate
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import java.time.DayOfWeek.MONDAY
import java.time.DayOfWeek.TUESDAY
import java.time.DayOfWeek.WEDNESDAY


class DayFilterTest {

    @Test
    fun `Day Of Week`() {
        assert(DayFilter.daysOfWeek(TUESDAY) isMetBy LocalDate.parse("2024-12-10"))
        assert(DayFilter.daysOfWeek(TUESDAY, WEDNESDAY) isMetBy LocalDate.parse("2024-12-10"))
        assert(DayFilter.daysOfWeek(TUESDAY, WEDNESDAY) isMetBy LocalDate.parse("2024-12-11"))
        assertFalse(DayFilter.daysOfWeek(MONDAY) isMetBy LocalDate.parse("2024-12-10"))
    }

    @Test
    fun `Weekend or Weekday`() {
        assert(DayFilter.weekend() isMetBy LocalDate.parse("2024-12-07"))
        assertFalse(DayFilter.weekend() isMetBy LocalDate.parse("2024-12-10"))
        assertFalse(DayFilter.weekday() isMetBy LocalDate.parse("2024-12-07"))
        assert(DayFilter.weekday() isMetBy LocalDate.parse("2024-12-10"))
    }

    @Test
    fun `Not Filter`() {
        assert(!(DayFilter.weekend()) isMetBy LocalDate.parse("2024-12-10"))
    }
}