package com.example.repo

import com.example.apiservice.ApiService
import com.example.models.PlayerByPersonaNameItem
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor (private val apiService: ApiService) : RemoteDataSource {

    override suspend fun getPlayerByPersonaName(name: String): Response<List<PlayerByPersonaNameItem>> {
        return apiService.getPlayerByPersonaName(name)
    }
}