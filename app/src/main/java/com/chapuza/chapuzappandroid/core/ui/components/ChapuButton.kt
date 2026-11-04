package com.chapuza.chapuzappandroid.core.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chapuza.chapuzappandroid.core.ui.theme.ChapuZappAndroidTheme

enum class ChapuButtonVariant { Primary, Secondary, Text }

@Composable
fun ChapuButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    variant: ChapuButtonVariant = ChapuButtonVariant.Primary,
    enabled: Boolean = true,
    leadingIcon: (@Composable () -> Unit)? = null,
    containerColor: Color? = null,
    contentColor: Color? = null,
) {
    val buttonContent: @Composable () -> Unit = {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            if (leadingIcon != null) {
                leadingIcon()
            }
            Text(text)
        }
    }

    when (variant) {
        ChapuButtonVariant.Primary -> Button(
            onClick = onClick,
            modifier = modifier.height(48.dp),
            enabled = enabled,
            shape = MaterialTheme.shapes.medium,
            colors = if (containerColor != null || contentColor != null) {
                ButtonDefaults.buttonColors(
                    containerColor = containerColor ?: MaterialTheme.colorScheme.primary,
                    contentColor = contentColor ?: MaterialTheme.colorScheme.onPrimary,
                )
            } else {
                ButtonDefaults.buttonColors()
            },
        ) { buttonContent() }

        ChapuButtonVariant.Secondary -> OutlinedButton(
            onClick = onClick,
            modifier = modifier.height(48.dp),
            enabled = enabled,
            shape = MaterialTheme.shapes.medium,
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
            colors = if (containerColor != null || contentColor != null) {
                ButtonDefaults.outlinedButtonColors(
                    containerColor = containerColor ?: Color.Transparent,
                    contentColor = contentColor ?: MaterialTheme.colorScheme.primary,
                )
            } else {
                ButtonDefaults.outlinedButtonColors()
            },
        ) { buttonContent() }

        ChapuButtonVariant.Text -> TextButton(
            onClick = onClick,
            modifier = modifier.height(48.dp),
            enabled = enabled,
            shape = MaterialTheme.shapes.medium,
            colors = if (contentColor != null) {
                ButtonDefaults.textButtonColors(
                    contentColor = contentColor,
                )
            } else {
                ButtonDefaults.textButtonColors()
            },
        ) { buttonContent() }
    }
}

@Preview(showBackground = true)
@Composable
private fun ChapuButtonPreview() {
    ChapuZappAndroidTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            ChapuButton(text = "Reservar", onClick = {})
            ChapuButton(variant = ChapuButtonVariant.Secondary, text = "Ver perfil", onClick = {})
            ChapuButton(variant = ChapuButtonVariant.Text, text = "Cancelar", onClick = {})
        }
    }
}
