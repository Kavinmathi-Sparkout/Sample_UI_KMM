package org.example.multimediaPlayer.audioPlayer

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import network.chaintech.compose.multiplatform.media.player.AudioPlayerConfig
import androidx.compose.ui.Modifier

@Composable
fun AudioMainScreen() {
    Surface(color = MaterialTheme.colorScheme.background) {
        // Video Player
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
                playIconResource = Res.drawable.icn_play,
                pauseIconResource = Res.drawable.icn_pause
            )
        )

        // Audio Player
        val audioFilesArray = listOf(
            AudioFile(
                audioUrl = "https://codeskulptor-demos.commondatastorage.googleapis.com/GalaxyInvaders/theme_01.mp3",
                audioTitle = "Galaxy Invaders",
                thumbnailUrl = "https://c.saavncdn.com/866/On-My-Way-English-2019-20190308195918-500x500.jpg"
            ),
            AudioFile(
                audioUrl = "https://codeskulptor-demos.commondatastorage.googleapis.com/pang/paza-moduless.mp3",
                audioTitle = "Paza Moduless"
            )
        )

        AudioPlayerView(
            modifier = Modifier.fillMaxSize(),
            audios = audioFilesArray,
            audioPlayerConfig = AudioPlayerConfig(
                isControlsVisible = true,
                fontColor = Color.White,
                iconsTintColor = Color.White
            )
        )
    }
}
