package com.chapuza.chapuzappandroid.features.messages.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chapuza.chapuzappandroid.core.ui.components.ChapuEmptyState
import com.chapuza.chapuzappandroid.core.ui.components.ChapuTextField

@Composable
fun MessagesScreen() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(
            text = "Mensajes",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier=Modifier.height(16.dp))
        ChapuTextField(
            value = "",
            onValueChange = {},
            label = "Buscar una conversación",
            leadingIcon = Icons.Outlined.Search
        )
        Box(
            modifier = Modifier.fillMaxWidth().weight(1f),
            contentAlignment = Alignment.Center
        ) {
            ChapuEmptyState(
                icon = Icons.Outlined.Email,
                title = "Todavía no hay mensajes",
                message = "Cuando hables con un profesional, verás aquí la conversación",
                buttonText = "Buscar profesionales",
                onClick = {}
            )
        }
    }
}