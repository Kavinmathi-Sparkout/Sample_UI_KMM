package org.example.MobileApp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kmp_sample_ui_design.composeapp.generated.resources.Res
import kmp_sample_ui_design.composeapp.generated.resources.denimJacket
import kmp_sample_ui_design.composeapp.generated.resources.floralDress
import kmp_sample_ui_design.composeapp.generated.resources.redDress
import kmp_sample_ui_design.composeapp.generated.resources.skinnyJeans
import org.example.MobileApp.common.model.CartItem
import org.jetbrains.compose.resources.painterResource

@Composable
fun CartScreen(navController: NavController) {
    // Drawer state and coroutine scope
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize()) {
        // Main Content (Separate from the drawer)
        CartScreenContent()

        // Dimmed background when the drawer is open
        if (drawerState.isOpen) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent.copy(alpha = 0.3f)) // Semi-transparent overlay
            )
        }

        // Navigation Drawer (Overlays on top when open)
        NavigationDrawer(navController, drawerState, scope)
    }
}

@Composable
fun CartScreenContent() {
    val cartItems = listOf(
        CartItem(imageRes = Res.drawable.redDress, title = "Red Dress", price = 49.99),
        CartItem(imageRes = Res.drawable.denimJacket, title = "Denim Jacket", price = 69.99),
        CartItem(imageRes = Res.drawable.skinnyJeans, title = "Skinny Jeans", price = 39.99),
        CartItem(imageRes = Res.drawable.floralDress, title = "Floral Dress", price = 59.99)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Shopping Cart",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Display each item in the cart
        cartItems.forEach { item ->
            CartScreenCard(cartItem = item)

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun CartScreenCard(cartItem: CartItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp) // Rounded corners for a nice card look
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp), // Padding inside the card for spacing
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(cartItem.imageRes),
                contentDescription = cartItem.title,
                modifier = Modifier
                    .size(80.dp)
                    .padding(end = 16.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = cartItem.title,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = "$${cartItem.price}",
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
