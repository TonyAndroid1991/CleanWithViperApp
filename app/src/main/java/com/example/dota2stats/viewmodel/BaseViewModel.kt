package com.example.dota2stats.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    private val _state = MutableStateFlow<State>(State.Idle)
    val state = _state.asStateFlow()

    private val _action: MutableSharedFlow<Action> = MutableSharedFlow()
    val action = _action.asSharedFlow()

    private val _events = MutableSharedFlow<Event>()
    val events = _events.asSharedFlow()

    init {
        subscribeActions()
    }

    private fun subscribeActions() = viewModelScope.launch {
        action.collect { action ->
            handleAction(action)
                .onStart {
                    if (action !is BackgroundAction) {
                        _state.value = State.Loading(action)
                    }
                }
                .onEach { _state.value = it }
//                .catchError {
//                    setEvents { Event.Error(it) }
//                    _state.value = State.Idle
//                }
                .launchIn(viewModelScope)
        }
    }

    protected fun loadingState() {
        _state.value = State.Loading(null)
    }

    fun setNavigationEvent(event: NavigationEvent) {
        setEvents { event }
        _state.value = State.Idle
    }

    fun resetState() {
        _state.value = State.Idle
    }

    fun setAction(action: Action) {
        val newAction = action
        viewModelScope.launch { _action.emit(newAction) }
    }

    protected fun setEvents(builder: () -> Event) {
        val eventValue = builder()
        viewModelScope.launch { _events.emit(eventValue) }
    }

    fun updateState(state: State) {
        _state.value = state
    }

    abstract fun handleAction(action: Action): Flow<State>

}

interface Action

interface BackgroundAction : Action