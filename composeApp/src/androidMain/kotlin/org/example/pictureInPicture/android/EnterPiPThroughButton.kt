package org.example.pictureInPicture.android

import android.app.PictureInPictureParams
import android.os.Build
import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun EnterPiPThroughButton() {
    val context = LocalContext.current
    Button(onClick = {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.findActivity().enterPictureInPictureMode(
                PictureInPictureParams.Builder().build()
            )
        } else {
            Log.i("PIP_TAG", "API does not support PiP")
        }
    }) {
        Text(text = "Enter PiP mode!")
    }
}