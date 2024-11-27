package org.example.multimediaPlayer.audioPlayer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import chaintech.videoplayer.model.AudioFile
import chaintech.videoplayer.model.AudioPlayerConfig

@Composable
fun AudioPlayerView(
    modifier: Modifier = Modifier,
    audios: List<AudioFile>,
    audioPlayerConfig: AudioPlayerConfig
) {
    // Remember the audio player state
    val audioPlayerState = remember { AudioPlayerState() }

    // AudioPlayer Composable
    AudioPlayer(
        modifier = modifier,
        audioPlayerState = audioPlayerState,
        audios = audios,
        audioPlayerConfig = audioPlayerConfig
    )
}