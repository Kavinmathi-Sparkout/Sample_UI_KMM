package org.example.pictureInPicture.android

import android.app.RemoteAction
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.media3.common.Player

// [START android_compose_pip_broadcast_receiver]
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PlayerBroadcastReceiver(player: Player?) {
    val isInPipMode = rememberIsInPipMode()
    if (!isInPipMode || player == null) {
        // Broadcast receiver is only used if app is in PiP mode and player is non null
        return
    }
    val context = LocalContext.current

    DisposableEffect(player) {
        val broadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                if ((intent == null) || (intent.action != ACTION_BROADCAST_CONTROL)) {
                    return
                }

                when (intent.getIntExtra(EXTRA_CONTROL_TYPE, 0)) {
                    EXTRA_CONTROL_PAUSE -> player.pause()
                    EXTRA_CONTROL_PLAY -> player.play()
                }
            }
        }
        ContextCompat.registerReceiver(
            context,
            broadcastReceiver,
            IntentFilter(ACTION_BROADCAST_CONTROL),
            ContextCompat.RECEIVER_NOT_EXPORTED
        )
        onDispose {
            context.unregisterReceiver(broadcastReceiver)
        }
    }
}
// [END android_compose_pip_broadcast_receiver]

@RequiresApi(Build.VERSION_CODES.O)
fun listOfRemoteActions(): List<RemoteAction> {
    return listOf()
}