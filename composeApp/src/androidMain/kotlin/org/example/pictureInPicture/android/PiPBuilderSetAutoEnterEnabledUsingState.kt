package org.example.pictureInPicture.android

import android.app.PictureInPictureParams
import android.os.Build
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext

@Composable
fun PiPBuilderSetAutoEnterEnabledUsingState(
    shouldEnterPipMode: Boolean,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        // [START android_compose_pip_post_12_should_enter_pip]
        val pipModifier = modifier.onGloballyPositioned { layoutCoordinates ->
            val builder = PictureInPictureParams.Builder()

            // Add autoEnterEnabled for versions S and up
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                builder.setAutoEnterEnabled(shouldEnterPipMode)
            }
            context.findActivity().setPictureInPictureParams(builder.build())
        }

        VideoPlayer(pipModifier)
        // [END android_compose_pip_post_12_should_enter_pip]
    } else {
        Log.i("PIP_TAG", "API does not support PiP")
    }
}
