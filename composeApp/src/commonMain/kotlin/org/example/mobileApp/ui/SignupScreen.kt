package org.example.mobileApp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kmp_sample_ui_design.composeapp.generated.resources.Res
import kmp_sample_ui_design.composeapp.generated.resources.background
import kmp_sample_ui_design.composeapp.generated.resources.eye_close
import kmp_sample_ui_design.composeapp.generated.resources.eye_open
import org.example.mobileApp.common.values.colors
import org.example.mobileApp.common.values.string
import org.jetbrains.compose.resources.painterResource

@Composable
fun SignupScreen (navController: NavController) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        item {
            // Background Image outside of LazyColumn
            Image(
                painter = painterResource(Res.drawable.background), // Replace with your background resource
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentScale = ContentScale.Crop
            )

            SignupCard(navController)
        }
    }
}

@Composable
fun SignupCard(navController: NavController) {
    var createPasswordVisible by remember { mutableStateOf(false) } // Track password visibility
    var confirmPasswordVisible by remember { mutableStateOf(false) } // Track password visibility
    var fullName by remember { mutableStateOf("") } // Email state
    var email by remember { mutableStateOf("") } // Email state
    var userName by remember { mutableStateOf("") } // Email state
    var createPassword by remember { mutableStateOf("") } // Password state
    var confirmPassword by remember { mutableStateOf("") } // Password state


    // LazyColumn for Login Card and other items
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top // Adjusted to top alignment
    ) {
            Column(
                modifier = Modifier
                    .padding(16.dp) // Reduced padding for tighter layout
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = string.SIGN_UP,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally) // Center this text
                )
                Text(
                    text = string.CREATE_AN_ACCOUNT,
                    style = MaterialTheme.typography.body2,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 8.dp, bottom = 24.dp).align(Alignment.CenterHorizontally) // Center this text
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = string.FULL_NAME,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Email TextField
                OutlinedTextField(
                    value = fullName,
                    onValueChange = { fullName = it }, // Update email state
                    label = { Text(string.FULL_NAME) },
                    trailingIcon = { Icon(Icons.Default.Info, contentDescription = null, modifier = Modifier.size(20.dp)) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(50.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = colors.pink,
                        focusedLabelColor = colors.pink
                    )// This will apply rounded corners to the entire field
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = string.ENTER_YOUR_EMAIL,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Email TextField
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it }, // Update email state
                    label = { Text(string.ENTER_YOUR_EMAIL) },
                    trailingIcon = { Icon(Icons.Default.Email, contentDescription = null, modifier = Modifier.size(20.dp)) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(50.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = colors.pink,
                        focusedLabelColor = colors.pink
                    )// This will apply rounded corners to the entire field
                )

                Spacer(modifier = Modifier.height(16.dp))


                Text(
                    text = string.USER_NAME,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Email TextField
                OutlinedTextField(
                    value = userName,
                    onValueChange = { userName = it }, // Update email state
                    label = { Text(string.USER_NAME) },
                    trailingIcon = { Icon(Icons.Default.AccountBox, contentDescription = null, modifier = Modifier.size(20.dp)) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(50.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = colors.pink,
                        focusedLabelColor = colors.pink
                    )// This will apply rounded corners to the entire field
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = string.CREATE_PASSWORD,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Password TextField
                OutlinedTextField(
                    value = createPassword,
                    onValueChange = { createPassword = it }, // Update password state
                    label = { Text(string.CREATE_PASSWORD) },
                    trailingIcon = {
                        IconButton(onClick = { createPasswordVisible = !createPasswordVisible }) {
                            Icon(
                                painter = painterResource(if (createPasswordVisible) Res.drawable.eye_open else Res.drawable.eye_close),
                                contentDescription = null,
                                modifier = Modifier.size(20.dp) // Set the size of the icon
                            )
                        }
                    },
                    singleLine = true,
                    visualTransformation = if (createPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(50.dp), // This will apply rounded corners to the entire field
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = colors.pink,
                        focusedLabelColor = colors.pink
                    )// This will apply rounded corners to the entire field
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = string.CONFIRM_PASSWORD,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(8.dp))
                // Password TextField
                OutlinedTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it }, // Update password state
                    label = { Text(string.CONFIRM_PASSWORD) },
                    trailingIcon = {
                        IconButton(onClick = { confirmPasswordVisible = !confirmPasswordVisible }) {
                            Icon(
                                painter = painterResource(if (confirmPasswordVisible) Res.drawable.eye_open else Res.drawable.eye_close),
                                contentDescription = null,
                                modifier = Modifier.size(20.dp) // Set the size of the icon
                            )
                        }
                    },
                    singleLine = true,
                    visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(50.dp), // This will apply rounded corners to the entire field
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = colors.pink,
                        focusedLabelColor = colors.pink
                    )// This will apply rounded corners to the entire field

                )


                Spacer(modifier = Modifier.height(32.dp))

                // Log In Button
                Button(
                    onClick = {
                        navController.navigate("phoneNumber")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(24.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = colors.pink) // Replace with your color
                ) {
                    Text(text = string.SIGN_UP, color = Color.White)
                }

                Spacer(modifier = Modifier.height(16.dp))
            }
    }
}
