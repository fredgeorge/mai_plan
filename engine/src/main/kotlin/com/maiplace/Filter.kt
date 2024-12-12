package com.maiplace

import kotlinx.datetime.LocalDate

// Understands a constraint
interface Filter {
    infix fun isMetBy(date: LocalDate): Boolean
    operator fun not() = NotFilter(this)
    object TrueFilter: Filter {
        override fun isMetBy(date: LocalDate) = true
    }
}