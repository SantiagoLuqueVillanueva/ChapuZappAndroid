package com.chapuza.chapuzappandroid.core.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chapuza.chapuzappandroid.R
import com.chapuza.chapuzappandroid.core.ui.theme.ChapuZappAndroidTheme

@Composable
fun ChapuTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    leadingIcon: ImageVector? = null,
    errorMessage: String? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        label = { Text(label) },
        singleLine = true,
        shape = CircleShape,
        isError = errorMessage != null,
        supportingText = errorMessage?.let { { Text(it) } },
        // Icono decorativo al inicio; si es null no se pinta
        leadingIcon = leadingIcon?.let { { Icon(it, contentDescription = null) } },
        // Hueco libre al final: la pantalla decide qué va (p. ej. un IconButton)
        trailingIcon = trailingIcon,
        visualTransformation = visualTransformation,
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
            unfocusedContainerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
            unfocusedBorderColor = MaterialTheme.colorScheme.outlineVariant,
            focusedBorderColor = MaterialTheme.colorScheme.outline,
        ),
    )
}

@Preview(showBackground = true)
@Composable
private fun ChapuTextFieldPreview() {
    ChapuZappAndroidTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            ChapuTextField(value = "", onValueChange = {}, label = "Correo", leadingIcon = Icons.Outlined.Email)
            ChapuTextField(
                value = "",
                onValueChange = {},
                label = "Correo",
                leadingIcon = Icons.Outlined.Email,
                errorMessage = "Correo no válido"
            )
            ChapuTextField(
                value = "secreto",
                onValueChange = {},
                label = "Contraseña",
                leadingIcon = Icons.Outlined.Lock,
                visualTransformation = PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = {}) {
                        Icon(painterResource(R.drawable.ic_visibility), contentDescription = null)
                    }
                },
            )
        }
    }
}