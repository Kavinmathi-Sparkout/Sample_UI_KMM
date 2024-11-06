package org.example.studyApp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
fun ClassesScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.black),
    ) {
        // Header Row
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
                modifier = Modifier.size(30.dp)
                    .clickable {
                        navController.popBackStack()
                    }
            )
            Text(
                text = string.CLASSES,
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

        Spacer(modifier = Modifier.height(10.dp))

        // Class Cards
        ClassCard(
            imageRes = Res.drawable.maths,
            title = string.TUTORIALS,
            subtitle = string.MATHS_101,
            time = string.TIME_9,
            schedule = string.EVERY_MONDAY,
            cardColor = colors.green // Green
        )
        ClassCard(
            imageRes = Res.drawable.maths,
            title = string.WORKSHOPS,
            subtitle = string.SCIENCE_101,
            time = string.TIME_11,
            schedule = string.EVERY_TUESDAY,
            cardColor = colors.blue // Blue
        )
        ClassCard(
            imageRes = Res.drawable.maths,
            title = string.LECTURES,
            subtitle = string.HISTORY_101,
            time = string.TIME_10,
            schedule = string.EVERY_WEDNESDAY,
            cardColor = colors.blue// Blue
        )
        ClassCard(
            imageRes = Res.drawable.maths,
            title = string.SESSIONS,
            subtitle = string.ART_101,
            time = string.TIME_2,
            schedule = string.EVERY_THURSDAY,
            cardColor = colors.green // Green
        )
    }
}

@Composable
fun ClassCard(
    imageRes: DrawableResource,
    title: String,
    subtitle: String,
    time: String,
    schedule: String,
    cardColor: Color
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(10.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(cardColor)
                .padding(10.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            // Image Card
            Card(
                modifier = Modifier
                    .width(100.dp)
                    .height(120.dp),
                shape = RoundedCornerShape(15.dp),
                elevation = 5.dp
            ) {
                Image(
                    painter = painterResource(imageRes),
                    contentDescription = "$title Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.width(20.dp))

            // Text Content
            Column(
                modifier = Modifier.wrapContentWidth()
            ) {
                Text(
                    text = title,
                    fontSize = 12.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(25.dp))

                Text(
                    text = subtitle,
                    fontSize = 14.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = time,
                    fontSize = 12.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = schedule,
                    fontSize = 12.sp,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.width(75.dp))

            // Notification Column
            Column(
                modifier = Modifier.wrapContentWidth()
            ) {
                Text(
                    text = string.CLASSES,
                    fontSize = 12.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(60.dp))

                Icon(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = "Notification",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}