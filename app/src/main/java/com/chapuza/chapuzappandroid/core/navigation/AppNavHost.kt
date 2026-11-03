package com.chapuza.chapuzappandroid.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.chapuza.chapuzappandroid.features.appointments.presentation.AppointmentsScreen
import com.chapuza.chapuzappandroid.features.home.presentation.HomeScreen
import com.chapuza.chapuzappandroid.features.messages.presentation.MessagesScreen
import com.chapuza.chapuzappandroid.features.profile.presentation.ProfileScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Routes.HomeRoute,
        modifier = modifier,
    ) {
        composable<Routes.HomeRoute> { HomeScreen() }
        composable<Routes.AppointmentsRoute> { AppointmentsScreen() }
        composable<Routes.MessagesRoute> { MessagesScreen() }
        composable<Routes.ProfileRoute> { ProfileScreen() }
    }
}
