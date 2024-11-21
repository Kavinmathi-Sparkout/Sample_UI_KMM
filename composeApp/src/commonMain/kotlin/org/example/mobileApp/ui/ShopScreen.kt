package org.example.mobileApp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kmp_sample_ui_design.composeapp.generated.resources.Res
import kmp_sample_ui_design.composeapp.generated.resources.ankleBoots
import kmp_sample_ui_design.composeapp.generated.resources.denimJacket
import kmp_sample_ui_design.composeapp.generated.resources.eveningGown
import kmp_sample_ui_design.composeapp.generated.resources.floralDress
import kmp_sample_ui_design.composeapp.generated.resources.highHeels
import kmp_sample_ui_design.composeapp.generated.resources.knittedSweater
import kmp_sample_ui_design.composeapp.generated.resources.leatherBoots
import kmp_sample_ui_design.composeapp.generated.resources.redDress
import kmp_sample_ui_design.composeapp.generated.resources.skinnyJeans
import kmp_sample_ui_design.composeapp.generated.resources.summerDress
import kmp_sample_ui_design.composeapp.generated.resources.whiteShirt
import org.example.mobileApp.common.model.Product
import org.example.mobileApp.common.values.colors
import org.example.mobileApp.common.values.string
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun ShopScreen(navController: NavController) {
    // Drawer state and coroutine scope
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize()) {
        // Main Content (Separate from the drawer)
        ShopContent()

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
fun ShopContent() {

    val products = listOf(
        Product(
            Res.drawable.redDress,
            string.RED_DRESS,
            string.RED_DRESS_DESC,
            string.RED_DRESS_PRICE.toDouble()
        ),
        Product(
            Res.drawable.denimJacket,
            string.DENIM_JACKET,
            string.DENIM_JACKET_DESC,
            string.DENIM_JACKET_PRICE.toDouble()
        ),
        Product(
            Res.drawable.skinnyJeans,
            string.SKINNY_JEANS,
            string.SKINNY_JEANS_DESC,
            string.SKINNY_JEANS_PRICE.toDouble()
        ),
        Product(
            Res.drawable.leatherBoots,
            string.LEATHER_BOOTS,
            string.LEATHER_BOOTS_DESC,
            string.LEATHER_BOOTS_PRICE.toDouble()
        ),
        Product(
            Res.drawable.floralDress,
            string.FLORAL_DRESS,
            string.FLORAL_DRESS_DESC,
            string.FLORAL_DRESS_PRICE.toDouble()
        ),
        Product(
            Res.drawable.eveningGown,
            string.EVENING_GOWN,
            string.EVENING_GOWN_DESC,
            string.EVENING_GOWN_PRICE.toDouble()
        ),
        Product(
            Res.drawable.summerDress,
            string.SUMMER_DRESS,
            string.SUMMER_DRESS_DESC,
            string.SUMMER_DRESS_PRICE.toDouble()
        ),
        Product(
            Res.drawable.whiteShirt,
            string.WHITE_SHIRT,
            string.WHITE_SHIRT_DESC,
            string.WHITE_SHIRT_PRICE.toDouble()
        ),
        Product(
            Res.drawable.highHeels,
            string.HIGH_HEELS,
            string.HIGH_HEELS_DESC,
            string.HIGH_HEELS_PRICE.toDouble()
        ),
        Product(
            Res.drawable.knittedSweater,
            string.KNITTED_SWEATER,
            string.KNITTED_SWEATER_DESC,
            string.KNITTED_SWEATER_PRICE.toDouble()
        ),
        Product(
            Res.drawable.ankleBoots,
            string.ANKLE_BOOTS,
            string.ANKLE_BOOTS_DESC,
            string.ANKLE_BOOTS_PRICE.toDouble()
        ),

        )
    // Placeholder for the main screen content
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 60.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
//                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(products) { product ->
                ProductCard(
                    imageRes = product.imageRes,
                    title = product.title,
                    description = product.description,
                    price = product.price,
                    onAddToCart = {
                        // Handle add to cart action for this specific product
                        println("Added ${product.title} to cart")
                    }
                )
            }
        }
    }
}

@Composable
fun ProductCard(
    imageRes: DrawableResource,
    title: String,
    description: String,
    price: Double,
    onAddToCart: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(10.dp),  // 10.dp padding only around the Card
        elevation = CardDefaults.elevatedCardElevation(8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(Color.White) // Ensures the card has a white background
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(imageRes),
                contentDescription = "Product Image",
                modifier = Modifier
                    .width(300.dp)
                    .height(400.dp)
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = title,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = description,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "$${price}",
                style = MaterialTheme.typography.body2,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onAddToCart,
                modifier = Modifier
                    .width(250.dp)
                    .height(50.dp)
                    .padding(horizontal = 30.dp),
                shape = RoundedCornerShape(24.dp),
                colors =
                ButtonDefaults.buttonColors(backgroundColor = colors.pink) // Replace with your color
            ) {
                Text(string.BUY, color = Color.White)
            }

            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}
