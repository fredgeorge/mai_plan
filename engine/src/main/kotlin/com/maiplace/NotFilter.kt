package com.maiplace

import java.time.LocalDate

class NotFilter internal constructor(private val filter: Filter) : Filter {
    override fun isMetBy(date: LocalDate) = !(filter isMetBy date)
}