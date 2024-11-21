package org.example.mobileApp.ui

/*
import androidx.compose.animation.core.Transition
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kmp_sample_ui_design.composeapp.generated.resources.Res
import kmp_sample_ui_design.composeapp.generated.resources.redDress
import org.jetbrains.compose.resources.painterResource

@Composable
fun HomeTransitionScreen (navController: NavController) {
    val items = (0..9).toList() // Sample data

    LazyColumn {
        items(items) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clickable {
                        navController.navigate("detail/$item")
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Use Transition modifier
                Transition(imageKey = "image_$item") {
                    Image(
                        painter = painterResource(Res.drawable.redDress), // Replace with your image resource
                        contentDescription = null,
                        modifier = Modifier.size(100.dp)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                // Use Transition modifier
                Transition(textKey = "text_$item") {
                    Text(
                        text = "Item #$item"
                    )
                }
            }
        }
    }
}*/
