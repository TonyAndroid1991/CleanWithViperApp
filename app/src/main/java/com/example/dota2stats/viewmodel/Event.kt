package com.example.dota2stats.viewmodel

import com.example.models.PlayerByPersonaName
import com.example.usecases.Failure

sealed class Event {
    object SearchPlayerByName: Event()
    object SearchPlayerByID : Event()

    data class Success(val result: List<PlayerByPersonaName>): Event()
    object Loading: Event()
    data class Error(val message: String) : Event()
}