package com.chapuza.chapuzappandroid.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.chapuza.chapuzappandroid.core.navigation.Routes.ProfileRoute

data class BottomNavItem(
    val label: String,
    val icon: ImageVector,
    val route: Any
)

val bottomNavItems = listOf(
    BottomNavItem("Inicio", Icons.Outlined.Home, Routes.HomeRoute),
    BottomNavItem("Citas", Icons.Outlined.DateRange, Routes.AppointmentsRoute),
    BottomNavItem("Mensajes", Icons.Outlined.Email, Routes.MessagesRoute),
    BottomNavItem("Perfil", Icons.Outlined.Person, ProfileRoute)
)