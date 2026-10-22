package com.chapuza.chapuzappandroid.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val label: String,
    val icon: ImageVector,
    val route: Any
)

val bottomNavItems = listOf(
    BottomNavItem("Inicio", Icons.Filled.Home, HomeRoute),
    BottomNavItem("Citas", Icons.Filled.DateRange, AppointmentsRoute),
    BottomNavItem("Mensajes", Icons.Filled.Email, MessagesRoute),
    BottomNavItem("Perfil", Icons.Filled.Person, ProfileRoute)
)