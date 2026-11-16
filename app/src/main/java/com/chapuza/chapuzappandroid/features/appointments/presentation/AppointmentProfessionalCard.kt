package com.chapuza.chapuzappandroid.features.appointments.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chapuza.chapuzappandroid.core.ui.components.ChapuAvatar
import com.chapuza.chapuzappandroid.core.ui.theme.ChapuZappAndroidTheme

@Composable
fun AppointmentProfessionalCard(
    name: String,
    role: String,
    rating: String,
    onCallClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        color = MaterialTheme.colorScheme.surfaceContainerLowest,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ChapuAvatar(name = name)
            Spacer(Modifier.width(12.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(name, style = MaterialTheme.typography.titleSmall)
                Text(
                    "$role · ★ $rating", // TODO: pasar a strings.xml
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            IconButton(onClick = onCallClick) {
                Icon(imageVector = Icons.Outlined.Phone,
                    contentDescription = null)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AppointmentProfessionalCardPreview() {
    ChapuZappAndroidTheme {
        AppointmentProfessionalCard(
            name = "Javier Moreno",
            role = "Fontanero",
            rating = "4,9",
            onCallClick = {},
            modifier = Modifier.padding(16.dp),
        )
    }
}