package org.example.backgroundService

import android.content.Context
import android.content.Intent

actual class BackgroundServiceImpl(private val context: Context) : BackgroundService {

    override fun startService() {
        val intent = Intent(context, MyForegroundService::class.java)
        context.startForegroundService(intent)
    }

    override fun stopService() {
        val intent = Intent(context, MyForegroundService::class.java)
        context.stopService(intent)
    }
}
