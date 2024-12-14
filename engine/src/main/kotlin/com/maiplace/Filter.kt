package com.maiplace

// Understands a constraint
interface Filter: Comparable<Filter> {
    infix fun availableSlots(day: CalendarDay): List<TimeSlot>
    override fun compareTo(other: Filter) = this.precedence.compareTo(other.precedence)
    val precedence: Int
}