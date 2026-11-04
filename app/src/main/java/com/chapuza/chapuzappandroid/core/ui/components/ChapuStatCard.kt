package com.chapuza.chapuzappandroid.core.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chapuza.chapuzappandroid.core.ui.theme.ChapuZappAndroidTheme

@Composable
fun ChapuStatCard(
    value: String,
    label: String,
    modifier: Modifier= Modifier
){
    Surface(modifier=modifier, color= MaterialTheme.colorScheme.surfaceContainerLowest, shape = MaterialTheme.shapes.medium, border = BorderStroke(1.dp,
        MaterialTheme.colorScheme.outlineVariant)) {
        Column(Modifier.fillMaxWidth().padding(vertical = 12.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(value,style= MaterialTheme.typography.titleLarge)
            Text(label, style = MaterialTheme.typography.bodySmall,color= MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ChapuStatCardPreview() {
    ChapuZappAndroidTheme {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            ChapuStatCard(value = "12", label = "Citas", modifier = Modifier.weight(1f))
            ChapuStatCard(value = "5", label = "Favoritos", modifier = Modifier.weight(1f))
            ChapuStatCard(value = "8", label = "Reseñas", modifier = Modifier.weight(1f))
        }
    }
}
