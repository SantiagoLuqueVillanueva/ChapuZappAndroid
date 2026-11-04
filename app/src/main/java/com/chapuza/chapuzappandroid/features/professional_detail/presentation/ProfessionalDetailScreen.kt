package com.chapuza.chapuzappandroid.features.professional_detail.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chapuza.chapuzappandroid.core.ui.components.ChapuButton
import com.chapuza.chapuzappandroid.core.ui.components.ChapuButtonVariant
import com.chapuza.chapuzappandroid.core.ui.components.ChapuChip
import com.chapuza.chapuzappandroid.core.ui.components.ChapuIcon
import com.chapuza.chapuzappandroid.core.ui.components.ChapuTextField
import com.chapuza.chapuzappandroid.core.ui.components.ChapuTopBar
import com.chapuza.chapuzappandroid.core.ui.components.ProfessionalCard
import com.chapuza.chapuzappandroid.core.ui.components.RatingStars
import com.chapuza.chapuzappandroid.core.ui.theme.ChapuZappAndroidTheme
import androidx.compose.foundation.layout.Arrangement

@Composable
fun ProfessionalDetailScreen(
    modifier: Modifier = Modifier,
) {
    var likedProfessional by remember { mutableStateOf(false) }
    var selectedTab by remember { mutableStateOf(0) } // 0 = Precios, 1 = Reseñas, 2 = Agenda
    val name = "Javier Moreno"
    val jobAndExp = "Fontanero · 8 años de experiencia"
    val rating = "4,9"
    val reviewCount = "(128 reseñas)"
    val location = "Campanillas, Málaga · a 0,4 km de ti"

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        ChapuTopBar(
            title = "Profesional",
            onBack = {},
            trailingIcon = {
                IconButton(onClick = {
                    likedProfessional = !likedProfessional
                }) {
                    Icon(
                        imageVector = (if (likedProfessional) Icons.Outlined.Favorite else Icons.Filled.Favorite),
                        contentDescription = "Marcar Profesional como Favorito", 
                        tint = if (likedProfessional) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
                    )
                }
            },)
        Column(
            modifier = modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(46.dp)
                    .background(MaterialTheme.colorScheme.primaryContainer, CircleShape),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    Icons.Filled.Person,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                )
            }
            Column(modifier = Modifier.weight(1f)) {
                Text(name, style = MaterialTheme.typography.titleSmall)
                Text(
                    subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                RatingStars(rating = rating)
            }
        }
    }

        // Buscador
        ChapuTextField(
            value = "",
            onValueChange = {},
            label = "Buscar fontanero, electricista...",
            leadingIcon = Icons.Outlined.Search,
            modifier = Modifier.padding(horizontal = 16.dp),
        )

        // Chips de categorías en 2 filas con scroll horizontal
        Column(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            categories.chunked((categories.size + 1) / 2).forEach { rowItems ->
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    rowItems.forEach { category ->
                        ChapuChip(
                            text = category,
                            selected = selectedCategory == category,
                            onClick = { selectedCategory = category },
                        )
                    }
                }
            }
        }

        // Título sección
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Disponibles ahora",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.weight(1f),
            )
            ChapuButton(
                text = "Ver todos",
                onClick = {},
                variant = ChapuButtonVariant.Text,
            )
        }

        // Tarjetas de profesionales
        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            ProfessionalCard(
                name = "Javier M.",
                subtitle = "Fontanería · a 0,4 km",
                rating = 4.9f,
                price = "desde 25 €/h",
                onClick = {},
            )
            ProfessionalCard(
                name = "Laura R.",
                subtitle = "Electricidad · a 0,4 km",
                rating = 4.8f,
                price = "desde 30 €/h",
                onClick = {},
            )
            ProfessionalCard(
                name = "Marta S.",
                subtitle = "Pintura · a 0,9 km",
                rating = 4.8f,
                price = "desde 20 €/h",
                onClick = {},
            )
            ProfessionalCard(
                name = "Pablo G.",
                subtitle = "Carpintería · a 1,2 km",
                rating = 4.7f,
                price = "desde 28 €/h",
                onClick = {},
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    ChapuZappAndroidTheme {
        HomeScreen()
    }
}
