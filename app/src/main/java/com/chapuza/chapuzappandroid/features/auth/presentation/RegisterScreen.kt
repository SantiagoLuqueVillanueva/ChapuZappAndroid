package com.chapuza.chapuzappandroid.features.auth.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.chapuza.chapuzappandroid.core.ui.components.ChapuButton
import com.chapuza.chapuzappandroid.core.ui.components.ChapuButtonVariant
import com.chapuza.chapuzappandroid.core.ui.components.ChapuTextField
import com.chapuza.chapuzappandroid.core.ui.components.ChapuTopBar

@Composable
fun RegisterScreen(
    onRegisterSuccess: () -> Unit,
    onLoginClick: () -> Unit,
    viewModel: RegisterViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(uiState.success) {
        if (uiState.success) onRegisterSuccess()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
    ) {
        ChapuTopBar(title = "Crear cuenta", onBack = onLoginClick)

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            ChapuTextField(
                value = uiState.nombre,
                onValueChange = viewModel::onNombreChange,
                label = "Nombre y apellidos",
                leadingIcon = Icons.Outlined.Person,
                errorMessage = uiState.nombreError,
            )
            ChapuTextField(
                value = uiState.email,
                onValueChange = viewModel::onEmailChange,
                label = "Correo electrónico",
                leadingIcon = Icons.Outlined.Email,
                errorMessage = uiState.emailError,
            )
            ChapuTextField(
                value = uiState.password,
                onValueChange = viewModel::onPasswordChange,
                label = "Contraseña (mín. 8 caracteres)",
                leadingIcon = Icons.Outlined.Lock,
                visualTransformation = PasswordVisualTransformation(),
                errorMessage = uiState.passwordError,
            )
            ChapuTextField(
                value = uiState.confirmPassword,
                onValueChange = viewModel::onConfirmChange,
                label = "Repetir contraseña",
                leadingIcon = Icons.Outlined.Lock,
                visualTransformation = PasswordVisualTransformation(),
                errorMessage = uiState.confirmError,
            )
            ChapuTextField(
                value = uiState.direccion,
                onValueChange = viewModel::onDireccionChange,
                label = "Dirección",
                leadingIcon = Icons.Outlined.Place,
            )
            uiState.error?.let {
                Text(it, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodyMedium)
            }
            if (uiState.loading) {
                CircularProgressIndicator(Modifier.align(Alignment.CenterHorizontally))
            }
        }
        ChapuButton(
            text = if (uiState.loading) "Creando cuenta…" else "Crear cuenta",
            onClick = viewModel::register,
            enabled = !uiState.loading,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        )
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text("¿Ya tienes cuenta?", color = MaterialTheme.colorScheme.onSurfaceVariant)
            ChapuButton(text = "Inicia sesión", onClick = onLoginClick, variant = ChapuButtonVariant.Text)
        }
    }
}