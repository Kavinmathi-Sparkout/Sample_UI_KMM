package org.example.studyApp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import org.example.studyApp.common.values.colors
import org.example.studyApp.common.values.string
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun HomePageScreen(navController: NavController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    // State to hold the title
    val title = remember { mutableStateOf(string.STUDY_PAL) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            // Drawer Content with a black background
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black), // Set the drawer background to black
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
//                TopAppBar(
//                    backgroundColor = colors.primaryGradient,
//                    contentColor = Color.White,
//                    elevation = 0.dp
//                ) {
                    Row(
                        modifier = Modifier
                            .background(colors.primaryGradient)
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        // Menu Icon
                        IconButton(onClick = { scope.launch { drawerState.close() } }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.White
                            )
                        }

                        // Title
                        Text(
                            text = string.MENU,
                            color = Color.White,
                            style = MaterialTheme.typography.h6
                        )

                        // Profile Icon
                        Icon(
                            imageVector = Icons.Filled.AccountCircle,
                            contentDescription = "Profile Picture",
                            modifier = Modifier
                                .size(40.dp)
                                .clickable { /* Handle profile click */ },
                            tint = Color.White
                        ) /*
                        // Profile Icon
                        Image(
                            painter = painterResource(Icons.Filled.AccountCircle),
                            contentDescription = "Profile Picture",
                            modifier = Modifier
                                .size(40.dp)
                                .clickable { *//* Handle profile click *//* }
                        )*/
                    }
//                }

                Spacer(modifier = Modifier.height(30.dp))

                // Drawer Items
                listOf("Classes", "Homework", "Exams", "Teachers","Grades","Messages").forEach { item ->
                    Text(
                        text = item,
                        color = Color.White,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                            .clickable{
                                // Handle click actions for each drawer item
                                when (item) {
                                    "Classes" -> {navController.navigate("classes") }
                                    "Homework" -> { navController.navigate("homework") }
                                    "Exams" -> { navController.navigate("exams") }
                                    "Teachers" -> { navController.navigate("teachers")}
                                    "Grades" -> { navController.navigate("grades") }
                                    "Messages" -> {navController.navigate("messages") }
                                }
                            },
                    )

                    Spacer(modifier = Modifier.height(20.dp))
                }

                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp, start = 50.dp, end = 50.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Divider(
                        color = Color.White,
                        thickness = 2.dp
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    Text(
                        text = string.HELP,
                        color = Color.White,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = string.LOGOUT,
                        color = Color.White,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic
                    )
                }
            }
        }
    ) {
        // Content
        Scaffold(
            modifier = Modifier.background(colors.primaryGradient),
            topBar =  {
                    Row(
                        modifier = Modifier
                            .background(colors.primaryGradient)
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        // Menu Icon
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Menu",
                                tint = Color.White
                            )
                        }

                        // Title
                        Text(
                            text = title.value,
                            color = Color.White,
                            style = MaterialTheme.typography.h6
                        )

                        // Profile Icon
                        Icon(
                            imageVector = Icons.Filled.AccountCircle,
                            contentDescription = "Profile Picture",
                            modifier = Modifier
                                .size(40.dp)
                                .clickable { /* Handle profile click */ },
                            tint = Color.White
                        )
                    }
            },
            content = { innerPadding ->
                // Call the CardScreen composable and pass innerPadding
                CardScreen(innerPadding, navController)
            }
        )
    }
}
