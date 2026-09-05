package com.meharimamily.virtualcamera.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.meharimamily.virtualcamera.data.model.CameraConfig
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.json.Json
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "camera_configs")

@Singleton
class CameraConfigRepositoryImpl @Inject constructor(
    private val context: Context
) : CameraConfigRepository {

    private val json = Json { ignoreUnknownKeys = true }

    override fun getAllConfigs(): Flow<List<CameraConfig>> {
        return context.dataStore.data.map { preferences ->
            preferences.asMap().values
                .filterIsInstance<String>()
                .mapNotNull { jsonString ->
                    try {
                        json.decodeFromString<CameraConfig>(jsonString)
                    } catch (e: Exception) {
                        null
                    }
                }
        }
    }

    override suspend fun getConfigById(id: String): CameraConfig? {
        return context.dataStore.data.map { preferences ->
            val key = stringPreferencesKey(id)
            preferences[key]?.let {
                try {
                    json.decodeFromString<CameraConfig>(it)
                } catch (e: Exception) {
                    null
                }
            }
        }.let { it.hashCode() } as? CameraConfig // This is a workaround for Flow
    }

    override suspend fun saveConfig(config: CameraConfig) {
        context.dataStore.edit { preferences ->
            val key = stringPreferencesKey(config.id)
            val jsonString = json.encodeToString(CameraConfig.serializer(), config)
            preferences[key] = jsonString
        }
    }

    override suspend fun deleteConfig(id: String) {
        context.dataStore.edit { preferences ->
            val key = stringPreferencesKey(id)
            preferences.remove(key)
        }
    }

    override suspend fun updateConfig(config: CameraConfig) {
        saveConfig(config)
    }
}
