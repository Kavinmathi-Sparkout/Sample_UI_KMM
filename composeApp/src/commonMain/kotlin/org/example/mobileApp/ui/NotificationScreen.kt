package org.example.mobileApp.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.example.mobileApp.common.AppBar.AppBar
import org.example.mobileApp.common.values.colors
import org.example.mobileApp.common.values.string

@Composable
fun NotificationScreen (navController: NavController) {

    Column(modifier = Modifier.fillMaxSize()) {
        AppBar(navController)
        NotificationCard(navController)
    }
}

@Composable
fun NotificationCard(navController: NavController) {
    Column (
        modifier = Modifier.fillMaxSize()
            .padding(horizontal = 32.dp)
            .fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = string.TURN_ON_NOTIFICATIONS,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            fontSize = 34.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = string.TURN_ON_NOTIFICATIONS_DESC,
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(170.dp))

        Button(
            onClick = {
                navController.navigate("fillProfile")
            },
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colors.pink
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(text = string.YES_NOTIFY, fontSize = 16.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(
            onClick = {
                navController.navigate("fillProfile")
            },
            shape = RoundedCornerShape(50.dp),
            border = BorderStroke(1.dp, colors.pink),
            colors = ButtonDefaults.outlinedButtonColors(
                backgroundColor = Color.Transparent,
                contentColor = colors.pink
            ),
            modifier = Modifier.fillMaxWidth()
                .height(48.dp)
        ){
            Text(text = string.NO_THANKS, fontSize = 16.sp, color = colors.pink)
        }
    }
}