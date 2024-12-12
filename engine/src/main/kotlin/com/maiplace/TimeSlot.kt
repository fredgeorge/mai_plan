package com.maiplace

import kotlinx.datetime.LocalTime

class TimeSlot(private val start: LocalTime, private val end: LocalTime) {
    override fun equals(other: Any?) = this === other || other is TimeSlot && this.equals(other)
    private fun equals(other: TimeSlot) = this.start == other.start && this.end == other.end
    override fun hashCode() = start.hashCode() * 37 + end.hashCode()
    fun block(other: TimeSlot) =
        when {
            this == other -> emptyList()
            this.start == other.start -> listOf(TimeSlot(other.end, this.end))
            this.end == other.end -> listOf(TimeSlot(this.start, other.start))
            else -> listOf(TimeSlot(this.start, other.start), TimeSlot(other.end, this.end))
        }
    companion object {
        internal fun List<TimeSlot>.availableTimeSlot(timeSlot: TimeSlot) =
            this.first { availableSlot -> timeSlot in availableSlot }
    }

    operator fun contains(other: TimeSlot) = this.start <= other.start && this.end >= other.end
}