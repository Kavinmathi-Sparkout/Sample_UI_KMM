package org.example.pictureInPicture

import kotlinx.cinterop.ObjCAction
import platform.UIKit.UIViewController

actual fun enterPictureInPictureMode(context: Any?) {
    println("PiP is not supported natively on iOS.")
}