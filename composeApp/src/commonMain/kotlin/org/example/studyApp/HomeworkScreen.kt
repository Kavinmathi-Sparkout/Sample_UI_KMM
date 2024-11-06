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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.example.studyApp.common.values.colors
import org.example.studyApp.common.values.string

@Composable
fun HomeworkScreen(navController: NavController) {

    // Mutable states for checkbox selections
    val differentialEquationChecked = remember { mutableStateOf(false) }
    val matrixAlgebraChecked = remember { mutableStateOf(false) }
    val shortageScarcityChecked = remember { mutableStateOf(false) }
    val strategyChecked = remember { mutableStateOf(false) }
    val presentationRoundChecked = remember { mutableStateOf(false) }
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
                modifier = Modifier.size(30.dp)
                    .clickable {
                        navController.popBackStack()
                    }
            )
            Text(
                text = string.HOMEWORK,
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

        Column(
            modifier = Modifier.fillMaxSize()
                .padding(16.dp)
        ) {

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = string.MATHS_101,
                fontSize = 18.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(20.dp))

            HomeworkCard(
                title = string.DIFFERENTIAL_EQUATION,
                isChecked = differentialEquationChecked.value,
                onCheckedChange = { differentialEquationChecked.value = it }
            )

            Spacer(modifier = Modifier.height(16.dp))

            HomeworkCard(
                title = string.MATRIX_ALGEBRA,
                isChecked = matrixAlgebraChecked.value,
                onCheckedChange = { matrixAlgebraChecked.value = it }
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = string.MACROECONOMICS,
                fontSize = 18.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(16.dp))

            HomeworkCard(
                title = string.SHORTAGE_SCARCITY,
                isChecked = shortageScarcityChecked.value,
                onCheckedChange = { shortageScarcityChecked.value = it }
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = string.COMMUNICATIONS,
                fontSize = 18.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(16.dp))

            HomeworkCard(
                title = string.STRATEGY,
                isChecked = strategyChecked.value,
                onCheckedChange = { strategyChecked.value = it }
            )

            Spacer(modifier = Modifier.height(16    .dp))

            HomeworkCard(
                title = string.PRESENTATION_ROUND,
                isChecked = presentationRoundChecked.value,
                onCheckedChange = { presentationRoundChecked.value = it }
            )

        }
    }
}

@Composable
fun HomeworkCard(
    title: String,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 5.dp,
        backgroundColor = colors.blue
    )
    {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            //Text
            Text(
                text = title,
                style = MaterialTheme.typography.h6,
                color = Color.White
            )

            //Checkbox
            Checkbox(
                checked = isChecked,
                onCheckedChange = onCheckedChange,
                colors = CheckboxDefaults.colors(
                    checkedColor = colors.green,
                    uncheckedColor = Color.Black
                )
            )
        }

    }
}