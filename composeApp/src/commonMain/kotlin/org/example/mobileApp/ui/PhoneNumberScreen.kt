package org.example.mobileApp.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.DropdownMenu
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
fun PhoneNumberScreen(navController: NavController) {

    Column(modifier = Modifier.fillMaxSize()) {

        AppBar(navController)

        PhoneNumberCard(navController)

    }
}

@Composable
fun PhoneNumberCard(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)// Ensure the column takes up the full width
            .wrapContentHeight(), // Makes the column wrap its content height
        horizontalAlignment = Alignment.CenterHorizontally // This will center the content horizontally
    ) {

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = string.ENTER_YOUR_PHONE,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )// Center this text

        Spacer(modifier = Modifier.height(8.dp)) // Space between the lines

        // "number" text
        Text(
            text = string.NUMBER,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = string.CONFIRMATION_CODE,
            textAlign = TextAlign.Center,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(24.dp))

        CountryCodePicker(navController)
    }
}

@Composable
fun CountryCodePicker(navController: NavController) {
    var isDropdownExpanded by remember { mutableStateOf(false) }
    var countryCode by remember { mutableStateOf("+1") }  // Default country code
    var phoneNumber by remember { mutableStateOf(TextFieldValue("")) }

    // Sample list of country codes
    val countryCodes = listOf("+1", "+91", "+44", "+61")

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Gray, shape = RoundedCornerShape(50.dp)) // Border with rounded corners
            .clip(RoundedCornerShape(50.dp))  // Rounded corners
            .padding(horizontal = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Country Code Picker
            Box(
                modifier = Modifier
                    .clickable { isDropdownExpanded = !isDropdownExpanded }
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = countryCode,
                        style = MaterialTheme.typography.body1,
                        fontSize = 18.sp
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Country Code Dropdown"
                    )
                }

                DropdownMenu(
                    expanded = isDropdownExpanded,
                    onDismissRequest = { isDropdownExpanded = false }
                ) {
                    countryCodes.forEach { code ->
                        DropdownMenuItem(
                            onClick = {
                                countryCode = code
                                isDropdownExpanded = false
                            },
                            text = {
                                Text(text = code)
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Phone Number Input
            BasicTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textStyle = MaterialTheme.typography.body1.copy(fontSize = 20.sp),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number  // Only number input on the keyboard
                ),
                decorationBox = { innerTextField ->
                    if (phoneNumber.text.isEmpty()) {
                        Text(
                            text = "Enter phone number",
                            style = MaterialTheme.typography.body1.copy(
                                color = Color.Gray,
                                fontSize = 18.sp
                            ),
                        )
                    }
                    innerTextField()
                }
            )
        }
    }

    Spacer(modifier = Modifier.height(180.dp))

    Button(
        onClick = {
            // Combine the country code and phone number
            val fullPhoneNumber = "$countryCode ${phoneNumber.text}"
            // Navigate to the next screen and pass the full phone number
            navController.navigate("otp/${fullPhoneNumber}")
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