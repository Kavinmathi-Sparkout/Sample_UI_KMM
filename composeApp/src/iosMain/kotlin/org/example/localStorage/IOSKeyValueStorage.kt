package org.example.localStorage

import platform.Foundation.NSUserDefaults

class IOSKeyValueStorage : KeyValueStorage {
    private val userDefaults = NSUserDefaults.standardUserDefaults()

    override suspend fun save(key: String, value: String) {
        userDefaults.setObject(value, key)
    }

    override suspend fun get(key: String): String? {
        return userDefaults.stringForKey(key)
    }

    override suspend fun remove(key: String) {
        userDefaults.removeObjectForKey(key)
    }
}
