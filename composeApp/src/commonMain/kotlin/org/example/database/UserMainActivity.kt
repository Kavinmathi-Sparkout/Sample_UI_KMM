package org.example.database

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun UserMainActivity(userDao: UserDao) {
    MaterialTheme {
        val user by userDao.getAll().collectAsState(initial = emptyList())
        val scope = rememberCoroutineScope()

        LaunchedEffect(true) {
            val user = listOf(
                User(name = "AAAA"),
                User(name = "BBBB"),
                User(name = "CCCC"),
                User(name = "DDDD"),
                User(name = "EEEE"),
                User(name = "FFFF"),
                User(name = "GGGG")
            )

            user.forEach {
                userDao.insert(it)
            }
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize()
                .padding(16.dp)
        ) {
            items(user) { user ->
                Text(
                    text = user.name,
                    modifier = Modifier.fillMaxWidth()
                        .clickable {
                            scope.launch {
                                userDao.delete(user)
                            }
                        }
                        .padding(16.dp)
                )
            }
        }
    }
}