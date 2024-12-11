/*
 * Copyright (c) 2022 by Fred George
 * @author Fred George  fredgeorge@acm.org
 * Licensed under the MIT License; see LICENSE file in root.
 */

package com.nrkei.project.template

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

// Ensures Rectangle operates correctly
internal class RectangleTest {

    @Test
    fun area() {
        assertEquals(24.0, Rectangle(4.0, 6.0).area())
        assertEquals(24.0, Rectangle(4, 6).area())
    }

    @Test
    fun perimeter() {
        assertEquals(20.0, Rectangle(4.0, 6).perimeter())
    }

    @Test
    fun `valid dimensions`() {
        assertThrows<IllegalArgumentException> {Rectangle(0,6)  }
        assertThrows<IllegalArgumentException> {Rectangle(4,0)  }
    }
}