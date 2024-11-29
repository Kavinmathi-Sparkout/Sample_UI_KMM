package org.example.pictureInPicture

import android.app.Activity
import android.app.PictureInPictureParams
import android.content.Context
import android.os.Build
import android.util.Rational

actual fun enterPictureInPictureMode(context: Any?) {
    val activity = context as? Activity ?: return
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val aspectRatio = Rational(16, 9) // Aspect ratio for PiP mode
        val params = PictureInPictureParams.Builder()
            .setAspectRatio(aspectRatio)
            .build()
        activity.enterPictureInPictureMode(params)
    }
}
