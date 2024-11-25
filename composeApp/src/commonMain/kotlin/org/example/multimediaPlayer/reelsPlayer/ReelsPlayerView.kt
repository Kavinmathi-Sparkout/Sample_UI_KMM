package org.example.multimediaPlayer.reelsPlayer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import network.chaintech.compose.multiplatform.media.player.ReelsPlayer
import network.chaintech.compose.multiplatform.media.player.ReelsPlayerState

@Composable
fun ReelsPlayerView(
    modifier: Modifier = Modifier,
    videoUrls: List<String>
) {
    // Remember the reels player state
    val reelsPlayerState = remember { ReelsPlayerState() }

    // ReelsPlayer Composable
    ReelsPlayer(
        modifier = modifier,
        reelsPlayerState = reelsPlayerState,
        videoUrls = videoUrls
    )
}