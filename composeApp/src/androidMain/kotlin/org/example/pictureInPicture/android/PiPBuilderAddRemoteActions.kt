package org.example.pictureInPicture.android

import android.app.PictureInPictureParams
import android.os.Build
import android.util.Log
import android.util.Rational
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toAndroidRectF
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.core.graphics.toRect
import androidx.media3.common.Player
import androidx.media3.common.VideoSize

@Composable
fun PiPBuilderAddRemoteActions(
    player: Player?,
    shouldEnterPipMode: Boolean,
    modifier: Modifier = Modifier,
) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        // [START android_compose_pip_add_remote_actions]
        val context = LocalContext.current

        val pipModifier = modifier.onGloballyPositioned { layoutCoordinates ->
            val builder = PictureInPictureParams.Builder()
            builder.setActions(
                listOfRemoteActions()
            )

            if (shouldEnterPipMode && player != null && player.videoSize != VideoSize.UNKNOWN) {
                val sourceRect = layoutCoordinates.boundsInWindow().toAndroidRectF().toRect()
                builder.setSourceRectHint(sourceRect)
                builder.setAspectRatio(
                    Rational(player.videoSize.width, player.videoSize.height)
                )
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                builder.setAutoEnterEnabled(shouldEnterPipMode)
            }
            context.findActivity().setPictureInPictureParams(builder.build())
        }
        VideoPlayer(modifier = pipModifier)
        // [END android_compose_pip_add_remote_actions]
    } else {
        Log.i("PIP_TAG", "API does not support PiP")
    }
}