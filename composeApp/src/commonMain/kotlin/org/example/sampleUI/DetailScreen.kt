package org.example.sampleUI

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kmp_sample_ui_design.composeapp.generated.resources.Res
import kmp_sample_ui_design.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource

@Composable
fun DetailScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        GradientBox(modifier = Modifier.fillMaxSize(), content = {
            Column {
                TopAppBar()
                Spacer(modifier = Modifier.height(10.dp))
                ImageSection()
                Spacer(modifier = Modifier.height(10.dp))
            }
        })
    }
}

@Composable
fun TopAppBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {

        }) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
        }

        Text(
            text = "Detail",
            color = Color.White,
            fontSize = 20.sp
        )

        IconButton(onClick = {

        }) {
            Icon(Icons.Default.FavoriteBorder, contentDescription = "Favourite", tint = Color.White)
        }
    }
}

@Composable
fun ImageSection() {
    Card(
        modifier = Modifier.fillMaxWidth()
            .padding(20.dp)
            .height(400.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = 30.dp
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            GradientBox(modifier = Modifier.fillMaxSize(), content = {
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .height(400.dp),
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.compose_multiplatform),
                            contentDescription = "Compose Image",
                            modifier = Modifier.fillMaxWidth()
                                .height(350.dp)
                                .clip(RoundedCornerShape(16.dp)),
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            text = "Kotlin Multiplatform Development",
                            color = Color.White,
                            modifier = Modifier.padding(start = 25.dp)
                        )
                    }
                }
            })

            // Card for bottom-right corner, overlaid on top of content
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .align(Alignment.BottomEnd) // Aligns the card to the bottom-right
                    .padding(16.dp) // Adjusts padding from the card's edges
            ) {
                // Custom Box to draw borders
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    // Draw the top and left borders
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        val borderColor = Color.White
                        val borderStrokeWidth = 5.dp.toPx()

                        // Draw top border
                        drawLine(
                            color = borderColor,
                            start = Offset(0f, 0f),
                            end = Offset(size.width, 0f),
                            strokeWidth = borderStrokeWidth
                        )

                        // Draw left border
                        drawLine(
                            color = borderColor,
                            start = Offset(0f, 0f),
                            end = Offset(0f, size.height),
                            strokeWidth = borderStrokeWidth
                        )
                    }

                    // Content of the inner card
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        // Displaying 5 stars as text
                        Column {
                                Icon(
                                    imageVector = Icons.Default.Star, // Use a star icon
                                    contentDescription = "Star",
                                    tint = Color.Yellow // Set color for the stars
                                )
                            Text(text = "Rating",
                                fontSize = 10.sp,
                                color = Color.White)

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Card(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .width(120.dp)
            .height(120.dp)
            .background(Color.White, shape = RoundedCornerShape(16.dp))
            .clickable(onClick = onClick)
    )
}

@Composable
fun Grid(
    modifier: Modifier = Modifier,
    items: List<Any>,
    columns: Int = 2
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(columns),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        items(items) { item ->
            Card(onClick = { /* handle click */ })
        }
    }
}