package org.example.studyApp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kmp_sample_ui_design.composeapp.generated.resources.Res
import kmp_sample_ui_design.composeapp.generated.resources.study
import org.example.studyApp.common.values.colors
import org.example.studyApp.common.values.string
import org.jetbrains.compose.resources.painterResource

@Composable
fun LoginScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(colors.black)
            .verticalScroll(rememberScrollState())
    ) {
        // Image occupying 60% of the screen height
        Image(
            painter = painterResource(Res.drawable.study),
            contentDescription = "Study Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(600.dp)
//                .weight(0.5f) // Occupies 60% of the available height
        )

        // Text centered below the image
        Text(
            text = string.STUDY_PAL,
            modifier = Modifier
                .fillMaxWidth()
//                .weight(0.1f) // Allocating 10% of the available height for the text
                .wrapContentHeight(Alignment.CenterVertically), // Centering vertically
            style = MaterialTheme.typography.h4, // You can adjust the text style here
            textAlign = TextAlign.Center, // Center the text
            color = Color.White
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = string.YOUR_POCKET_GUIDE_FOR_SCHOOL,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(Alignment.CenterVertically), // Centering vertically
            style = MaterialTheme.typography.subtitle1, // You can adjust the text style here
            textAlign = TextAlign.Center,
            color = Color.White // Center the text
        )

        /*// Button below the text
        Button(
            onClick = { *//* Handle button click *//* },
            shape = RoundedCornerShape(50.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colors.primaryGradient, // Set button color from CustomColors
                contentColor = Color.White // Optional: Set text color
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
//                .weight(0.1f) // Allocating 10% of the available height for the button
                .padding(16.dp) // Optional padding for the button

        ) {
            Text(
                text = "Get Started",
                fontSize = 18.sp, // You can adjust the text style here
            ) // Button text
        }*/

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(16.dp)
                .background(colors.primaryGradient, RoundedCornerShape(50.dp)) // Apply gradient background
        ) {
            Button(
                onClick = {
                    navController.navigate("homepage")
                },
                shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent, // Set button color to transparent
//                    contentColor = Color.White // Optional: Set text color
                ),
                modifier = Modifier
                    .fillMaxSize() // Fill the Box
            ) {
                Text(
                    text = string.GET_STARTED,
                    fontSize = 18.sp,
                    color = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
    }
}
