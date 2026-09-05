package com.meharimamily.virtualcamera.di

import android.content.Context
import com.meharimamily.virtualcamera.data.repository.CameraConfigRepository
import com.meharimamily.virtualcamera.data.repository.CameraConfigRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideCameraConfigRepository(
        @ApplicationContext context: Context
    ): CameraConfigRepository = CameraConfigRepositoryImpl(context)
}
