package org.example.MobileApp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kmp_sample_ui_design.composeapp.generated.resources.Res
import kmp_sample_ui_design.composeapp.generated.resources.eye_close
import kmp_sample_ui_design.composeapp.generated.resources.eye_open
import org.example.MobileApp.common.AppBar.AppBar
import org.example.MobileApp.common.values.colors
import org.example.MobileApp.common.values.string
import org.jetbrains.compose.resources.painterResource

@Composable
fun PasswordScreen(navController: NavController) {

    Column(modifier = Modifier.fillMaxSize()) {
        AppBar(navController)

        PasswordCard(navController)
    }
}
@Composable
fun PasswordCard(navController: NavController) {
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }

    val containsLetter = password.any { it.isLetter() }
    val containsDigit = password.any { it.isDigit() }
    val containsSpecial = password.any { !it.isLetterOrDigit() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        // Title and Description
        Text(
            text = string.CREATE_A_PASSWORD,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            fontSize = 38.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = string.PASSWORD_CONDITION,
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Password TextField
        OutlinedTextField(
            value = password,
            onValueChange = { password = it }, // Update password state
            label = { Text(string.ENTER_PASSWORD) },
            trailingIcon = {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    androidx.compose.material3.Icon(
                        painter = painterResource(if (isPasswordVisible) Res.drawable.eye_open else Res.drawable.eye_close),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp) // Set the size of the icon
                    )
                }
            },
            singleLine = true,
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(50.dp), // This will apply rounded corners to the entire field
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = colors.pink,
                focusedLabelColor = colors.pink
            )// This will apply rounded corners to the entire field

        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password Requirements
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = if (containsLetter) Icons.Default.CheckCircle else Icons.Default.Warning,
                contentDescription = null,
                tint = if (containsLetter) colors.pink else Color.Gray
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(string.CONTAINS_LETTER)
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = if (containsDigit) Icons.Default.CheckCircle else Icons.Default.Warning,
                contentDescription = null,
                tint = if (containsDigit) Color(0xFF7B61FF) else Color.Gray
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(string.CONTAINS_DIGIT)
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = if (containsSpecial) Icons.Default.CheckCircle else Icons.Default.Warning,
                contentDescription = null,
                tint = if (containsSpecial) colors.pink else Color.Gray
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(string.CONTAINS_SPECIALCHARACTER)
        }

        Spacer(modifier = Modifier.height(135.dp))

        // Continue Button
        Button(
            onClick = {
                navController.navigate("onboarding/password")
            },
            enabled = password.length >= 8 && containsLetter && containsDigit && containsSpecial,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colors.pink,
                disabledBackgroundColor = Color.LightGray
            ),
            shape = RoundedCornerShape(50)
        ) {
            Text(string.CONTINUE, color = Color.White)
        }
    }
}
