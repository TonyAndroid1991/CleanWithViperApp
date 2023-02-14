package com.example.repositories

import com.example.models.PlayerByPersonaName

interface Repository {
    suspend fun fetchUserByPersonaName(name: String): List<PlayerByPersonaName>
}