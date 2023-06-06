package com.example.dota2stats.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dota2stats.viewmodel.Event.*
import com.example.models.PlayerByPersonaName
import com.example.usecases.GetUserByPersonaNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getUserByPersonaNameUseCase: GetUserByPersonaNameUseCase) :
    ViewModel() {

    private var _listOfPlayersLiveData = MutableLiveData<List<PlayerByPersonaName>>()
    val listOfPlayersLiveData = _listOfPlayersLiveData

    private var _state = MutableStateFlow<State>(State.Idle)
    val state = _state.asStateFlow()

    private var _event = Channel<Event>()
    val event = _event.receiveAsFlow()
    fun getUserByPersonaName(name: String, event: Event) = viewModelScope.launch {

        when (event) {
            is SearchPlayerByName -> {

            }

            is SearchPlayerByID -> {

            }
        }
//
//        _state.emit(Event.Loading())
//        _state.emit(Event.Success(getUserByPersonaNameUseCase.getUserByPersonaName(name)))

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