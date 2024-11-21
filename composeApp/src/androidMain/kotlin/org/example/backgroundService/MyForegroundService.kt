package org.example.backgroundService

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log

class MyForegroundService : Service() {

    @SuppressLint("NewApi")
    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
        val notification = Notification.Builder(this, "channel_id")
            .setContentTitle("Background Service")
            .setContentText("Service is running...")
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .build()
        startForeground(1, notification)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("MyForegroundService", "Background task is running")
        // Simulate a task by periodically logging
        Thread {
            while (true) {
                Thread.sleep(5000)
                Log.d("MyForegroundService", "Background task is still running...")
            }
        }.start()
        return START_STICKY
    }


    override fun onDestroy() {
        super.onDestroy()
        // Clean up resources
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "channel_id", "Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)
        }
    }
}
