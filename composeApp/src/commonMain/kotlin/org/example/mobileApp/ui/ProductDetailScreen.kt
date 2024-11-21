package org.example.mobileApp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kmp_sample_ui_design.composeapp.generated.resources.Res
import kmp_sample_ui_design.composeapp.generated.resources.background
import kmp_sample_ui_design.composeapp.generated.resources.leatherBoots
import org.example.mobileApp.common.values.colors
import org.example.mobileApp.common.values.string
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProductDetailScreen(navController: NavController) {
    var selectedSize by remember { mutableStateOf<String?>(null) }

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            ProductImageSection(navController)
            Spacer(modifier = Modifier.height(16.dp))
            ProductDetailsSection(
                selectedSize = selectedSize,
                onSizeSelected = { selectedSize = it }
            )
        }
        item {
            ProductInfoScreen()
        }
    }
}

@Composable
fun ProductImageSection(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(Res.drawable.leatherBoots), // Replace with your image resource
            contentDescription = string.PRODUCT_IMAGE,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }
        IconButton(
            onClick = { /* Handle share action */ },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
        ) {
            Icon(imageVector = Icons.Default.Share, contentDescription = "Share")
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(horizontal = 24.dp) // Add padding to position the Box
                .offset(y = (25).dp) // Adjust this value to move the icon up
                .background(Color.White, shape = CircleShape)
        ) {
            // Add to cart button
            IconButton(
                onClick = { /* Handle add to cart */ },
//                modifier = Modifier
//                    .offset(y = (40).dp) // Adjust this value to move the icon up
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Add to Cart",
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    }
}

@Composable
fun ProductDetailsSection(selectedSize: String?, onSizeSelected: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = string.LEATHER_BOOTS,
                    style = MaterialTheme.typography.h6,
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = string.BRAND_NAME,
                    style = MaterialTheme.typography.body2,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = "$${string.LEATHER_BOOTS_PRICE}",
                style = MaterialTheme.typography.h6,
                color = Color.Black,
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = string.SIZE, style = MaterialTheme.typography.h6)

        // Size selection row
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            val sizes = listOf("36", "37", "38", "39", "40", "41")
            sizes.forEach { size ->
                SizeButton(
                    size = size,
                    isSelected = size == selectedSize,
                    onClick = { onSizeSelected(size) }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { /* Navigate to Info */ }
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = string.IMAGES,
                style = MaterialTheme.typography.h6,
                fontSize = 20.sp,
            )

            Icon(
                imageVector = Icons.Default.KeyboardArrowRight, // Arrow icon
                contentDescription = "Arrow Icon"
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { /* Navigate to Info */ }
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Info",
                style = MaterialTheme.typography.h6,
                fontSize = 20.sp,
            )

            Icon(
                imageVector = Icons.Default.KeyboardArrowRight, // Arrow icon
                contentDescription = "Arrow Icon"
            )
        }
    }
}

@Composable
fun ProductInfoScreen() {
    var isDeliveryExpanded by remember { mutableStateOf(false) }
    var isReviewsExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        // Delivery and Return Section
        ExpandableSection(
            title = string.DELIVERY_RETURN,
            isExpanded = isDeliveryExpanded,
            onExpandToggle = { isDeliveryExpanded = !isDeliveryExpanded }
        ) {
            DeliveryInfo()
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Reviews Section
        ExpandableSection(
            title = string.REVIEW,
            isExpanded = isReviewsExpanded,
            onExpandToggle = { isReviewsExpanded = !isReviewsExpanded }
        ) {
            ReviewsList()
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun SizeButton(size: String, isSelected: Boolean, onClick: () -> Unit) {
    val backgroundColor = if (isSelected) colors.pink else Color.Transparent
    val textColor = if (isSelected) Color.White else Color.Black

    Box(
        modifier = Modifier
            .size(48.dp)
            .background(backgroundColor, shape = RoundedCornerShape(8.dp))
            .border(1.dp, Color.Gray, shape = RoundedCornerShape(8.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = size,
            color = textColor,
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable
fun ExpandableSection(
    title: String,
    isExpanded: Boolean,
    onExpandToggle: () -> Unit,
    content: @Composable () -> Unit
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onExpandToggle() },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.weight(1f),
                fontSize = 20.sp
            )
            Icon(
                imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                contentDescription = null
            )
        }
        if (isExpanded) {
            content()
        }
    }
}

@Composable
fun DeliveryInfo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        val items = listOf(
            string.RETURN1,
            string.RETURN2,
            string.RETURN3
        )
        items.forEach { item ->
            Row(
                modifier = Modifier.padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    tint = Color(0xFFFF9800),
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = item, style = MaterialTheme.typography.body2, fontSize = 16.sp)
            }
        }
    }
}

@Composable
fun ReviewsList() {
    Column(modifier = Modifier.fillMaxWidth()) {
        ReviewItem(
            imageUrl = Res.drawable.background,
            name = string.RICHARD,
            rating = 5,
            reviewText = string.RICHARD_REVIEW
        )
        Spacer(modifier = Modifier.height(16.dp))
        ReviewItem(
            imageUrl = Res.drawable.background,
            name = string.MONICA,
            rating = 5,
            reviewText = string.MONICA_REVIEW
        )
    }
}

@Composable
fun ReviewItem(imageUrl: DrawableResource, name: String, rating: Int, reviewText: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        // Profile Picture
        Image(
            painter = painterResource(imageUrl) , // Replace with actual image resource
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(Color.Gray),
            contentScale = ContentScale.Crop // This ensures the image fills the circle and crops as necessary
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            // Rating Stars
            Row {
                repeat(rating) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = Color(0xFFFF9800),
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            // Review Text
            Text(text = reviewText, style = MaterialTheme.typography.body2)
            Spacer(modifier = Modifier.height(4.dp))
            // Reviewer Name
            Text(text = name, style = MaterialTheme.typography.body2, fontWeight = FontWeight.Bold)
        }
    }
}
