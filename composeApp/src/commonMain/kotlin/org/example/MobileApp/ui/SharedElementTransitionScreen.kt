package org.example.MobileApp.ui

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.InternalResourceApi

@OptIn(ExperimentalSharedTransitionApi::class, InternalResourceApi::class)
@Composable
fun SharedElementTransitionScreen() {
    val navController = rememberNavController()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        SharedTransitionLayout {
            NavHost(
                navController = navController,
                startDestination = "list"
            ) {
                // List Screen
                composable("list") {
                    ListTransitionScreen(
                        onItemClick = { resId, text ->
                            navController.navigate("detail/$resId/$text")
                        },
                        animatedVisibilityScope = this
                    )
                }

                // Detail Screen
                composable(
                    route = "detail/{resId}/{text}",
                    arguments = listOf(
                        navArgument("resId") { type = NavType.IntType },
                        navArgument("text") { type = NavType.StringType },
                    )
                ) { backStackEntry ->
                    val resId = backStackEntry.arguments?.getInt("resId") ?: 0
                    val text = backStackEntry.arguments?.getString("text") ?: ""

                    // Convert Int resource ID to DrawableResource using a utility function
                    val drawableResource = getDrawableResourceFromId(resId)

                    // Pass DrawableResource to the DetailScreen
                    DetailTransitionScreen(
                        resId = drawableResource, // Pass DrawableResource
                        text = text,
                        animatedVisibilityScope = this
                    )
                }
            }
        }
    }
}

@OptIn(InternalResourceApi::class)
@Composable
fun getDrawableResourceFromId(resId: Int): DrawableResource {
    // This is a simplified way to get the DrawableResource
    // Depending on your platform setup, you may need to get it differently.
    return DrawableResource(
        resId.toString(),
        items = emptySet()
    ) // Assuming the DrawableResource can be created this way
}
