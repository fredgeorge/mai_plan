package com.maiplace

class TimeSlot(private val start: CalendarTime, private val end: CalendarTime) {
    override fun equals(other: Any?) = this === other || other is TimeSlot && this.equals(other)
    private fun equals(other: TimeSlot) = this.start == other.start && this.end == other.end
    override fun hashCode() = start.hashCode() * 37 + end.hashCode()
    fun block(other: TimeSlot) =
        when {
            this == other -> emptyList()
            this.start == other.start -> listOf(TimeSlot(other.end, this.end))
            this.end == other.end -> listOf(TimeSlot(this.start, other.start))
            else -> listOf(TimeSlot(this.start, other.start), TimeSlot(other.end, this.end))
        }
    companion object {
        internal fun List<TimeSlot>.availableTimeSlot(timeSlot: TimeSlot) =
            this.firstOrNull { availableSlot -> timeSlot in availableSlot }?:throw IllegalArgumentException("No available Time Slot")

        internal fun MutableList<TimeSlot>.consolidate() {
            this.sortBy { it.start }
            this.consolidatedTimeSlots().also{
                this.clear()
                this.addAll(it)
            }
        }

        private fun List<TimeSlot>.consolidatedTimeSlots(): List<TimeSlot> {
            if(this.size == 1) return this
            return if(this[0].isAdjacent(this[1]))
                    (listOf(TimeSlot(this[0].start, this[1].end)) + this.subList(2, this.size)).consolidatedTimeSlots()
            else
                    (listOf(this[0]) + this.subList(1, this.size).consolidatedTimeSlots())
        }
    }

    private fun isAdjacent(other: TimeSlot) = this.end == other.start

    operator fun contains(other: TimeSlot) = this.start <= other.start && this.end >= other.end

    init {
        require(start < end) {"End must be after Start"}
    }

    override fun toString() = "From $start to $end"
}