package org.example.localStorage

import android.content.Context
import org.example.MyApp

actual fun provideKeyValueStorage(): KeyValueStorage {
    return AndroidKeyValueStorage(MyApp.instance)
}

