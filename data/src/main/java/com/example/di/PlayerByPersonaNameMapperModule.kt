package com.example.di

import com.example.mappers.PlayerByPersonaNameMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PlayerByPersonaNameMapperModule {

    @Singleton
    @Provides
    fun providesPlayerByPersonaNameMapper(): PlayerByPersonaNameMapper {
        return PlayerByPersonaNameMapper()
    }
}