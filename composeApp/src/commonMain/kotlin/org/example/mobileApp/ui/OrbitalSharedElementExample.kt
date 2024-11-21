package org.example.mobileApp.ui

/*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.skydoves.orbital.Orbital
import com.skydoves.orbital.OrbitalScope


@Composable
fun OrbitalSharedElementExample() {
    var showDetail by remember { mutableStateOf(false) }
    val sharedImageUrl = "https://via.placeholder.com/150"

    Box(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        if (showDetail) {
            Orbital(
                onBackPressed = { showDetail = false },
                content = {
                    DetailTransitionScreen(sharedImageUrl) {
                        showDetail = false
                    }
                },
                preview = {
                    SharedImage(sharedImageUrl)
                }
            )
        } else {
            ListTransitionScreen(sharedImageUrl) {
                showDetail = true
            }
        }
    }
}


@Composable
fun OrbitalScope.SharedImage(sharedImageUrl: String) {
    Image(
        painter = rememberAsyncImagePainter(sharedImageUrl),
        contentDescription = "Shared Image",
        modifier = Modifier
            .size(300.dp)
            .background(Color.LightGray, RoundedCornerShape(16.dp)),
        contentScale = ContentScale.Crop
    )
}*/
