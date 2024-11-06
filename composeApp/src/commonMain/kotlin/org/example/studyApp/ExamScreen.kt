package org.example.studyApp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kmp_sample_ui_design.composeapp.generated.resources.Res
import kmp_sample_ui_design.composeapp.generated.resources.maths
import org.example.studyApp.common.values.colors
import org.example.studyApp.common.values.string
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun ExamScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.black)
    ) {
        Row(
            modifier = Modifier
                .background(colors.primaryGradient)
                .fillMaxWidth()
                .height(60.dp)
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Color.White,
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                        navController.popBackStack()
                    }
            )
            Text(
                text = string.EXAMS,
                color = Color.White,
                style = MaterialTheme.typography.h6
            )
            Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(40.dp)
                    .clickable { /* Handle profile click */ },
                tint = Color.White
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Example usage of the ExamCard composable
        ExamCard(
            imageRes = Res.drawable.maths, // Replace with actual drawable resource
            title = string.MATHS_EXAM,
            subtitle = string.DIFFERENTIAL_EQUATION,
            time = string.TIME_9,
            schedule = string.THURSDAY,
            cardColor = colors.green
        )

        Spacer(modifier = Modifier.height(16.dp))

        ExamCard(
            imageRes = Res.drawable.maths, // Replace with actual drawable resource
            title = string.MACROECONOMICS,
            subtitle = string.SHORTAGE_SCARCITY,
            time = string.TIME_11,
            schedule = string.FRIDAY,
            cardColor = colors.green
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(16.dp)
                .background(colors.primaryGradient, RoundedCornerShape(50.dp)) // Apply gradient background
        ) {
            Button(
                onClick = { },
                shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent, // Set button color to transparent
//                    contentColor = Color.White // Optional: Set text color
                ),
                modifier = Modifier
                    .fillMaxSize() // Fill the Box
            ) {
                Text(
                    text = string.SIGN_UP_FOR_ANOTHER_EXAM,
                    fontSize = 18.sp,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun ExamCard(
    imageRes: DrawableResource, // Use Int for drawable resources in Compose
    title: String,
    subtitle: String,
    time: String,
    schedule: String,
    cardColor: Color
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(10.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(cardColor)
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(8.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h6,
                    color = Color.White
                )
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.body2,
                    color = Color.White.copy(alpha = 0.7f)
                )
                Spacer(modifier = Modifier.height(40.dp))

                Text(
                    text = "Time: $time",
                    style = MaterialTheme.typography.body2,
                    color = Color.White
                )
                Text(
                    text = "Schedule: $schedule",
                    style = MaterialTheme.typography.body2,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .width(150.dp)
                        .height(50.dp)
//                        .padding(16.dp)
                        .background(colors.primaryGradient, RoundedCornerShape(40.dp)) // Apply gradient background
                ) {
                    Button(
                        onClick = {
                            // Handle button click
                        },
                        shape = RoundedCornerShape(40.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Transparent, // Set button color to transparent
//                    contentColor = Color.White // Optional: Set text color
                        ),
                        modifier = Modifier
                            .fillMaxSize() // Fill the Box
                    ) {
                        Text(text = "Sign Up", fontSize = 14.sp, color = Color.White)
                    }
                }
            }
            Spacer(modifier = Modifier.width(30.dp))

            // Image Card
            Card(
                modifier = Modifier
                    .width(170.dp)
                    .height(200.dp),
                shape = RoundedCornerShape(15.dp),
                elevation = 5.dp
            ) {
                // Exam image
                Image(
                    painter = painterResource(imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.Crop, // Ensures the image covers the full card area
                    modifier = Modifier
                        .width(150.dp)
                        .height(200.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
            }
        }
    }
}
