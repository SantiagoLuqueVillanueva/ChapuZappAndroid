package com.chapuza.chapuzappandroid.features.profile.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chapuza.chapuzappandroid.R
import com.chapuza.chapuzappandroid.core.ui.components.ChapuAvatar
import com.chapuza.chapuzappandroid.core.ui.components.ChapuListItem
import com.chapuza.chapuzappandroid.core.ui.components.ChapuStatCard
import com.chapuza.chapuzappandroid.core.ui.theme.ChapuZappAndroidTheme

@Composable
fun ProfileScreen() {
    val name = "Adrián Gutiérrez"
    val email = "guti@correo.com"
    val initials = "AG"
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(
                rememberScrollState()
            )
            .padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Perfil", style = MaterialTheme.typography.headlineMedium)
        Surface(
            color = MaterialTheme.colorScheme.primaryContainer,
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                ChapuAvatar(
                    name = "Adrián Gutiérrez",
                    size = 56.dp,
                    containerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
                )
                Spacer(Modifier.width(12.dp))
                Column(Modifier.weight(1f)) {
                    Text(name, style = MaterialTheme.typography.titleLarge)
                    Text(
                        email,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                Surface(
                    shape = CircleShape,
                    color = MaterialTheme.colorScheme.surfaceContainerLowest
                ) {
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.Outlined.Edit,
                            contentDescription = "Editar perfil"
                        )
                    }
                }
            }

        }
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            ChapuStatCard("12", "Citas", Modifier.weight(1f))
            ChapuStatCard("5", "Favoritos", Modifier.weight(1f))
            ChapuStatCard("8", "Reseñas", Modifier.weight(1f))
        }
        Text("Tu cuenta", style = MaterialTheme.typography.titleMedium)
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.surfaceContainerLowest,
            shape = MaterialTheme.shapes.medium,
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        ) {
            Column {
                ChapuListItem(
                    icon = painterResource(R.drawable.ic_tune),
                    title = "Ajustes",
                    onClick = {},
                )
                HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
                ChapuListItem(
                    icon = rememberVectorPainter(Icons.Outlined.Place),
                    title = "Direcciones",
                    trailingText = "2 guardadas",
                    onClick = {},
                )
                HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
                ChapuListItem(
                    icon = rememberVectorPainter(Icons.Outlined.Notifications),
                    title = "Notificaciones",
                    onClick = {},
                )
                HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
                ChapuListItem(
                    icon = painterResource(R.drawable.ic_help),
                    title = "Ayuda",
                    onClick = {},
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ProfileScreenPreview() {
    ChapuZappAndroidTheme {
        ProfileScreen()
    }
}