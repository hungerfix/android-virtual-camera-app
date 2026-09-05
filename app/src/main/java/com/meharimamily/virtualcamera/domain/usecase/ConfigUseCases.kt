package com.meharimamily.virtualcamera.domain.usecase

import com.meharimamily.virtualcamera.data.model.CameraConfig
import com.meharimamily.virtualcamera.data.repository.CameraConfigRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllConfigsUseCase @Inject constructor(
    private val repository: CameraConfigRepository
) {
    operator fun invoke(): Flow<List<CameraConfig>> = repository.getAllConfigs()
}

class GetConfigByIdUseCase @Inject constructor(
    private val repository: CameraConfigRepository
) {
    suspend operator fun invoke(id: String): CameraConfig? = repository.getConfigById(id)
}

class SaveConfigUseCase @Inject constructor(
    private val repository: CameraConfigRepository
) {
    suspend operator fun invoke(config: CameraConfig) = repository.saveConfig(config)
}

class DeleteConfigUseCase @Inject constructor(
    private val repository: CameraConfigRepository
) {
    suspend operator fun invoke(id: String) = repository.deleteConfig(id)
}

class UpdateConfigUseCase @Inject constructor(
    private val repository: CameraConfigRepository
) {
    suspend operator fun invoke(config: CameraConfig) = repository.updateConfig(config)
}
