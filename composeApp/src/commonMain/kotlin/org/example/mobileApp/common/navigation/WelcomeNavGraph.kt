package org.example.mobileApp.common.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.mobileApp.ui.AboutScreen
import org.example.mobileApp.ui.CartScreen
import org.example.mobileApp.ui.FillProfileScreen
import org.example.mobileApp.ui.HomeScreen
import org.example.mobileApp.ui.LoginScreen
import org.example.mobileApp.ui.NotificationScreen
import org.example.mobileApp.ui.OTPScreen
import org.example.mobileApp.ui.OnboardingScreen
import org.example.mobileApp.ui.PasswordScreen
import org.example.mobileApp.ui.PhoneNumberScreen
import org.example.mobileApp.ui.ProductDetailScreen
import org.example.mobileApp.ui.SharedElementTransitionScreen
import org.example.mobileApp.ui.ShopScreen
import org.example.mobileApp.ui.SignupScreen
import org.example.mobileApp.ui.TermsAndConditionScreen
import org.example.mobileApp.ui.WelcomeScreen

@Composable
fun WelcomeNavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "welcome")
    {
        composable("welcome") { WelcomeScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("signup") { SignupScreen(navController) }
        composable("phoneNumber") { PhoneNumberScreen(navController) }
        composable("otp/{phoneNumber}") { backStackEntry ->
            val phoneNumber = backStackEntry.arguments?.getString("phoneNumber")
            OTPScreen(navController = navController, phoneNumber = phoneNumber)
        }
        composable("onboarding/{source}") { backStackEntry ->
            val source = backStackEntry.arguments?.getString("source")
            OnboardingScreen(navController = navController, source = source)
        }
        composable("password") { PasswordScreen(navController) }
        composable("terms_conditions") { TermsAndConditionScreen(navController) }
        composable("notification") { NotificationScreen(navController) }
        composable("fillProfile") { FillProfileScreen(navController) }
        composable("home") { HomeScreen(navController) }
        composable("shop") { ShopScreen(navController) }
        composable("about") { AboutScreen(navController) }
        composable("cart") { CartScreen(navController) }
        /*composable(
            route = "cart_screen/{productTitle}/{productPrice}/{imageRes}",
            arguments = listOf(
                navArgument("productTitle") { type = NavType.StringType },
                navArgument("productPrice") { type = NavType.FloatType },
                navArgument("imageRes") { type = NavType.StringType } // Passing image resource name as a String
            )
        ) { backStackEntry ->
            val productTitle = backStackEntry.arguments?.getString("productTitle")
            val productPrice = backStackEntry.arguments?.getFloat("productPrice")
            val imageResName = backStackEntry.arguments?.getString("imageRes") ?: ""

            CartScreen(productTitle, productPrice, imageResName)
        }
*/

        composable("product") { ProductDetailScreen(navController) }

        composable("transition") { SharedElementTransitionScreen() }
    }
}