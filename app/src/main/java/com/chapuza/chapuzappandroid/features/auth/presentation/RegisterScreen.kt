package com.chapuza.chapuzappandroid.features.auth.presentation

import android.util.Patterns
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chapuza.chapuzappandroid.core.ui.components.ChapuButton
import com.chapuza.chapuzappandroid.core.ui.components.ChapuButtonVariant
import com.chapuza.chapuzappandroid.core.ui.components.ChapuTextField
import com.chapuza.chapuzappandroid.core.ui.components.ChapuTopBar
import com.chapuza.chapuzappandroid.core.ui.theme.ChapuZappAndroidTheme

@Composable
fun RegisterScreen(
    onRegisterClick: () -> Unit,
    onLoginClick: () -> Unit,
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var submitted by remember { mutableStateOf(false) }
    val nameError: String? = if (submitted && name.isBlank()) "Introduce tu nombre" else null
    val emailError: String? =
        if (submitted && !Patterns.EMAIL_ADDRESS.matcher(email).matches()) "Introduce un correo válido" else null
    val passwordError: String? = if (submitted && password.length < 8) "Mínimo 8 caracteres" else null
    val confirmError: String? = if (submitted && confirmPassword != password) "Las contraseñas no coinciden" else null

    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        ChapuTopBar(title = "Crear cuenta", onBack = onLoginClick)

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ChapuTextField(
                value = name,
                onValueChange = { name = it },
                label = "Nombre y apellidos",
                leadingIcon = Icons.Outlined.Person,
                errorMessage = nameError
            )
            ChapuTextField(
                value = email,
                onValueChange = { email = it },
                label = "Correo electrónico",
                leadingIcon = Icons.Outlined.Email,
                errorMessage = emailError
            )
            ChapuTextField(
                value = password,
                onValueChange = { password = it },
                label = "Contraseña (mín. 8 caracteres)",
                leadingIcon = Icons.Outlined.Lock,
                visualTransformation = PasswordVisualTransformation(),
                errorMessage = passwordError
            )
            ChapuTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = "Repetir contraseña",
                leadingIcon = Icons.Outlined.Lock,
                visualTransformation = PasswordVisualTransformation(),
                errorMessage = confirmError
            )
            ChapuTextField(
                value = address,
                onValueChange = { address = it },
                label = "Dirección",
                leadingIcon = Icons.Outlined.Place,
            )

        }
        ChapuButton(
            text = "Crear cuenta",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            onClick = {
                submitted = true
                val nameOk = (name.isNotBlank())
                val emailOk = Patterns.EMAIL_ADDRESS.matcher(email).matches()
                val passwordOk = password.length >= 8
                val confirmPasswordOk = (password == confirmPassword)
                if (nameOk && emailOk && passwordOk && confirmPasswordOk) {
                    onRegisterClick()
                }
            })
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Text("¿Ya tienes cuenta?", color = MaterialTheme.colorScheme.onSurfaceVariant)
            ChapuButton(text = "Inicia sesión", onClick = onLoginClick, variant = ChapuButtonVariant.Text)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun RegisterScreenPreview() {
    ChapuZappAndroidTheme {
        RegisterScreen(onRegisterClick = {}, onLoginClick = {})
    }
}