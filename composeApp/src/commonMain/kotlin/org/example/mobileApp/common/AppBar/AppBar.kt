package org.example.mobileApp.common.AppBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kmp_sample_ui_design.composeapp.generated.resources.Res
import kmp_sample_ui_design.composeapp.generated.resources.background
import org.jetbrains.compose.resources.painterResource

@Composable
fun AppBar(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {
        // Background image
        Image(
            painter = painterResource(Res.drawable.background), // Replace with your image resource
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp),
            contentScale = ContentScale.Crop
        )

        Icon(
            imageVector = Icons.Default.ArrowBack, // Use the default arrow back icon
            contentDescription = "Back",
            tint = Color.Black, // Set the color of the icon
            modifier = Modifier.padding(16.dp).align(Alignment.TopStart).clickable {
                navController.popBackStack() // Navigate back to the previous screen
            }
        )
    }
}
