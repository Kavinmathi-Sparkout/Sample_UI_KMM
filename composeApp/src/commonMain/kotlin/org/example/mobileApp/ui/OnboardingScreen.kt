package org.example.mobileApp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.example.mobileApp.common.AppBar.AppBar
import org.example.mobileApp.common.values.colors
import org.example.mobileApp.common.values.string

@Composable
fun OnboardingScreen(navController: NavController, source: String?) {
    Column(modifier = Modifier.fillMaxSize()) {
        AppBar(navController)

        OnboardingCard(navController, source)


    }
}

@Composable
fun OnboardingCard(navController: NavController, source: String?) {
    val message = when (source) {
        "otp" -> "Welcome!"
        "password" -> "Check your mail"
        else -> "Invalid Source"
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)// Ensure the column takes up the full width
            .wrapContentHeight(), // Makes the column wrap its content height
        horizontalAlignment = Alignment.CenterHorizontally // This will center the content horizontally
    ) {

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = message,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )// Center this text

        Spacer(modifier = Modifier.height(16.dp)) // Space between the lines

        Text(
            text = string.PLEASE_CHECK_MAIL,
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = string.CONFIRMATION_LINK,
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(290.dp))

        Button(
            onClick = {
                // Navigate based on the source
                when (source) {
                    "otp" -> navController.navigate("password") // Replace with your OTP screen route
                    "password" -> navController.navigate("terms_conditions") // Replace with your password screen route
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = colors.pink) // Replace with your color
        ) {
            Text(text = string.CONTINUE, color = Color.White)
        }


    }
}