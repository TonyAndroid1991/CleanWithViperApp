package com.example.dota2stats.viewmodel

import com.example.usecases.Failure

sealed class Event {
    object SearchPlayerByName: Event()
    object SearchPlayerByID : Event()
//    class Error<T>() : Event<T>()
}