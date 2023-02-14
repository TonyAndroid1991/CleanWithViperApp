package com.example.usecases

import com.example.models.PlayerByPersonaName
import com.example.repositories.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetUserByPersonaNameUseCase(private val repository: Repository) :
    FlowUseCase<String, List<PlayerByPersonaName>>() {

    override fun prepareFlow(input: String): Flow<List<PlayerByPersonaName>> = flow {
        emit(repository.fetchUserByPersonaName(input))
    }
}