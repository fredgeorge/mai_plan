package com.maiplace

import kotlinx.datetime.LocalDate

class NotFilter internal constructor(private val filter: Filter) : Filter {
    override fun isMetBy(date: LocalDate) = !(filter isMetBy date)
}