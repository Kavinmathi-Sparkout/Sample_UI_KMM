package org.example.studyApp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.example.studyApp.common.values.colors
import org.example.studyApp.common.values.string

@Composable
fun CardScreen (innerPadding: PaddingValues,
                navController: NavController){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(colors.black)
            .padding(16.dp)
    ) {
        Text(
            text = string.WHATS_NEW,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            fontSize = 18.sp,
            color = Color.White
        )
        Row (
            modifier = Modifier.fillMaxWidth()
        ){
            Card(
                modifier = Modifier
                    .width(150.dp)
                    .height (150.dp)
                    .padding(10.dp)
                    .clickable {
                        navController.navigate("exams") // Replace "homepage" with your desired screen
                    },
//                elevation = CardDefaults.cardElevation(10.dp),
                elevation = 10.dp,
                shape = RoundedCornerShape(10.dp)
            ){
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colors.primaryGradient)
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Spacer (modifier = Modifier.height(12.dp))

                    Text(
                        text = string.UPCOMING,
                        fontSize = 14.sp,
                        color = Color.White
                    )

                    Spacer (modifier = Modifier.height(10.dp))

                    Text(
                        text = string.SEVEN,
                        fontSize = 18.sp,
                        fontStyle = FontStyle.Italic,
                        color = Color.White
                    )

                    Spacer (modifier = Modifier.height(10.dp))

                    Text(
                        text = string.EXAMS,
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }

            }

            Spacer (modifier = Modifier.width(10.dp))

            Card(
                modifier = Modifier
                    .width(300.dp)
                    .height (150.dp)
                    .padding(10.dp)
                    .clickable {
                        navController.navigate("homework") // Replace "homepage" with your desired screen
                    },
//                elevation = CardDefaults.cardElevation(10.dp),
                elevation = 10.dp,
                shape = RoundedCornerShape(10.dp)
            ){
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colors.primaryGradient)
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Spacer (modifier = Modifier.height(12.dp))

                    Text(
                        text = string.PENDING,
                        fontSize = 14.sp,
                        color = Color.White
                    )

                    Spacer (modifier = Modifier.height(10.dp))

                    Text(
                        text = string.SEVEN,
                        fontSize = 18.sp,
                        fontStyle = FontStyle.Italic,
                        color = Color.White
                    )

                    Spacer (modifier = Modifier.height(10.dp))

                    Text(
                        text = string.HOMEWORK,
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }

            }
        }

        Row (
            modifier = Modifier.fillMaxWidth()
        ){
            Card(
                modifier = Modifier
                    .width(200.dp)
                    .height (150.dp)
                    .padding(10.dp)
                    .clickable {
                        navController.navigate("classes") // Replace "homepage" with your desired screen
                    },
//                elevation = CardDefaults.cardElevation(10.dp),
                elevation = 10.dp,
                shape = RoundedCornerShape(10.dp)
            ){
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colors.primaryGradient)
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Spacer (modifier = Modifier.height(12.dp))

                    Text(
                        text = string.NEW,
                        fontSize = 14.sp,
                        color = Color.White
                    )

                    Spacer (modifier = Modifier.height(10.dp))

                    Text(
                        text = string.SEVEN,
                        fontSize = 18.sp,
                        fontStyle = FontStyle.Italic,
                        color = Color.White
                    )

                    Spacer (modifier = Modifier.height(10.dp))

                    Text(
                        text = string.CLASSES,
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }

            }

            Spacer (modifier = Modifier.width(10.dp))

            Card(
                modifier = Modifier
                    .width(150.dp)
                    .height (150.dp)
                    .padding(10.dp)
                    .clickable {
                        navController.navigate("messages") // Replace "homepage" with your desired screen
                    },
//                elevation = CardDefaults.cardElevation(10.dp),
                elevation = 10.dp,
                shape = RoundedCornerShape(10.dp)
            ){
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colors.primaryGradient)
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Spacer (modifier = Modifier.height(12.dp))

                    Text(
                        text = string.NEW,
                        fontSize = 14.sp,
                        color = Color.White
                    )

                    Spacer (modifier = Modifier.height(10.dp))

                    Text(
                        text = string.SEVEN,
                        fontSize = 18.sp,
                        fontStyle = FontStyle.Italic,
                        color = Color.White
                    )

                    Spacer (modifier = Modifier.height(10.dp))

                    Text(
                        text = string.MESSAGE,
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }

            }
        }

        Spacer (modifier = Modifier.height(20.dp))

        Text(
            text = string.TODAYS_SCHEDULE,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            fontSize = 18.sp,
            color = Color.White
        )

        Card(
            modifier = Modifier.fillMaxWidth()
                .height (150.dp)
                .padding(10.dp)
                .clickable {
                    navController.navigate("detail") // Replace "homepage" with your desired screen
                },
//                elevation = CardDefaults.cardElevation(10.dp),
            elevation = 10.dp,
            shape = RoundedCornerShape(10.dp)
        ) {
            Column (
                modifier = Modifier.fillMaxWidth()
                    .background( colors.green)
                    .padding(20.dp),
            ) {

                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = string.TUTORIALS,
                    fontSize = 14.sp,
                    fontStyle = FontStyle.Italic,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = string.MATHS_101,
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

                Spacer (modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = string.CLASSES,
                        fontSize = 14.sp,
                        fontStyle = FontStyle.Italic,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    Icon(
                        imageVector = Icons.Filled.Notifications,
                        contentDescription = "Notification",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
        Card(
            modifier = Modifier.fillMaxWidth()
                .height (150.dp)
                .padding(10.dp),
//                elevation = CardDefaults.cardElevation(10.dp),
            elevation = 10.dp,
            shape = RoundedCornerShape(10.dp)
        ) {
            Column (
                modifier = Modifier.fillMaxWidth()
                    .background( colors.green.copy(alpha = 0.4f))
                    .padding(20.dp),
            ) {

                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = string.PRACTICAL,
                    fontSize = 14.sp,
                    fontStyle = FontStyle.Italic,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = string.VOCABULARY,
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

                Spacer (modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = string.CLASSES,
                        fontSize = 14.sp,
                        fontStyle = FontStyle.Italic,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.width(20.dp))

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
}