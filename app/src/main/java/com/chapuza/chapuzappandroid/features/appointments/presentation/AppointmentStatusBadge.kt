package com.chapuza.chapuzappandroid.features.appointments.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chapuza.chapuzappandroid.core.ui.components.ChapuBadge
import com.chapuza.chapuzappandroid.core.ui.theme.ChapuZappAndroidTheme

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

}@Preview(showBackground = true)
@Composable
fun AppointmentStatusBadgePreview() {
    ChapuZappAndroidTheme {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            AppointmentStatus.entries.forEach { status ->
                AppointmentStatusBadge(status = status)
            }
        }
    }
}