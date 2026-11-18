package com.chapuza.chapuzappandroid.features.auth.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chapuza.chapuzappandroid.features.auth.data.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class LoginUiState(val loading: Boolean = false, val error: String? = null, val success: Boolean = false)

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: AuthRepository) : ViewModel(){
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()
    fun login(email: String, password: String){
        _uiState.value = LoginUiState(loading = true)
        viewModelScope.launch {
            val result = repository.login(email, password)
            result.onSuccess { _uiState.value = LoginUiState(success = true) }
            result.onFailure { _uiState.value = LoginUiState(error = "Email o contraseña incorrectos") }
        }
    }
}

