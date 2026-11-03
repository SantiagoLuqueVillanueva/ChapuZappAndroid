package com.chapuza.chapuzappandroid.features.auth.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chapuza.chapuzappandroid.R
import com.chapuza.chapuzappandroid.core.ui.components.ChapuButton
import com.chapuza.chapuzappandroid.core.ui.components.ChapuButtonVariant
import com.chapuza.chapuzappandroid.core.ui.components.ChapuTextField
import com.chapuza.chapuzappandroid.core.ui.theme.ChapuZappAndroidTheme
import android.util.Patterns

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var submitted by remember {mutableStateOf(false)}
    val emailError: String? = if (submitted && !Patterns.EMAIL_ADDRESS.matcher(email).matches())"Introduce un correo válido" else null
    val passwordError: String? = if (submitted && password.isBlank())"Introduce tu contraseña" else null

    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 24.dp),
        ) {
            Image(
                painter = painterResource(R.drawable.logo_login_horizontal),
                contentDescription = "ChapuZapp",
                modifier = Modifier
                    .height(44.dp)
                    .align(Alignment.CenterHorizontally),
            )
            Spacer(
                Modifier.height(24.dp)
            )
            Text("Inicia sesión", style = MaterialTheme.typography.headlineSmall)
            Spacer(Modifier.height(4.dp))
            Text(
                "Accede para reservar profesionales cerca de ti",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(24.dp))
            ChapuTextField(
                value = email,
                onValueChange = { email = it },
                label = "Correo electrónico",
                leadingIcon = Icons.Outlined.Email,
                errorMessage=emailError
            )
            Spacer(
                Modifier.height(12.dp)
            )
            ChapuTextField(
                value = password,
                onValueChange = { password = it },
                label = "Contraseña",
                leadingIcon = Icons.Outlined.Lock,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                errorMessage=passwordError,
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisible = !passwordVisible
                    }) {
                        Icon(
                            painter = painterResource(if (passwordVisible) R.drawable.ic_visibility_off else R.drawable.ic_visibility),
                            contentDescription = "Mostrar contraseña"
                        )
                    }
                },
            )
            ChapuButton(
                "He olvidado mi contraseña",
                variant = ChapuButtonVariant.Text,
                modifier = Modifier.align(Alignment.End),
                onClick = {})
            Spacer(Modifier.height(8.dp))
            ChapuButton(text = "Entrar",
                onClick = {
                    submitted = true
                    val emailOk = Patterns.EMAIL_ADDRESS.matcher(email).matches()
                    val passwordOk = password.isNotBlank()
                    if (emailOk && passwordOk) {
                        onLoginClick()
                    }
                },
                modifier = Modifier.fillMaxWidth(),)
            Spacer(Modifier.weight(1f))
            Row(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Text(
                    "¿No tienes cuenta?",
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                ChapuButton("Regístrate", variant = ChapuButtonVariant.Text, onClick = onRegisterClick)
            }

        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun LoginScreenPreview() {
    ChapuZappAndroidTheme {
        LoginScreen(onLoginClick = {}, onRegisterClick = {})
    }
}
