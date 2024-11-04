package org.example.studyApp.common.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.studyApp.LoginScreen
import org.example.studyApp.HomePageScreen

@Composable
fun AppNavGraph (){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login")
    {
        composable("login"){ LoginScreen(navController)}
        composable("homepage"){ HomePageScreen(navController) }
    }
}