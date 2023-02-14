package com.example.di

import com.example.repositories.Repository
import com.example.usecases.GetUserByPersonaNameUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {

    @Singleton
    @Provides
    fun providesGetUserByPersonaNameUseCase(repository: Repository): GetUserByPersonaNameUseCase {
        return GetUserByPersonaNameUseCase(repository)
    }
}