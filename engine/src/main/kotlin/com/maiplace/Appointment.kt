package com.maiplace

class Appointment(private val day: CalendarDay, private val timeSlot: TimeSlot) {
    fun cancel() {
        day.remove(this, timeSlot)
    }
}
