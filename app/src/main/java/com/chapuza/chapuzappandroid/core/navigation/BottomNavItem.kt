package com.chapuza.chapuzappandroid.core.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.chapuza.chapuzappandroid.R
import com.chapuza.chapuzappandroid.core.navigation.Routes.ProfileRoute

data class BottomNavItem(
    @StringRes val labelRes: Int,
    val icon: ImageVector,
    val route: Any
)

val bottomNavItems = listOf(
    BottomNavItem(R.string.home_label, Icons.Outlined.Home, Routes.HomeRoute),
    BottomNavItem(R.string.appointments_label, Icons.Outlined.DateRange, Routes.AppointmentsRoute),
    BottomNavItem(R.string.chat_label, Icons.Outlined.Email, Routes.MessagesRoute),
    BottomNavItem(R.string.profile_label, Icons.Outlined.Person, ProfileRoute)
)