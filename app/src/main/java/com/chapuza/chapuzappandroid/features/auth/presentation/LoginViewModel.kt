package com.chapuza.chapuzappandroid.features.auth.presentation

import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chapuza.chapuzappandroid.features.auth.data.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val emailError: String? = null,
    val passwordError: String? = null,
    val loading: Boolean = false,
    val error: String? = null,
    val success: Boolean = false,
)

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: AuthRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun onEmailChange(value: String) {
        _uiState.update { it.copy(email = value, emailError = null, error = null) }
    }

    fun onPasswordChange(value: String) {
        _uiState.update { it.copy(password = value, passwordError = null, error = null) }
    }

    fun login() {
        val state = _uiState.value
        if (state.loading) return

        val email = state.email.trim()
        val emailError = if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) null else "Introduce un correo válido"
        val passwordError = if (state.password.isBlank()) "Introduce tu contraseña" else null
        if (emailError != null || passwordError != null) {
            _uiState.update { it.copy(emailError = emailError, passwordError = passwordError) }
            return
        }

        _uiState.update { it.copy(loading = true, error = null) }
        viewModelScope.launch {
            repository.login(email, state.password)
                .onSuccess { _uiState.update { it.copy(loading = false, success = true) } }
                .onFailure { e -> _uiState.update { it.copy(loading = false, error = authErrorMessage(e)) } }
        }
    }
}