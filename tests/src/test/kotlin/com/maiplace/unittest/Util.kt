package com.maiplace.unittest

import com.maiplace.CalendarTime
import com.maiplace.TimeSlot

internal fun timeSlot(startHour: Int, endHour: Int) =
    TimeSlot(CalendarTime(startHour), CalendarTime(endHour))

internal fun timeSlots(startHour: Int, endHour: Int) =
    listOf(timeSlot(startHour, endHour))

internal fun time(hour: Int, minute: Int = 0) = CalendarTime(hour, minute)