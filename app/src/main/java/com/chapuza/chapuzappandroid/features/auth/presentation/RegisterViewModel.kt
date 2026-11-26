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

data class RegisterUiState(
    val nombre: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val direccion: String = "",
    val nombreError: String? = null,
    val emailError: String? = null,
    val passwordError: String? = null,
    val confirmError: String? = null,
    val loading: Boolean = false,
    val error: String? = null,
    val success: Boolean = false,
)

@HiltViewModel
class RegisterViewModel @Inject constructor(private val repository: AuthRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> = _uiState.asStateFlow()

    fun onNombreChange(value: String) = _uiState.update { it.copy(nombre = value, nombreError = null, error = null) }
    fun onEmailChange(value: String) = _uiState.update { it.copy(email = value, emailError = null, error = null) }
    fun onPasswordChange(value: String) = _uiState.update { it.copy(password = value, passwordError = null, error = null) }
    fun onConfirmChange(value: String) = _uiState.update { it.copy(confirmPassword = value, confirmError = null, error = null) }
    fun onDireccionChange(value: String) = _uiState.update { it.copy(direccion = value) }

    fun register() {
        val state = _uiState.value
        if (state.loading) return

        val nombre = state.nombre.trim()
        val email = state.email.trim()
        val nombreError = if (nombre.length < 2) "Introduce tu nombre" else null
        val emailError = if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) null else "Introduce un correo válido"
        val passwordError = if (state.password.length < 8) "Mínimo 8 caracteres" else null
        val confirmError = if (state.confirmPassword != state.password) "Las contraseñas no coinciden" else null
        if (listOf(nombreError, emailError, passwordError, confirmError).any { it != null }) {
            _uiState.update {
                it.copy(
                    nombreError = nombreError,
                    emailError = emailError,
                    passwordError = passwordError,
                    confirmError = confirmError,
                )
            }
            return
        }

        _uiState.update { it.copy(loading = true, error = null) }
        viewModelScope.launch {
            val fallo = repository.register(nombre, email, state.password).exceptionOrNull()
            if (fallo != null) {
                _uiState.update { it.copy(loading = false, error = authErrorMessage(fallo)) }
                return@launch
            }
            repository.login(email, state.password)
                .onSuccess { _uiState.update { it.copy(loading = false, success = true) } }
                .onFailure { e -> _uiState.update { it.copy(loading = false, error = authErrorMessage(e)) } }
        }
    }
}