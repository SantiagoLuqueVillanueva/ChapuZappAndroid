package com.chapuza.chapuzappandroid.core.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
) {
    when (variant) {
        ChapuButtonVariant.Primary -> Button(
            onClick = onClick,
            modifier = modifier.height(48.dp),
            enabled = enabled,
            shape = MaterialTheme.shapes.medium
        ) { Text(text) }

        ChapuButtonVariant.Secondary -> OutlinedButton(
            onClick = onClick,
            modifier = modifier.height(48.dp),
            enabled = enabled,
            shape = MaterialTheme.shapes.medium,
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
        ) { Text(text) }

        ChapuButtonVariant.Text -> TextButton(
            onClick = onClick,
            modifier = modifier.height(48.dp),
            enabled = enabled,
            shape = MaterialTheme.shapes.medium
        ) { Text(text) }
    }
}

@Preview(showBackground = true)
@Composable
private fun ChapuButtonPreview() {
    ChapuZappAndroidTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ChapuButton(text = "Reservar", onClick = {})
            ChapuButton(variant = ChapuButtonVariant.Secondary, text = "Ver perfil", onClick = {})
            ChapuButton(variant = ChapuButtonVariant.Text, text = "Cancelar", onClick = {})
        }
    }
}