package org.example.localStorage

import androidx.compose.runtime.Composable

@Composable
fun MainScreen() {
    val storage = provideKeyValueStorage() // Get platform-specific implementation
    KeyValueStorageScreen(storage)
}
