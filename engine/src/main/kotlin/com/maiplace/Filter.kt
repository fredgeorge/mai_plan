package com.maiplace

import java.time.LocalDate

interface Filter {
    infix fun isMetBy(date: LocalDate): Boolean
    operator fun not() = NotFilter(this)
}