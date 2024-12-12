package com.maiplace.unittest

import com.maiplace.TimeSlot
import kotlinx.datetime.LocalTime


internal fun timeSlot(startHour: Int, endHour: Int) =
    TimeSlot(LocalTime(startHour, 0), LocalTime(endHour, 0))

internal fun timeSlots(startHour: Int, endHour: Int) =
    listOf(TimeSlot(LocalTime(startHour, 0), LocalTime(endHour, 0)))

internal fun time(hour: Int, minute: Int = 0) = LocalTime(hour, minute)