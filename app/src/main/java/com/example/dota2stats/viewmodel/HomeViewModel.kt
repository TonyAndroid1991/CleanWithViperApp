package com.example.dota2stats.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.models.PlayerByPersonaName
import com.example.usecases.GetUserByPersonaNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getUserByPersonaNameUseCase: GetUserByPersonaNameUseCase): ViewModel () {

    private var _listOfPlayersLiveData = MutableLiveData<List<PlayerByPersonaName>>()
    val listOfPlayersLiveData = _listOfPlayersLiveData

    fun getUserByPersonaName(name: String) = viewModelScope.launch {
         _listOfPlayersLiveData.postValue(getUserByPersonaNameUseCase.getUserByPersonaName(name))
//        getUserByPersonaNameUseCase.prepareFlow(name).collect {
//        }
    }
}