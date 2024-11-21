package org.example.backgroundService

import platform.UIKit.UIApplication
import kotlinx.cinterop.ObjCAction
import platform.Foundation.NSTimer

actual class BackgroundServiceImpl : BackgroundService {

    private var timer: NSTimer? = null

    override fun startService() {
        UIApplication.sharedApplication.beginBackgroundTaskWithName("BackgroundTask") {
            // Background task timeout handling
            println("Background task ended.")
        }
        startTimer()
    }

    override fun stopService() {
        timer?.invalidate()
        timer = null
    }

    private fun startTimer() {
        timer = NSTimer.scheduledTimerWithTimeInterval(5.0, true) {
            println("Background task is running...")
        }
        println("Timer started for background task")
    }
}
