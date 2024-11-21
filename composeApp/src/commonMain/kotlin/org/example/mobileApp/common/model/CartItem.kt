package org.example.mobileApp.common.model

import org.jetbrains.compose.resources.DrawableResource

data class CartItem(
    val imageRes: DrawableResource  , // Resource ID for the image
    val title: String,
    val price: Double
)

