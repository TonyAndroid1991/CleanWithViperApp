package com.example.dota2stats.di

import com.example.dota2stats.viewmodel.HomeViewModelFactory
import com.example.usecases.GetUserByPersonaNameUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Singleton
    @Provides
    fun providesHomeViewModelFactory(
        getUserByPersonaNameUseCase: GetUserByPersonaNameUseCase): HomeViewModelFactory {
        return HomeViewModelFactory(getUserByPersonaNameUseCase)
    }
}