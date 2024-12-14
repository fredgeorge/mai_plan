package com.maiplace

// Understands a constraint
interface Filter {
    infix fun availableSlots(day: CalendarDay): List<TimeSlot>
}