package org.example.project

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import org.example.database.UserMainActivity
import org.example.database.getUserDatabase

fun MainViewController() = ComposeUIViewController {
//    App()

    val dao = remember {
        getUserDatabase().userDao()
    }
    UserMainActivity(dao)
}