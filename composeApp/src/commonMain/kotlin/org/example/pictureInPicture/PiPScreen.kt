package org.example.pictureInPicture

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


// Expect declaration for PiP
expect fun enterPictureInPictureMode(context: Any?)

@Composable
fun PiPScreen(context: Any?) {

    // Button to trigger PiP mode
    Button(onClick = { enterPictureInPictureMode(context) }) {
        Text("Enter PiP Mode")
    }
}
