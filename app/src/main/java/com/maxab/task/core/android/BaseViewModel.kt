package com.maxab.task.core.android

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<STATE : UiState>(initState: STATE) : ViewModel() {

    private val _uiState = MutableStateFlow(initState)
    val uiState: StateFlow<STATE> = _uiState.asStateFlow()


}