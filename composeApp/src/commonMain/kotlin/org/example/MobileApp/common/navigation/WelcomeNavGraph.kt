package org.example.MobileApp.common.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.example.MobileApp.ui.AboutScreen
import org.example.MobileApp.ui.CartScreen
import org.example.MobileApp.ui.DetailTransitionScreen
import org.example.MobileApp.ui.FillProfileScreen
import org.example.MobileApp.ui.HomeScreen
import org.example.MobileApp.ui.LoginScreen
import org.example.MobileApp.ui.NotificationScreen
import org.example.MobileApp.ui.OTPScreen
import org.example.MobileApp.ui.OnboardingScreen
import org.example.MobileApp.ui.PasswordScreen
import org.example.MobileApp.ui.PhoneNumberScreen
import org.example.MobileApp.ui.ProductDetailScreen
import org.example.MobileApp.ui.SharedElementTransitionScreen
import org.example.MobileApp.ui.ShopScreen
import org.example.MobileApp.ui.SignupScreen
import org.example.MobileApp.ui.TermsAndConditionScreen
import org.example.MobileApp.ui.WelcomeScreen

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