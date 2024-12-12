package com.maiplace

import kotlin.math.roundToInt

data class CalendarTime(private val hour: Int, private val minute: Int = 0) {
    init {
        require(hour in 0..24) {"Illegal Hour"}
        require(minute in 0..59) {"Illegal Minute"}
        if(hour == 24) require(minute == 0) {"Illegal time past midnight"}
    }
    operator fun compareTo(other: CalendarTime) =
        this.hour.compareTo(other.hour).let {
            if (it != 0) it
            else this.minute.compareTo(other.minute)
        }
}

val Number.AM: CalendarTime
    get() {
        val hour = this.toDouble().roundToInt()
        val minute = ((this.toDouble() - hour) * 100).roundToInt()
        return CalendarTime(hour + (if(hour == 12)12 else 0), minute)
    }
val Number.PM: CalendarTime
    get() {
        val hour = this.toDouble().roundToInt()
        val minute = ((this.toDouble() - hour) * 100).roundToInt()
        return CalendarTime(hour + (if(hour == 12)0 else 12), minute)
    }