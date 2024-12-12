package com.maiplace

import kotlinx.datetime.LocalTime

class TimeSlot(private val start: LocalTime, private val end: LocalTime) {
    override fun equals(other: Any?) = this === other || other is TimeSlot && this.equals(other)
    private fun equals(other: TimeSlot) = this.start == other.start && this.end == other.end
    override fun hashCode() = start.hashCode() * 37 + end.hashCode()
}