package com.example.dota2stats.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.models.PlayerByPersonaName
import com.example.usecases.GetUserByPersonaNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getUserByPersonaNameUseCase: GetUserByPersonaNameUseCase) :
    ViewModel() {

    private var _listOfPlayersLiveData = MutableLiveData<List<PlayerByPersonaName>>()
    val listOfPlayersLiveData = _listOfPlayersLiveData

    private var _event = MutableStateFlow<Event<List<PlayerByPersonaName>>>(Event.Loading())
    val event = _event.asStateFlow()

    fun getUserByPersonaName(name: String) = viewModelScope.launch {

        _event.emit(Event.Loading())
        _event.emit(Event.Success(getUserByPersonaNameUseCase.getUserByPersonaName(name)))

//        getUserByPersonaNameUseCase.prepareFlow(name).onEach {
//            _event.send(it)
//        }.catch {
//            Log.e("ViewModelError", "getUserByPersonaName: =============")
//        }

        /**Con LiveData*/
//         _listOfPlayersLiveData.postValue(getUserByPersonaNameUseCase.getUserByPersonaName(name))
//        getUserByPersonaNameUseCase.prepareFlow(name).collect {
//        }
    }
}