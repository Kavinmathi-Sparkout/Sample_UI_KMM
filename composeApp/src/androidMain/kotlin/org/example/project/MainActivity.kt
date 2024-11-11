package org.example.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import org.example.MobileApp.common.navigation.WelcomeNavGraph
import org.example.calculatorApp.CalculatorScreen
import org.example.studyApp.HomePageScreen
import org.example.studyApp.common.navigation.AppNavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
//           AppNavGraph()
//            CalculatorScreen()
            WelcomeNavGraph()
        }
    }
}

@Preview(device = "id:pixel_8", backgroundColor = 0xFFF1EFEF)
@Composable
fun AppAndroidPreview() {
    HomePageScreen(rememberNavController())
}