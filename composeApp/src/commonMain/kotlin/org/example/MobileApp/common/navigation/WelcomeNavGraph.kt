package org.example.MobileApp.common.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.MobileApp.AboutScreen
import org.example.MobileApp.FillProfileScreen
import org.example.MobileApp.HomeScreen
import org.example.MobileApp.LoginScreen
import org.example.MobileApp.NotificationScreen
import org.example.MobileApp.OTPScreen
import org.example.MobileApp.OnboardingScreen
import org.example.MobileApp.PasswordScreen
import org.example.MobileApp.PhoneNumberScreen
import org.example.MobileApp.ShopScreen
import org.example.MobileApp.SignupScreen
import org.example.MobileApp.TermsAndConditionScreen
import org.example.MobileApp.WelcomeScreen

@Composable
fun WelcomeNavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "welcome")
    {
        composable("welcome"){ WelcomeScreen(navController) }
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
        composable("password") {PasswordScreen(navController)}
        composable("terms_conditions") {TermsAndConditionScreen(navController)}
        composable("notification"){ NotificationScreen(navController) }
        composable("fillProfile"){ FillProfileScreen(navController) }
        composable("home"){ HomeScreen(navController) }
        composable("shop"){ ShopScreen(navController) }
        composable("about"){ AboutScreen(navController) }
    }
}