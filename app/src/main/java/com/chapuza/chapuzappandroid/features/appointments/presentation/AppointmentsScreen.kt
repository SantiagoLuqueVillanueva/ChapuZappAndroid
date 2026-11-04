package com.chapuza.chapuzappandroid.features.appointments.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chapuza.chapuzappandroid.core.ui.components.ChapuEmptyState
import com.chapuza.chapuzappandroid.core.ui.components.ChapuSegmentedControl
import com.chapuza.chapuzappandroid.core.ui.theme.ChapuZappAndroidTheme

@Composable
fun AppointmentsScreen(
    appointments: List<Appointment>,
    onAppointmentClick: (Appointment) -> Unit,
    onSearchClick: () -> Unit,
    modifier: Modifier = Modifier

) {
    var selectedTab by remember { mutableStateOf(0) }
    val shown = appointments.filter { it.isUpcoming == (selectedTab == 0) }
    Column(
        modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    )
    {
        Text("Mis citas", style = MaterialTheme.typography.headlineMedium)
        ChapuSegmentedControl(
            options = listOf("Próximas", "Historial"),
            selectedIndex = selectedTab,
            onSelect = { selectedTab = it })
        if (shown.isEmpty()){
            ChapuEmptyState(icon = Icons.Outlined.DateRange,
                    title = if (selectedTab == 0) "No tienes citas próximas" else "Aún no tienes historial",
                    message = "Cuando reserves con un profesional, verás tus citas aquí",
                    buttonText = "Buscar profesional",
                    onClick = onSearchClick,
                    modifier = Modifier.fillMaxWidth().padding(top = 48.dp))
        }else{
            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                item { Text(if (selectedTab == 0) "PRÓXIMA CITA" else "ANTERIORES", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.onSurfaceVariant) }
                items(shown) { appointment -> AppointmentCard(appointment = appointment, onClick = { onAppointmentClick(appointment) }) }
            }
        }
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppointmentsScreenPreview() {
    ChapuZappAndroidTheme {
        AppointmentsScreen(
            appointments = sampleAppointments,
            onAppointmentClick = {},
            onSearchClick = {},
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppointmentsScreenEmptyPreview() {
    ChapuZappAndroidTheme {
        AppointmentsScreen(
            appointments = emptyList(),
            onAppointmentClick = {},
            onSearchClick = {},
        )
    }
}