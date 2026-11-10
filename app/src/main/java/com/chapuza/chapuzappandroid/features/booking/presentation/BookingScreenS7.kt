 package com.chapuza.chapuzappandroid.features.booking.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chapuza.chapuzappandroid.core.ui.components.ChapuButton
import com.chapuza.chapuzappandroid.core.ui.components.ChapuSuccessHalo
import com.chapuza.chapuzappandroid.core.ui.theme.ChapuZappAndroidTheme

@Composable
fun BookingConfirmationScreen(
    professionalName: String,
    service: String,
    price: Int,
    dateTime: String,
    address: String,
    onViewAppointments: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(top = 48.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(14.dp),
        ) {
            ChapuSuccessHalo()
            Text(
                "¡Cita confirmada!", // TODO: pasar a strings.xml
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center,
            )
            Text(
                "${professionalName.substringBefore(" ")} recibirá tu reserva ahora mismo.", // TODO: pasar a strings.xml
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
            )
            BookingConfirmationSummary(
                professionalName = professionalName,
                service = service,
                price = price,
                dateTime = dateTime,
                address = address,
            )
        }
        ChapuButton(
            text = "Ver mis citas", // TODO: pasar a strings.xml
            onClick = onViewAppointments,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 780)
@Composable
fun BookingConfirmationScreenPreview() {
    ChapuZappAndroidTheme {
        BookingConfirmationScreen(
            professionalName = "Javier Moreno",
            service = "Cambio de grifo",
            price = 45,
            dateTime = "Jue, 15 oct · 17:00",
            address = "Calle Alan Turing, 12 · 2.º B",
            onViewAppointments = {},
        )
    }
}