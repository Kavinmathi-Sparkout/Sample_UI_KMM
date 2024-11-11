package org.example.MobileApp

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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.BasicTextField
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.example.MobileApp.common.AppBar.AppBar
import org.example.MobileApp.common.values.string

@Composable
fun PhoneNumberScreen(navController: NavController) {

    Column(modifier = Modifier.fillMaxSize()) {

        AppBar(navController)

        PhoneNumberCard()

    }
}

@Composable
fun PhoneNumberCard() {

    var phoneNumber by remember { mutableStateOf(TextFieldValue("")) }
    var countryCode by remember { mutableStateOf("+1") } // Default country code
    var isDropdownExpanded by remember { mutableStateOf(false) }

    // Define your list of country codes here
    val countryCodes = listOf("+1", "+44", "+91", "+61") // Example country codes

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)// Ensure the column takes up the full width
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

       /* // Country Code Picker
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { isDropdownExpanded = !isDropdownExpanded }
                .padding(16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = countryCode,
                    style = MaterialTheme.typography.body1,
                    fontSize = 20.sp,
                    modifier = Modifier.weight(1f)
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
                // Here, we use the countryCodes list
                countryCodes.forEach { code ->
                    DropdownMenuItem(onClick = {
                        countryCode = code
                        isDropdownExpanded = false
                    }) {
                        Text(text = code)
                    }
                }
            }
        }

        // Phone Number Input
        BasicTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .border(1.dp, Color.Gray)
                .padding(16.dp),
            textStyle = MaterialTheme.typography.body1.copy(fontSize = 20.sp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = string.CONFIRMATION_CODE,
            textAlign = TextAlign.Center,
            color = Color.Gray
        )*/
    }
}
