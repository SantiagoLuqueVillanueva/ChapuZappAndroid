package com.chapuza.chapuzappandroid.features.booking.presentation

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
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.LocationOn
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
import com.chapuza.chapuzappandroid.core.ui.components.ChapuAvatar
import com.chapuza.chapuzappandroid.core.ui.theme.ChapuZappAndroidTheme

@Composable
private fun SummaryRow(
    icon: ImageVector,
    text: String,
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(20.dp)
        )
        Spacer(Modifier.width(10.dp))
        Text(text, style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun BookingConfirmationSummary(
    professionalName: String,
    service: String,
    price: Int,
    dateTime: String,
    address: String,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        color = MaterialTheme.colorScheme.surfaceContainerLowest,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                ChapuAvatar(name = professionalName)
                Spacer(Modifier.width(12.dp))
                Column {
                    Text(professionalName, style = MaterialTheme.typography.titleSmall)
                    Text(
                        "$service · $price €", // TODO: pasar a strings.xml
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
            }

            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

            SummaryRow(Icons.Outlined.CalendarMonth, dateTime)
            SummaryRow(Icons.Outlined.LocationOn, address)
            SummaryRow(
                Icons.Outlined.ChatBubbleOutline,
                "Chat abierto con ${professionalName.substringBefore(" ")}" // TODO: pasar a strings.xml
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SummaryRowPreview() {
    ChapuZappAndroidTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            SummaryRow(Icons.Outlined.CalendarMonth, "Jue, 15 oct · 17:00")
            SummaryRow(Icons.Outlined.LocationOn, "Calle Alan Turing, 12 · 2.º B")
            SummaryRow(Icons.Outlined.ChatBubbleOutline, "Chat abierto con Javier")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BookingConfirmationSummaryPreview() {
    ChapuZappAndroidTheme {
        BookingConfirmationSummary(
            professionalName = "Javier Moreno",
            service = "Cambio de grifo",
            price = 45,
            dateTime = "Jue, 15 oct · 17:00",
            address = "Calle Alan Turing, 12 · 2.º B",
            modifier = Modifier.padding(16.dp),
        )
    }
}