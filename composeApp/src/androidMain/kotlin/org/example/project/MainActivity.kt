package org.example.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import org.example.database.UserMainActivity
import org.example.database.getUserDatabase
import org.example.eventBus.EventBusMainScreen
import org.example.firebaseAuthentication.AuthenticationScreen
import org.example.firebaseAuthentication.getAuthManager
import org.example.localStorage.MainScreen
import org.example.mobileApp.common.navigation.WelcomeNavGraph
import org.example.pictureInPicture.PiPScreen
import org.example.studyApp.HomePageScreen
import org.example.swipeRefresh.AndroidSwipeRefreshExample
import org.example.swipeRefresh.DataFetcher

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FirebaseApp.initializeApp(this)
        FirebaseAuth.getInstance()

        setContent {
//            EventBusMainScreen()

            //Instance of DataFetcher
            val dataFetcher = DataFetcher()
            //Passing the instance to the AndroidSwipeRefreshExample
            AndroidSwipeRefreshExample(dataFetcher)

            /*AuthenticationScreen(authManager = getAuthManager())
            PiPScreen(this)*/

//           AppNavGraph()
//            CalculatorScreen()
//            WelcomeNavGraph()
//            MainScreen()
           /* val dao = getUserDatabase(this).userDao()
            UserMainActivity(dao)*/
        }
    }
}

@Preview(device = "id:pixel_8", backgroundColor = 0xFFF1EFEF)
@Composable
fun AppAndroidPreview() {
    HomePageScreen(rememberNavController())
}