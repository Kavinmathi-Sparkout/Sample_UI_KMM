package org.example.MobileApp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.TextButton
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
import kmp_sample_ui_design.composeapp.generated.resources.facebook
import kmp_sample_ui_design.composeapp.generated.resources.google
import kmp_sample_ui_design.composeapp.generated.resources.twitter
import org.example.MobileApp.common.values.colors
import org.example.MobileApp.common.values.string
import org.jetbrains.compose.resources.painterResource

@Composable
fun LoginScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Background Image outside of LazyColumn
        Image(
            painter = painterResource(Res.drawable.background), // Replace with your background resource
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Crop
        )

        LoginCard(navController)
    }
}

@Composable
fun LoginCard(navController: NavController) {

    var passwordVisible by remember { mutableStateOf(false) } // Track password visibility
    var email by remember { mutableStateOf("") } // Email state
    var password by remember { mutableStateOf("") } // Password state
    var isRememberMeChecked by remember { mutableStateOf(false) } // Checkbox state


    // LazyColumn for Login Card and other items
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top // Adjusted to top alignment
    ) {
        item {
            Column(
                modifier = Modifier
                    .padding(16.dp) // Reduced padding for tighter layout
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = string.LOGIN,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally) // Center this text
                )
                Text(
                    text = string.ENTER_YOUR_DETAILS_TO_CONTINUE,
                    style = MaterialTheme.typography.body2,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 8.dp, bottom = 24.dp).align(Alignment.CenterHorizontally) // Center this text
                )

                Spacer(modifier = Modifier.height(10.dp))

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
                    text = string.ENTER_YOUR_PASSWORD,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Password TextField
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it }, // Update password state
                    label = { Text(string.ENTER_YOUR_PASSWORD) },
                    trailingIcon = {
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                painter = painterResource(if (passwordVisible) Res.drawable.eye_open else Res.drawable.eye_close),
                                contentDescription = null,
                                modifier = Modifier.size(20.dp) // Set the size of the icon
                            )
                        }
                    },
                    singleLine = true,
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(50.dp), // This will apply rounded corners to the entire field
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = colors.pink,
                        focusedLabelColor = colors.pink
                    )// This will apply rounded corners to the entire field

                )

                Spacer(modifier = Modifier.height(16.dp))

                // Remember Me and Recover Password Row
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = isRememberMeChecked, // Use state for checked
                        onCheckedChange = {
                            isRememberMeChecked = it
                        }, // Update state on checkbox change
                        colors = CheckboxDefaults.colors(checkedColor = colors.pink) // Set checked color to pink
                    )
                    Text(
                        text = string.REMEMBER_ME,
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.weight(1f)
                    )

                    TextButton(onClick = { /* Recover password action */ }) {
                        Text(text = string.RECOVER_PASSWORD)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Log In Button
                Button(
                    onClick = {
                        navController.navigate("shop")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(24.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = colors.pink) // Replace with your color
                ) {
                    Text(text = string.LOGIN, color = Color.White)
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Social Media Login Options
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp), // Add bottom padding to reduce space after the icons
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    IconButton(onClick = { /* Google login action */ }) {
                        Icon(
                            painterResource(Res.drawable.google),
                            contentDescription = string.GOOGLE,
                            modifier = Modifier.size(20.dp)
                        ) // Replace with Google icon resource
                    }
                    IconButton(onClick = { /* Facebook login action */ }) {
                        Icon(
                            painterResource(Res.drawable.facebook),
                            contentDescription = string.FACEBOOK,
                            modifier = Modifier.size(20.dp)
                        ) // Replace with Facebook icon resource
                    }
                    IconButton(onClick = { /* Twitter login action */ }) {
                        Icon(
                            painterResource(Res.drawable.twitter),
                            contentDescription = string.TWITTER,
                            modifier = Modifier.size(20.dp)
                        ) // Replace with Twitter icon resource
                    }
                }
            }
        }
    }
}
