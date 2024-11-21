package org.example.localStorage

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

private val Context.dataStore by preferencesDataStore(name = "settings")

class AndroidKeyValueStorage(private val context: Context) : KeyValueStorage {
    private val dataStore = context.dataStore

    override suspend fun save(key: String, value: String) {
        val dataKey = stringPreferencesKey(key)
        dataStore.edit { preferences ->
            preferences[dataKey] = value
        }
    }

    override suspend fun get(key: String): String? {
        val dataKey = stringPreferencesKey(key)
        val preferences = dataStore.data.first()
        return preferences[dataKey]
    }

    override suspend fun remove(key: String) {
        val dataKey = stringPreferencesKey(key)
        dataStore.edit { preferences ->
            preferences.remove(dataKey)
        }
    }
}
