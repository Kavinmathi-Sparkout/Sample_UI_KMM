package org.example.studyApp.common.values

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

object colors {
    val primary = Color(0xFF1af1e8)
    val black = Color(0xFF1e191a)
    val gradient_blue = Color(0xFF00c1d0)
    val gradient_green = Color(0xFF00f77e)

    val primaryGradient = Brush.horizontalGradient(
        colors = listOf(gradient_green, gradient_blue)
    )
}