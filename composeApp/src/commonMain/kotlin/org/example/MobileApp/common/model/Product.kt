package org.example.MobileApp.common.model

import org.jetbrains.compose.resources.DrawableResource

data class Product(
    val imageRes: DrawableResource,  // Drawable resource ID for the image
    val title: String,
    val description: String,
    val price: Double
)
