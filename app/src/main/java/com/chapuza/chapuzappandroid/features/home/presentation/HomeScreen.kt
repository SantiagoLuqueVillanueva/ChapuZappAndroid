package com.chapuza.chapuzappandroid.features.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chapuza.chapuzappandroid.R
import com.chapuza.chapuzappandroid.core.ui.components.ChapuButton
import com.chapuza.chapuzappandroid.core.ui.components.ChapuButtonVariant
import com.chapuza.chapuzappandroid.core.ui.components.ChapuCard
import com.chapuza.chapuzappandroid.core.ui.components.ChapuChip
import com.chapuza.chapuzappandroid.core.ui.components.ChapuTextField
import com.chapuza.chapuzappandroid.core.ui.theme.ChapuZappAndroidTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(),
) {
    val state by viewModel.uiState.collectAsState()
    HomeContent(state, modifier)
}

@Composable
private fun HomeContent(
    state: HomeUiState,
    modifier: Modifier = Modifier,
) {
    var selectedCategory by rememberSaveable { mutableStateOf(0) } // 0 = "Todos"

    Column(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
            .padding(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        HomeHeader(state.userName, state.location, Modifier.padding(horizontal = 16.dp))

            ChapuTextField(
                value = "",
                onValueChange = {},
                label = stringResource(R.string.home_search_hint),
                leadingIcon = Icons.Outlined.Search,
                modifier = Modifier.padding(horizontal = 16.dp),
            )

        // Dos filas de chips que se desplazan juntas
        Column(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            state.categories.chunked((state.categories.size + 1) / 2).forEach { rowItems ->
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    rowItems.forEach { category ->
                        ChapuChip(
                            text = stringResource(category.labelRes),
                            selected = selectedCategory == category.id,
                            onClick = { selectedCategory = category.id },
                        )
                    }
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                stringResource(R.string.home_available_now),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.weight(1f),
            )
            ChapuButton(
                text = stringResource(R.string.home_see_all),
                onClick = {},
                variant = ChapuButtonVariant.Text,
            )
        }

        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            state.professionals.forEach { pro ->
                ChapuCard(
                    name = pro.name,
                    subtitle = stringResource(
                        R.string.home_professional_subtitle,
                        stringResource(pro.categoryRes),
                        pro.distanceKm,
                    ),
                    rating = pro.rating,
                    price = stringResource(R.string.home_price_from, pro.priceFromPerHour),
                )
            }
        }
    }
}

@Composable
private fun HomeHeader(userName: String, location: String, modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Column(modifier = Modifier.weight(1f)) {
            Text(stringResource(R.string.home_greeting, userName), style = MaterialTheme.typography.titleLarge)
            Text(location, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
        Box(
            modifier = Modifier.size(40.dp).background(MaterialTheme.colorScheme.primaryContainer, CircleShape),
            contentAlignment = Alignment.Center,
        ) {
            Icon(Icons.Outlined.Person, contentDescription = null, tint = MaterialTheme.colorScheme.onPrimaryContainer)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, locale = "es")
@Composable
private fun HomeScreenPreview() {
    ChapuZappAndroidTheme {
        HomeContent(sampleHomeState())
    }
}
