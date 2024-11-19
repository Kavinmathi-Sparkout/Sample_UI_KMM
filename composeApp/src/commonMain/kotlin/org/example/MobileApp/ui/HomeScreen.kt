package org.example.MobileApp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kmp_sample_ui_design.composeapp.generated.resources.Res
import kmp_sample_ui_design.composeapp.generated.resources.logo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.example.MobileApp.common.values.colors
import org.example.MobileApp.common.values.string
import org.jetbrains.compose.resources.painterResource

@Composable
fun HomeScreen(navController: NavController) {
    // Drawer state and coroutine scope
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize()) {
        MainHomeContent()
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
fun MainHomeContent() {
    // Placeholder for the main screen content
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 60.dp, horizontal = 16.dp) // Adjust the padding based on your header height
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        // Your main content goes here
        Text(string.WELCOME_TO_FASHION,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            fontSize = 35.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally))

        Spacer(modifier = Modifier.height(8.dp))
        // Your main content goes here
        Text(string.BRAND,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            fontSize = 35.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally))

        Spacer(modifier = Modifier.height(24.dp))

        Image(
            painter = painterResource(Res.drawable.logo),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Your main content goes here
        Text(string.FASHION_DESC,
            fontSize = 18.sp)

    }
}

@Composable
fun NavigationDrawer(
    navController: NavController,
    drawerState: androidx.compose.material3.DrawerState,
    scope: CoroutineScope
) {
    // Set the constant title
    val title = string.FASHION_BRAND

    Box(modifier = Modifier.fillMaxSize()) {
        // Top bar with fixed title and menu icon
        Row(
            modifier = Modifier
                .background(colors.pink)
                .fillMaxWidth()
                .height(60.dp)
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title,
                color = Color.White,
                style = MaterialTheme.typography.h6
            )
            IconButton(onClick = { scope.launch { drawerState.open() } }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu",
                    tint = Color.White
                )
            }
        }

        // Right-aligned Drawer on top of the dimmed background
        if (drawerState.isOpen) {
            Box(
                modifier = Modifier
                    .fillMaxHeight() // Occupy the content's height
                    .width(250.dp) // Set the desired width of the drawer
                    .align(Alignment.TopEnd) // Align to the right side of the screen
                    .background(Color.White) // Background for the drawer content
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxHeight()
                ) {
                    // Drawer Header with arrow icon at TopEnd
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(colors.pink)
                            .height(60.dp)
                    ) {
                        IconButton(
                            onClick = { scope.launch { drawerState.close() } },
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(8.dp) // Padding for top-end alignment
                        ) {
                            Icon(
                                imageVector = Icons.Filled.ArrowForward,
                                contentDescription = "Close",
                                tint = Color.White
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    // Drawer Items with reduced font size
                    listOf("Home", "Shop","Cart","Product","About", "Contact","Transition").forEach { item ->
                        Text(
                            text = item,
                            color = Color.Black,
                            fontSize = 20.sp, // Reduced font size for drawer items
                            fontWeight = FontWeight.SemiBold,
                            fontStyle = FontStyle.Italic,
                            modifier = Modifier
                                .padding(vertical = 4.dp)
                                .clickable {
                                    scope.launch { drawerState.close() }
                                    navController.navigate(item.lowercase()) // Navigate to corresponding screen
                                    /*{
                                        popUpTo("shop") { inclusive = true }  // This will clear all screens above shop_screen
                                    }*/
                                }
                        )
                        Spacer(modifier = Modifier.height(15.dp)) // Reduced spacing between items
                    }
                }
            }
        }
    }
}
