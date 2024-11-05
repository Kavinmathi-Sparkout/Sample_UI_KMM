package org.example.studyApp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kmp_sample_ui_design.composeapp.generated.resources.Res
import kmp_sample_ui_design.composeapp.generated.resources.maths
import org.example.studyApp.common.values.colors
import org.example.studyApp.common.values.string
import org.jetbrains.compose.resources.painterResource

@Composable
fun DetailScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth().fillMaxHeight()
            .background(colors.black)
            .padding(16.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp) ,
            elevation = 10.dp,
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
//            backgroundColor = colors.primaryGradient // Assuming `colors.primaryGradient` is a color object
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colors.primaryGradient)
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                // Column for Icon and Text
                Column(
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back Icon",
                        tint = Color.White,
                        modifier = Modifier.size(30.dp)
                            .clickable {
                                navController.popBackStack()
                            }
                    )

                    Spacer(modifier = Modifier.height(55.dp))

                    Text(
                        text = string.MATHS_101,
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = string.EVERY_MONDAY,
                        color = Color.White,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = string.TIME_9,
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }

                // Card for Image
                Card(
                    modifier = Modifier
                        .width(150.dp)
                        .height(150.dp),
                    shape = RoundedCornerShape(15.dp),
                    elevation = 5.dp
                ) {
                    Image(
                        painter = painterResource(Res.drawable.maths),
                        contentDescription = "Maths Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }

        Column (
            modifier = Modifier.fillMaxWidth()
                .padding(10.dp),
        ){

        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = string.DESCRIPTION_MATHS,
            fontSize = 18.sp,
            color = Color.White
        )

        Spacer (modifier = Modifier.height(20.dp))

        Text(
            text = string.DESCRIPTION_MATHS1,
            fontSize = 18.sp,
            color = Color.White
        )

        Spacer (modifier = Modifier.height(200.dp))

        Text(
            text = string.LECTURER,
            fontSize = 20.sp,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Filled.Face,
                contentDescription = "Face Icon",
                tint = Color.White,
                modifier = Modifier.size(30.dp)
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(
                text = string.HAN,
                fontSize = 18.sp,
                color = Color.White
            )

        }
    }
}
