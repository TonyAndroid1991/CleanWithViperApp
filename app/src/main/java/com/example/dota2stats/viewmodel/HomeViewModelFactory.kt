package com.example.dota2stats.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.usecases.GetUserByPersonaNameUseCase
import javax.inject.Inject

class HomeViewModelFactory @Inject constructor(private val getUserByPersonaNameUseCase: GetUserByPersonaNameUseCase) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(getUserByPersonaNameUseCase) as T
    }
}