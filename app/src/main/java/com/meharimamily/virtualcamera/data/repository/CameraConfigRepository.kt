package com.meharimamily.virtualcamera.data.repository

import com.meharimamily.virtualcamera.data.model.CameraConfig
import kotlinx.coroutines.flow.Flow

interface CameraConfigRepository {
    fun getAllConfigs(): Flow<List<CameraConfig>>
    suspend fun getConfigById(id: String): CameraConfig?
    suspend fun saveConfig(config: CameraConfig)
    suspend fun deleteConfig(id: String)
    suspend fun updateConfig(config: CameraConfig)
}
