package com.example.dota2stats.viewmodel

import com.example.usecases.Failure

sealed class Event {

    class Error(val failure: Failure) : Event()
    class ShowToast(val message: String) : Event()
}

sealed class NavigationEvent: Event() {
    object OnBackClicked: NavigationEvent()
    object OnMenuClicked: NavigationEvent()
    object CloseClicked: NavigationEvent()
}