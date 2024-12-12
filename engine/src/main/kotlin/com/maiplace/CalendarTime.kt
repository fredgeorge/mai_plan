package com.maiplace

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

val Int.PM get()= CalendarTime(this+12)
val Int.AM get() = CalendarTime(this)