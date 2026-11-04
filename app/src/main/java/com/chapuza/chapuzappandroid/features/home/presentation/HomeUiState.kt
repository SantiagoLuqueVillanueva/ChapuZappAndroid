package com.chapuza.chapuzappandroid.features.home.presentation

import androidx.annotation.StringRes
import com.chapuza.chapuzappandroid.R

data class HomeCategory(val id: Int, @param:StringRes val labelRes: Int)

data class AvailableProfessional(
    val id: Int,
    val name: String,
    @param:StringRes val categoryRes: Int,
    val distanceKm: Float,
    val rating: Float,
    val priceFromPerHour: Int,
)

data class HomeUiState(
    val userName: String,
    val location: String,
    val categories: List<HomeCategory>,
    val professionals: List<AvailableProfessional>,
)

fun sampleHomeState() = HomeUiState(
    userName = "Ana",
    location = "Málaga · Campanillas",
    categories = listOf(
        HomeCategory(0, R.string.category_all),
        HomeCategory(1, R.string.category_plumbing),
        HomeCategory(2, R.string.category_electricity),
        HomeCategory(3, R.string.category_locksmith),
        HomeCategory(4, R.string.category_painting),
        HomeCategory(5, R.string.category_carpentry),
        HomeCategory(6, R.string.category_appliances),
        HomeCategory(7, R.string.category_cleaning),
    ),
    professionals = listOf(
        AvailableProfessional(1, "Javier M.", R.string.category_plumbing, 0.4f, 4.9f, 25),
        AvailableProfessional(2, "Laura R.", R.string.category_electricity, 0.4f, 4.8f, 30),
        AvailableProfessional(3, "Marta S.", R.string.category_painting, 0.9f, 4.8f, 20),
        AvailableProfessional(4, "Pablo G.", R.string.category_carpentry, 1.2f, 4.7f, 28),
    ),
)