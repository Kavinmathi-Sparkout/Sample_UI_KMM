package org.example.mobileApp.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.example.mobileApp.common.AppBar.AppBar
import org.example.mobileApp.common.values.colors
import org.example.mobileApp.common.values.string

@Composable
fun OTPScreen(navController: NavController, phoneNumber: String?) {
    // Manage OTP state
    var otpText by remember { mutableStateOf("") }

    // Handle OTP text change
    val onOtpTextChanged: (String, Boolean) -> Unit = { newOtp, isCompleted ->
        otpText = newOtp
        if (isCompleted) {
            // Handle OTP completion (e.g., trigger verification)
            println("OTP Completed: $newOtp")
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppBar(navController)
        Spacer(modifier = Modifier.height(30.dp))
        OTPcard(navController, phoneNumber, otpText, onOtpTextChanged)

        Spacer(modifier = Modifier.height(200.dp))

        Button(
            onClick = {
              navController.navigate("onboarding/otp")
                println("OTP Submitted: $otpText")
            },
            enabled = otpText.length == 4,  // Enable only when OTP is complete
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = if (otpText.length == 4) colors.pink else Color.Gray
            ),
            shape = RoundedCornerShape(24.dp)
        ) {
            Text(text = "Submit", color = Color.White, fontSize = 16.sp)
        }
    }
}

@Composable
fun OTPcard(
    navController: NavController,
    phoneNumber: String?,
    otpText: String,
    onOtpTextChanged: (String, Boolean) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
            .wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = string.ENTER_THE_CODE_SENT,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = string.SENT_TO,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Phone Number: $phoneNumber",
            textAlign = TextAlign.Center,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(24.dp))

        OTPInput(otpText = otpText, onOtpTextChange = onOtpTextChanged)
    }
}

@Composable
fun OTPInput(
    modifier: Modifier = Modifier,
    otpText: String,
    otpCount: Int = 4,
    onOtpTextChange: (String, Boolean) -> Unit
) {
    BasicTextField(
        modifier = modifier,
        value = TextFieldValue(otpText, selection = TextRange(otpText.length)),
        onValueChange = { newValue ->
            val newOtp = newValue.text.take(otpCount) // Limit input length
            val isCompleted = newOtp.length == otpCount
            onOtpTextChange(newOtp, isCompleted)
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number  // Only number input on the keyboard
        ),
//        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        decorationBox = {
            Row(horizontalArrangement = Arrangement.Center) {
                repeat(otpCount) { index ->
                    CharView(
                        index = index,
                        text = otpText
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
    )
}

@Composable
private fun CharView(
    index: Int,
    text: String
) {
    val isFocused = text.length == index
    val char = when {
        index == text.length -> ""
        index > text.length -> ""
        else -> text[index].toString()
    }

    Text(
        modifier = Modifier
            .width(50.dp)
            .height(50.dp)
            .border(
                1.dp, colors.pink, RoundedCornerShape(8.dp)
            )
            .padding(4.dp),
        text = char,
        style = MaterialTheme.typography.h4,
        color = colors.pink,
        textAlign = TextAlign.Center
    )
}
