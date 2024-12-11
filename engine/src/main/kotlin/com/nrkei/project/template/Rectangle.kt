package com.nrkei.project.template

// Understands a polygon with 4 sides at right angles
class Rectangle(width: Number, height: Number) {
    private val width = width.toDouble()
    private val height = height.toDouble()
    init {
        if(this.width <= 0.0 || this.height <= 0.0) throw IllegalArgumentException("Invalid Dimensions")
    }
    fun area() = width * height
    fun perimeter() = width * 2 + height * 2
}
