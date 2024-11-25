package org.example.multimediaPlayer

/*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import network.chaintech.composemedia.*

@Composable
fun VideoPlayerScreen(videoUrl: String) {
    // Media player state
    val mediaPlayerState = rememberMediaPlayerState()

    // UI
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Video Player") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16 / 9f) // Maintain a 16:9 aspect ratio for video
                    .background(MaterialTheme.colorScheme.secondaryContainer),
                contentAlignment = Alignment.Center
            ) {
                MediaPlayer(
                    mediaPlayerState = mediaPlayerState,
                    modifier = Modifier.fillMaxSize(),
                    mediaSource = MediaSource.Video(
                        url = videoUrl,
                        title = "Sample Video"
                    )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            PlaybackControls(mediaPlayerState = mediaPlayerState)
        }
    }
}

@Composable
fun PlaybackControls(mediaPlayerState: MediaPlayerState) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(onClick = { mediaPlayerState.play() }) {
            Text("Play")
        }

        Button(onClick = { mediaPlayerState.pause() }) {
            Text("Pause")
        }

        Button(onClick = { mediaPlayerState.stop() }) {
            Text("Stop")
        }
    }
}
*/

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import network.chaintech.compose.multiplatform.media.player.VideoPlayer
import network.chaintech.compose.multiplatform.media.player.VideoPlayerState

@Composable
fun VideoPlayerScreen(videoUrl: String) {
    // Remember the video player state
    val videoPlayerState = remember { VideoPlayerState() }

    // VideoPlayer Composable
    VideoPlayer(
        modifier = Modifier.fillMaxSize(),
        videoPlayerState = videoPlayerState,
        url = videoUrl
    )
}
