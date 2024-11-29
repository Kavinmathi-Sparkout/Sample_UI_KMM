package org.example.pictureInPicture.android

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer

@Composable
fun ToggleUIBasedOnPiP(
    modifier: Modifier = Modifier,
) {
    // [START android_compose_pip_ui_toggle]
    val inPipMode = rememberIsInPipMode()

    Column(modifier = modifier) {
        // This text will only show up when the app is not in PiP mode
        if (!inPipMode) {
            Text(
                text = "Picture in Picture",
            )
        }
        VideoPlayer()
    }
    // [END android_compose_pip_ui_toggle]
}

fun initializePlayer(context: Context) {
    val player = ExoPlayer.Builder(context.applicationContext)
        .build().apply {}

    // [START android_compose_pip_toggle_pip_on_if_video_is_playing]
    player.addListener(object : Player.Listener {
        override fun onIsPlayingChanged(isPlaying: Boolean) {
            shouldEnterPipMode = isPlaying
        }
    })
    // [END android_compose_pip_toggle_pip_on_if_video_is_playing]
}

// [START android_compose_pip_release_player]
fun releasePlayer() {
    shouldEnterPipMode = false
}
// [END android_compose_pip_release_player]