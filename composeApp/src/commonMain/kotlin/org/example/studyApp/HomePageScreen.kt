package org.example.studyApp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import org.example.studyApp.common.CardScreen
import org.example.studyApp.common.values.colors
import org.example.studyApp.common.values.string

@Composable
fun HomePageScreen(navController: NavHostController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    // State to hold the title
    val title = remember { mutableStateOf(string.STUDY_PAL) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            // Drawer content with black background
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
                    .padding(16.dp)
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Menu Item 1",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
                Text(
                    text = "Menu Item 2",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
                // Add more menu items here
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    modifier = Modifier.background(colors.primaryGradient),
                    title = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween // Add space between items
                        ) {
                            IconButton(onClick = {
                                scope.launch {
                                    if (drawerState.isClosed) {
                                        drawerState.open()
                                        title.value = "Menu" // Update title to "Menu" when opening the drawer
                                    } else {
                                        drawerState.close()
                                        title.value = string.STUDY_PAL // Restore title when closing
                                    }
                                }
                            }) {
                                Icon(
                                    imageVector = if (drawerState.isClosed) Icons.Filled.Menu else Icons.Filled.ArrowBack,
                                    contentDescription = if (drawerState.isClosed) "Open Menu" else "Close Menu",
                                    tint = Color.White
                                )
                            }
                            Text(
                                text = title.value,
                                color = Color.White
                            )
                            // Add a placeholder for the profile icon
                            IconButton(onClick = { /* TODO: Handle profile icon click */ }) {
                                Icon(
                                    imageVector = Icons.Filled.AccountCircle, // Use an appropriate profile icon
                                    contentDescription = "Profile",
                                    tint = Color.White
                                )
                            }
                        }
                    }
                )
            },
            content = { innerPadding ->
                // Call the CardScreen composable and pass innerPadding
                CardScreen(innerPadding)
            }
        )
    }
}