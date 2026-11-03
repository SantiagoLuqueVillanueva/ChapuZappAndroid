package com.chapuza.chapuzappandroid.features.home.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(sampleHomeState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()
}