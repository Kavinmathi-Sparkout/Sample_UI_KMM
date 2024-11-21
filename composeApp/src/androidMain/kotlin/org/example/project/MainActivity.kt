package org.example.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import org.example.localStorage.MainScreen
import org.example.mobileApp.common.navigation.WelcomeNavGraph
import org.example.studyApp.HomePageScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
//           AppNavGraph()
//            CalculatorScreen()
//            WelcomeNavGraph()
            MainScreen()
        }
    }
}

@Preview(device = "id:pixel_8", backgroundColor = 0xFFF1EFEF)
@Composable
fun AppAndroidPreview() {
    HomePageScreen(rememberNavController())
}