package org.example.MobileApp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun ShopScreen (navController: NavController) {
    // Drawer state and coroutine scope
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize()) {
        // Main Content (Separate from the drawer)
        MainShopContent()

        // Dimmed background when the drawer is open
        if (drawerState.isOpen) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent.copy(alpha = 0.3f)) // Semi-transparent overlay
            )
        }

        // Navigation Drawer (Overlays on top when open)
        NavigationDrawer(navController, drawerState, scope)

    }
}

@Composable
fun MainShopContent() {
    // Placeholder for the main screen content
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Your main content goes here
        Text("Shop Screen Content", modifier = Modifier.align(Alignment.Center))
    }
}