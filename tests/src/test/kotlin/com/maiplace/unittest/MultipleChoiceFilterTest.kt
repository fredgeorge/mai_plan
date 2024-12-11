package com.maiplace.unittest

import com.maiplace.MultipleChoiceFilter
import com.maiplace.NotFilter
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import java.time.DayOfWeek.MONDAY
import java.time.DayOfWeek.TUESDAY
import java.time.LocalDate

class MultipleChoiceFilterTest {

    @Test
    fun `Day Of Week`() {
        assert(MultipleChoiceFilter.daysOfWeek(TUESDAY) isMetBy LocalDate.parse("2024-12-10"))
        assertFalse(MultipleChoiceFilter.daysOfWeek(MONDAY) isMetBy LocalDate.parse("2024-12-10"))
    }

    @Test
    fun `Weekend or Weekday`() {
        assert(MultipleChoiceFilter.weekend() isMetBy LocalDate.parse("2024-12-07"))
        assertFalse(MultipleChoiceFilter.weekend() isMetBy LocalDate.parse("2024-12-10"))
        assertFalse(MultipleChoiceFilter.weekday() isMetBy LocalDate.parse("2024-12-07"))
        assert(MultipleChoiceFilter.weekday() isMetBy LocalDate.parse("2024-12-10"))
    }

    @Test
    fun `Not Filter`() {
        assert(NotFilter(MultipleChoiceFilter.weekend()) isMetBy LocalDate.parse("2024-12-10"))
    }
}