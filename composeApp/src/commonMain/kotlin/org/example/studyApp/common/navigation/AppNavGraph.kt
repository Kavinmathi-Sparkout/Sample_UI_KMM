package org.example.studyApp.common.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.studyApp.ClassesScreen
import org.example.studyApp.DetailScreen
import org.example.studyApp.ExamScreen
import org.example.studyApp.GradeScreen
import org.example.studyApp.LoginScreen
import org.example.studyApp.HomePageScreen
import org.example.studyApp.HomeworkScreen
import org.example.studyApp.MessageScreen
import org.example.studyApp.TeachersScreen

@Composable
fun AppNavGraph (){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login")
    {
        composable("login"){ LoginScreen(navController)}
        composable("homepage"){ HomePageScreen(navController) }
        composable("classes"){ ClassesScreen(navController) }
        composable("homework"){ HomeworkScreen(navController) }
        composable("exams"){ ExamScreen(navController) }
        composable("teachers"){ TeachersScreen(navController) }
        composable("grade"){ GradeScreen(navController) }
        composable("messages"){ MessageScreen(navController) }
        composable("detail"){ DetailScreen(navController) }
    }
}