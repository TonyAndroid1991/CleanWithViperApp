package com.example.apiservice

import com.example.data.BuildConfig
import com.example.models.PlayerByPersonaNameItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search")
    suspend fun getPlayerByPersonaName(
        @Query("q") q: String,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Response<List<PlayerByPersonaNameItem>>
}