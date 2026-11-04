package com.chapuza.chapuzappandroid.features.appointments.presentation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.chapuza.chapuzappandroid.core.ui.components.ChapuBadge

@Composable
fun AppointmentStatusBadge(status: AppointmentStatus, modifier: Modifier = Modifier) {
    val (label, containerColor, contentColor) = when (status) {
        AppointmentStatus.Pending -> Triple(
            "Pendiente",
            MaterialTheme.colorScheme.surfaceVariant,
            MaterialTheme.colorScheme.onSurfaceVariant
        )

        AppointmentStatus.Confirmed -> Triple(
            "Confirmada",
            MaterialTheme.colorScheme.primaryContainer,
            MaterialTheme.colorScheme.onPrimaryContainer
        )

        AppointmentStatus.Cancelled -> Triple(
            "Cancelada",
            MaterialTheme.colorScheme.tertiaryContainer,
            MaterialTheme.colorScheme.onTertiaryContainer
        )

        AppointmentStatus.Completed -> Triple(
            "Completada",
            MaterialTheme.colorScheme.errorContainer,
            MaterialTheme.colorScheme.onErrorContainer
        )
    }
    ChapuBadge(text = label, containerColor = containerColor, contentColor = contentColor, modifier = modifier)

}