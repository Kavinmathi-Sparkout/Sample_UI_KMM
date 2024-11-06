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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
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
import org.jetbrains.compose.resources.DrawableResource

@Composable
fun TeachersScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.black)
    ) {

        HeaderRow(navController = navController, title = string.MESSAGE)

      /*  Row(
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
                text = string.TEACHERS,
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

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item { TeachersCard(string.HAN, navController) }
            item { TeachersCard(string.ROBERT, navController) }
            item { TeachersCard(string.ELIZABETH, navController) }
            item { TeachersCard(string.JAMES, navController) }
            item { TeachersCard(string.HAN,navController) }
            item { TeachersCard(string.ROBERT,navController) }
            item { TeachersCard(string.ELIZABETH, navController) }
            item { TeachersCard(string.JAMES, navController) }
        }
    }

}

@Composable
fun TeachersCard(
    name: String,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(10.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(colors.green)
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.Face,
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(40.dp)
                    .clickable { /* Handle profile click */ },
                tint = Color.White
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(
                text = name,
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier.width(130.dp)
            )

            Spacer(modifier = Modifier.width(75.dp))

            Icon(
                imageVector = Icons.Filled.Phone,
                contentDescription = "Phone",
                modifier = Modifier
                    .size(20.dp)
                    .clickable { /* Handle profile click */ },
                tint = Color.White
            )

            Spacer(modifier = Modifier.width(20.dp))

            Icon(
                imageVector = Icons.Filled.MailOutline,
                contentDescription = "Message",
                modifier = Modifier
                    .size(20.dp)
                    .clickable {
                        navController.navigate("messages")
                    },
                tint = Color.White
            )
        }
    }

}