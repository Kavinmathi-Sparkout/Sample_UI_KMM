package org.example.MobileApp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
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
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.example.MobileApp.common.AppBar.AppBar
import org.example.MobileApp.common.values.colors
import org.example.MobileApp.common.values.string

@Composable
fun TermsAndConditionScreen(navController: NavController) {
    // State to track whether the checkboxes are checked
    var isTermsChecked by remember { mutableStateOf(false) }
    var isPolicyChecked by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()) {
        AppBar(navController)

        TermsAndConditionCard(
            isTermsChecked = isTermsChecked,
            isPolicyChecked = isPolicyChecked,
            onTermsCheckedChange = { isTermsChecked = it },
            onPolicyCheckedChange = { isPolicyChecked = it }
        )

        Spacer(modifier = Modifier.height(22.dp))

        // Button that is enabled only when both checkboxes are selected
        Button(
            onClick = {
                // Handle the button click logic (e.g., navigate to the next screen)
            },
            enabled = isTermsChecked && isPolicyChecked,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 32.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colors.pink,
                disabledBackgroundColor = Color.LightGray
            ),
            shape = RoundedCornerShape(50.dp)
        ) {
            Text(text = string.AGREE_AND_CONTINUE, color = Color.White)
        }
    }
}

@Composable
fun TermsAndConditionCard(
    isTermsChecked: Boolean,
    isPolicyChecked: Boolean,
    onTermsCheckedChange: (Boolean) -> Unit,
    onPolicyCheckedChange: (Boolean) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp) // Ensure the column takes up the full width
            .wrapContentHeight(), // Makes the column wrap its content height
    ) {

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = string.TERMS_AND_CONDITION,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            fontSize = 37.sp,
            modifier = Modifier.align(Alignment.Start) // Align to the start
        )

        Spacer(modifier = Modifier.height(16.dp)) // Space between the lines

        Text(
            text = string.TERMS,
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            modifier = Modifier.align(Alignment.Start) // Align to the start
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = string.CONDITIONS,
            style = MaterialTheme.typography.body1,
            fontSize = 18.sp,
            modifier = Modifier.align(Alignment.Start) // Align to the start
        )

        // Checkboxes for agreement
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically // Align checkboxes and text vertically
        ) {
            Checkbox(
                checked = isTermsChecked,
                onCheckedChange = onTermsCheckedChange,
                colors = CheckboxDefaults.colors(checkedColor = colors.pink) // Set checked color to pink
            )
            Text(
                text = "I agree to the terms and conditions",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically // Align checkboxes and text vertically
        ) {
            Checkbox(
                checked = isPolicyChecked,
                onCheckedChange = onPolicyCheckedChange,
                colors = CheckboxDefaults.colors(checkedColor = colors.pink) // Set checked color to pink
            )
            Text(
                text = "I agree to the policy",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}
