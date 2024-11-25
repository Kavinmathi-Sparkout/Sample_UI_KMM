package org.example.multimediaPlayer

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import network.chaintech.compose.multiplatform.media.player.PlayerConfig
import androidx.compose.ui.Modifier

@Composable
fun VideoPlayerMainScreen() {
    Surface(color = MaterialTheme.colorScheme.background) {
        VideoPlayerView(
            modifier = Modifier.fillMaxSize(),
            url = "https://www.example.com/path/to/video.mp4",
            playerConfig = PlayerConfig(
                isPauseResumeEnabled = true,
                isSeekBarVisible = true,
                isDurationVisible = true,
                seekBarThumbColor = Color.Red,
                seekBarActiveTrackColor = Color.Red,
                seekBarInactiveTrackColor = Color.White,
                durationTextColor = Color.White,
                seekBarBottomPadding = 10.dp,
                pauseResumeIconSize = 40.dp,
                isAutoHideControlEnabled = true,
                controlHideIntervalSeconds = 5,
                isFastForwardBackwardEnabled = true,
                playIconResource = Res.drawable.icn_play, // Make sure to replace with your actual resource
                pauseIconResource = Res.drawable.icn_pause  // Make sure to replace with your actual resource
            )
        )
    }
}
