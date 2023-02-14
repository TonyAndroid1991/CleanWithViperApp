package com.example.di

import com.example.mappers.PlayerByPersonaNameMapper
import com.example.repo.RemoteDataSource
import com.example.repo.RepositoryImpl
import com.example.repositories.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        remoteDataSource: RemoteDataSource,
        playerByPersonaNameMapper: PlayerByPersonaNameMapper
    ): Repository {
        return RepositoryImpl(remoteDataSource, playerByPersonaNameMapper)
    }
}