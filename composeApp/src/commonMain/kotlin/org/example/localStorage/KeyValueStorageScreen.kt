package org.example.localStorage

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun KeyValueStorageScreen(storage: KeyValueStorage) {
    val scope = rememberCoroutineScope()
    var key by remember { mutableStateOf("") }
    var value by remember { mutableStateOf("") }
    var retrievedValue by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextField(
            value = key,
            onValueChange = { key = it },
            label = { Text("Key") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = value,
            onValueChange = { value = it },
            label = { Text("Value") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                scope.launch {
                    storage.save(key, value)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save Data")
        }
        Button(
            onClick = {
                scope.launch {
                    retrievedValue = storage.get(key) ?: "No data found"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Retrieve Data")
        }
        Button(
            onClick = {
                scope.launch {
                    storage.remove(key)
                    retrievedValue = "Data removed"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Delete Data")
        }
        Text("Retrieved Value: $retrievedValue")
    }
}
