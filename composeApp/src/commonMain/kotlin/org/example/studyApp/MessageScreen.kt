package org.example.studyApp

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.example.studyApp.common.values.colors
import org.example.studyApp.common.values.string

@Composable
fun MessageScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.black),
    ) {

        // Use HeaderRow composable
        HeaderRow(navController = navController, title = string.MESSAGE)

        /*  // Header Row
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
                  text = string.MESSAGE,
                  color = Color.White,
                  style = MaterialTheme.typography.h6
              )
              Icon(
                  imageVector = Icons.Filled.AccountCircle,
                  contentDescription = "Profile Picture",
                  modifier = Modifier
                      .size(40.dp)
                      .clickable { *//* Handle profile click *//* },
                tint = Color.White
            )
        }*/

        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn (
            modifier = Modifier.padding(16.dp),
        ){
            item{MessageCard(string.HAN,string.HAN_MESSAGE, colors.green)}
            item{MessageCard(string.ROBERT,string.ROBERT_MESSAGE, colors.blue)}
            item{MessageCard(string.ELIZABETH,string.ELIZABETH_MESSAGE, colors.green)}
            item{MessageCard(string.JAMES, string.JAMES_MESSAGE,colors.blue)}
            item{MessageCard(string.HAN, string.HAN_MESSAGE,colors.green)}
            item{MessageCard(string.ROBERT, string.ROBERT_MESSAGE,colors.blue)}
            item{MessageCard(string.ELIZABETH, string.ELIZABETH_MESSAGE,colors.green)}
            item{MessageCard(string.JAMES, string.JAMES_MESSAGE,colors.blue)}
        }
    }
}

@Composable
fun MessageCard(
    name : String,
    message: String,
    cardColor : Color
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
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
            Icon(
                imageVector = Icons.Filled.Face,
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(40.dp),
                tint = Color.White
            )

            Spacer(modifier = Modifier.width(10.dp))

            Column(
                modifier = Modifier.width(210.dp)
            ) {

                Text(
                    text = name,
                    fontSize = 18.sp,
                    color = Color.White,
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = message,
                    fontSize = 16.sp,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.width(20.dp))

            Icon(
                imageVector = Icons.Filled.KeyboardArrowRight,
                contentDescription = "Message",
                modifier = Modifier
                    .size(20.dp),
                tint = Color.White
            )
        }
    }
}