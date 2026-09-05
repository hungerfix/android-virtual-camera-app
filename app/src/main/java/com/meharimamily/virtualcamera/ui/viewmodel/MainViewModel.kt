package com.meharimamily.virtualcamera.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meharimamily.virtualcamera.data.model.CameraConfig
import com.meharimamily.virtualcamera.domain.usecase.DeleteConfigUseCase
import com.meharimamily.virtualcamera.domain.usecase.GetAllConfigsUseCase
import com.meharimamily.virtualcamera.domain.usecase.SaveConfigUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllConfigsUseCase: GetAllConfigsUseCase,
    private val saveConfigUseCase: SaveConfigUseCase,
    private val deleteConfigUseCase: DeleteConfigUseCase
) : ViewModel() {

    val configs = getAllConfigsUseCase().stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = emptyList()
    )

    fun createNewConfig(name: String) {
        viewModelScope.launch {
            try {
                val newConfig = CameraConfig(
                    id = UUID.randomUUID().toString(),
                    name = name
                )
                saveConfigUseCase(newConfig)
                Timber.d("Config created: $name")
            } catch (e: Exception) {
                Timber.e(e, "Error creating config")
            }
        }
    }

    fun deleteConfig(configId: String) {
        viewModelScope.launch {
            try {
                deleteConfigUseCase(configId)
                Timber.d("Config deleted: $configId")
            } catch (e: Exception) {
                Timber.e(e, "Error deleting config")
            }
        }
    }
}
