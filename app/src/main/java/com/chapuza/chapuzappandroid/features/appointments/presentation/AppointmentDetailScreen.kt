package com.chapuza.chapuzappandroid.features.appointments.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chapuza.chapuzappandroid.core.ui.components.ChapuButton
import com.chapuza.chapuzappandroid.core.ui.components.ChapuButtonVariant
import com.chapuza.chapuzappandroid.core.ui.components.ChapuTopBar
import com.chapuza.chapuzappandroid.core.ui.theme.ChapuZappAndroidTheme

@Composable
fun AppointmentDetailScreen(
    appointment: Appointment,
    address: String,
    duration: String,
    role: String,
    rating: String,
    onBack: () -> Unit,
    onCall: () -> Unit,
    onChat: () -> Unit,
    onReschedule: () -> Unit,
    onCancel: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        ChapuTopBar(title = "Detalle de cita", // TODO: pasar a strings.xml
                    onBack = onBack)

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            AppointmentStatusBadge(status = appointment.status)

            AppointmentProfessionalCard(
                name = appointment.professionalName,
                role = role,
                rating = rating,
                onCallClick = onCall,
            )

            AppointmentDetailsCard(
                dateTime = appointment.date,
                address = address,
                service = appointment.service,
                duration = duration,
                price = appointment.price,
                professionalName = appointment.professionalName,
            )

            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                ChapuButton(
                    text = "Chatear", // TODO: pasar a strings.xml
                    onClick = onChat,
                    modifier = Modifier.weight(1f),
                )
                ChapuButton(
                    text = "Reprogramar", // TODO: pasar a strings.xml
                    onClick = onReschedule,
                    modifier = Modifier.weight(1f),
                    variant = ChapuButtonVariant.Secondary,
                )
            }

            Text(
                "Cancelar cita", // TODO: pasar a strings.xml
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = onCancel)
                    .padding(vertical = 8.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 780)
@Composable
private fun AppointmentDetailScreenPreview() {
    ChapuZappAndroidTheme {
        AppointmentDetailScreen(
            appointment = sampleAppointments[0],
            address = "Calle Alan Turing, 12 · 2.º B",
            duration = "45–60 min",
            role = "Fontanero",
            rating = "4,9",
            onBack = {},
            onCall = {},
            onChat = {},
            onReschedule = {},
            onCancel = {},
        )
    }
}
