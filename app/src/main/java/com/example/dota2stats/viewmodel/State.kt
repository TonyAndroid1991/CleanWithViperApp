package com.example.dota2stats.viewmodel

sealed class State {

    object Success : State()
    object Loading : State()

    object Idle : State()

}