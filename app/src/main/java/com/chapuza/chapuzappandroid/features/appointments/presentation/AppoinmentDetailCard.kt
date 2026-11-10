package com.chapuza.chapuzappandroid.features.appointments.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Verified
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chapuza.chapuzappandroid.core.ui.theme.ChapuZappAndroidTheme

@Composable
private fun AppointmentDetailRow(
    icon: ImageVector,
    label: String,
    value: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 14.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(20.dp)
        )
        Spacer(Modifier.width(10.dp))
        Column {
            Text(
                label,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            Text(value, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
fun AppointmentDetailsCard(
    dateTime: String,
    address: String,
    service: String,
    duration: String,
    price: Int,
    professionalName: String,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        color = MaterialTheme.colorScheme.surfaceContainerLowest,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
    ) {
        Column(modifier = Modifier.padding(vertical = 4.dp)) {
            AppointmentDetailRow(
                icon = Icons.Outlined.CalendarMonth,
                label = "Fecha y hora", // TODO: pasar a strings.xml
                value = dateTime,
            )
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 14.dp),
                color = MaterialTheme.colorScheme.outlineVariant,
            )
            AppointmentDetailRow(
                icon = Icons.Outlined.LocationOn,
                label = "Dirección", // TODO: pasar a strings.xml
                value = address,
            )
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 14.dp),
                color = MaterialTheme.colorScheme.outlineVariant,
            )
            AppointmentDetailRow(
                icon = Icons.Outlined.Build,
                label = "Servicio", // TODO: pasar a strings.xml
                value = "$service · $duration", // TODO: pasar a strings.xml
            )
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 14.dp),
                color = MaterialTheme.colorScheme.outlineVariant,
            )
            AppointmentDetailRow(
                icon = Icons.Outlined.Verified,
                label = "Precio estimado", // TODO: pasar a strings.xml
                value = "Aprox. $price € · a acordar con ${professionalName.substringBefore(" ")}", // TODO: pasar a strings.xml
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AppointmentDetailRowPreview() {
    ChapuZappAndroidTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            AppointmentDetailRow(Icons.Outlined.CalendarMonth, "Fecha y hora", "Jue, 15 oct · 17:00")
            AppointmentDetailRow(Icons.Outlined.LocationOn, "Dirección", "Calle Alan Turing, 12 · 2.º B")
            AppointmentDetailRow(Icons.Outlined.Build, "Servicio", "Cambio de grifo · 45–60 min")
            AppointmentDetailRow(Icons.Outlined.Verified, "Precio estimado", "Aprox. 45 € · a acordar con Javier")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AppointmentDetailsCardPreview() {
    ChapuZappAndroidTheme {
        AppointmentDetailsCard(
            dateTime = "Jue, 15 oct · 17:00",
            address = "Calle Alan Turing, 12 · 2.º B",
            service = "Cambio de grifo",
            duration = "45–60 min",
            price = 45,
            professionalName = "Javier Moreno",
            modifier = Modifier.padding(16.dp),
        )
    }
}
