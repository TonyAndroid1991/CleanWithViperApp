package com.example.dota2stats.viewmodel

import com.example.usecases.Failure

sealed class Event<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : Event<T>(data)
    class Loading<T>(data: T? = null) : Event<T>(data)
  //  class Error<T>() : Event<T>()
}