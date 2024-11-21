package org.example.localStorage

actual fun provideKeyValueStorage(): KeyValueStorage {
    return IOSKeyValueStorage()
}
