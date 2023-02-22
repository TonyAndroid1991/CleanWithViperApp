package com.example.repo

import com.example.mappers.PlayerByPersonaNameMapper
import com.example.models.PlayerByPersonaName
import com.example.repositories.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor (
    private val remoteDataSource: RemoteDataSource,
    private val playerByPersonaNameMapper: PlayerByPersonaNameMapper
) : Repository {

    override suspend fun fetchUserByPersonaName(name: String): List<PlayerByPersonaName> {
        return getPlayerFromApi(name)
    }

    private suspend fun getPlayerFromApi(name: String): List<PlayerByPersonaName> {
        val response = remoteDataSource.getPlayerByPersonaName(name)
        if (response.isSuccessful) {
            response.body()?.let {
                return playerByPersonaNameMapper.toPlayerByPersonaName(it)
            }
        }
        return listOf()
    }
}