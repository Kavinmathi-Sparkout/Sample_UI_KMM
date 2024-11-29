package org.example.swipeRefresh

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.launch

@Composable
fun AndroidSwipeRefreshExample(dataFetcher: DataFetcher) {
    var isRefreshing by remember { mutableStateOf(false) }
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing)
    val coroutineScope = rememberCoroutineScope()  // Create a coroutine scope

    SwipeRefresh(
        state = swipeRefreshState,
        onRefresh = {
            isRefreshing = true
            coroutineScope.launch {  // Launch a coroutine in the scope
                dataFetcher.fetchData()
                isRefreshing = false
            }
        },
        modifier = Modifier.fillMaxSize()
    ) {
        // Your content goes here
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ) {
            Text("Swipe down to refresh", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            repeat(20) {
                Text("Item #$it")
            }
        }
    }
}