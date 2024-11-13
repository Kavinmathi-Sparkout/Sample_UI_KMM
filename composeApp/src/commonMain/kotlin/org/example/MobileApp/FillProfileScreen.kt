package org.example.MobileApp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kmp_sample_ui_design.composeapp.generated.resources.Res
import kmp_sample_ui_design.composeapp.generated.resources.background
import org.example.MobileApp.common.AppBar.AppBar
import org.example.MobileApp.common.values.colors
import org.example.MobileApp.common.values.string
import org.jetbrains.compose.resources.painterResource

@Composable
fun FillProfileScreen(navController: NavController) {
    LazyColumn(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        item {
            AppBar(navController)
            FillProfileCard(navController)
        }
    }
}

@Composable
fun FillProfileCard(navController: NavController) {
    var fullName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var userName by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProfileTitle()
            Spacer(modifier = Modifier.height(36.dp))
            ProfileImage()
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 180.dp)
        ) {
            Spacer(modifier = Modifier.height(36.dp))
            ProfileTextField(label = string.FULL_NAME, value = fullName) { fullName = it }
            Spacer(modifier = Modifier.height(15.dp))
            ProfileTextField(label = string.LAST_NAME, value = lastName) { lastName = it }
            Spacer(modifier = Modifier.height(15.dp))
            ProfileTextField(label = string.USER_NAME, value = userName) { userName = it }
            Spacer(modifier = Modifier.height(120.dp))
            ProfileButton(onClick = { navController.navigate("home") })
        }
    }
}

@Composable
fun ProfileTitle() {
    Text(
        text = string.FILL_PROFILE,
        fontSize = 38.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black,
    )
}

@Composable
fun ProfileImage() {
    Image(
        painter = painterResource(Res.drawable.background),
        contentDescription = "Background",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape)
    )
}

@Composable
fun ProfileTextField(label: String, value: String, onValueChange: (String) -> Unit) {
    Column {
        Text(
            text = label,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(text = label) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(50.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = colors.pink,
                focusedLabelColor = colors.pink
            )
        )
    }
}

@Composable
fun ProfileButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(50.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colors.pink,
            contentColor = Color.White
        )
    ) {
        Text(text = string.CONTINUE, fontSize = 16.sp, color = Color.White)
    }
}

/*
@Composable
fun FillProfileCard(navController: NavController) {
    var fullName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var userName by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        LazyColumn(
            modifier = Modifier.align(Alignment.TopCenter),
            contentPadding = PaddingValues(bottom = 32.dp) // Extra padding at the bottom for spacing
        ) {
            // Title and Image
            item {
                Text(
                    text = string.FILL_PROFILE,
                    fontSize = 38.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.Center)
                )

                Spacer(modifier = Modifier.height(36.dp))

                Image(
                    painter = painterResource(Res.drawable.background),
                    contentDescription = "Background",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .align(Alignment.Center)
                )

                Spacer(modifier = Modifier.height(36.dp))
            }

            // Full Name
            item {
                Text(
                    text = string.FULL_NAME,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = fullName,
                    onValueChange = { fullName = it },
                    label = { Text(text = string.FULL_NAME) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(50.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = colors.pink,
                        focusedLabelColor = colors.pink
                    )
                )

                Spacer(modifier = Modifier.height(15.dp))
            }

            // Last Name
            item {
                Text(
                    text = string.LAST_NAME,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = lastName,
                    onValueChange = { lastName = it },
                    label = { Text(text = string.LAST_NAME) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(50.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = colors.pink,
                        focusedLabelColor = colors.pink
                    )
                )

                Spacer(modifier = Modifier.height(15.dp))
            }

            // Username
            item {
                Text(
                    text = string.USER_NAME,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = userName,
                    onValueChange = { userName = it },
                    label = { Text(text = string.USER_NAME) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(50.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = colors.pink,
                        focusedLabelColor = colors.pink
                    )
                )

                Spacer(modifier = Modifier.height(120.dp))
            }

            // Continue Button
            item {
                Button(
                    onClick = { */
/* handle button click *//*
 },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colors.pink,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = string.CONTINUE, fontSize = 16.sp, color = Color.White)
                }
            }
        }
    }
}
*/
