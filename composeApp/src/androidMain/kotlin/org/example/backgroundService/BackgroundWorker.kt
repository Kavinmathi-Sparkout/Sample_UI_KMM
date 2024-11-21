package org.example.backgroundService

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

class BackgroundWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        // Perform your background task here
        Log.d("BackgroundWorker", "Task running in background")
        return Result.success()
    }
}
