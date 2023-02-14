package com.example.repo

import com.example.models.PlayerByPersonaNameItem
import retrofit2.Response

interface RemoteDataSource {

    suspend fun getPlayerByPersonaName(name: String): Response<List<PlayerByPersonaNameItem>>
}