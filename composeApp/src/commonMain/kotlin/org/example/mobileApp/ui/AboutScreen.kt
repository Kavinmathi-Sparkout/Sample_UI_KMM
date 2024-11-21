package org.example.mobileApp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.example.mobileApp.common.AppBar.AppBar
import org.example.mobileApp.common.values.string

@Composable
fun AboutScreen(navController: NavController) {

   /* // Listen for back press event and handle it
    val backStackEntry = remember { navController.currentBackStackEntryAsState() }

    // Make sure you're on the AboutScreen to handle back press
    LaunchedEffect(backStackEntry.value) {
        // When the back button is pressed, pop the current screen off the back stack
        navController.currentBackStackEntry?.destination?.let {
            if (it.route == "about") { // Make sure you are on the about screen
                navController.popBackStack() // Pops the AboutScreen
            }
        }
    }*/

    /*// Handle back navigation manually
    LaunchedEffect(Unit) {
        // Listen for the back press and navigate to Shop screen when back is pressed
        navController.addOnBackPressedDispatcher {
            navController.popBackStack("shop_screen", false)
        }
    }*/




    Column(modifier = Modifier.fillMaxSize()) {
        AppBar(navController)

        AboutCard(navController)
    }
}

@Composable
fun AboutCard(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp)
    ) {

        Text(
            text = string.ABOUT_DESC1,
            style = MaterialTheme.typography.body1,
            fontSize = 18.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = string.ABOUT_DESC2,
            style = MaterialTheme.typography.body1,
            fontSize = 18.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = string.ABOUT_DESC3,
            style = MaterialTheme.typography.body1,
            fontSize = 18.sp,
            color = Color.Black
        )
    }

}