package com.maiplace

class AndFilter(vararg filters: Filter): Filter {
    private val filters = filters.toMutableList().sorted()
    override fun availableSlots(day: CalendarDay): List<TimeSlot> {
        TODO("Not yet implemented")
    }
    override val precedence = 2
}