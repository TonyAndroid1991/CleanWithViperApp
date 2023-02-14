package com.example.di

import com.example.apiservice.ApiService
import com.example.repo.RemoteDataSource
import com.example.repo.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataSourceModule {

    @Singleton
    @Provides
    fun providesRemoteDataSource(apiService: ApiService): RemoteDataSource {
        return RemoteDataSourceImpl(apiService)
    }
}