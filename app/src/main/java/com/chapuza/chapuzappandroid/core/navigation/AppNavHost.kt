package com.chapuza.chapuzappandroid.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.chapuza.chapuzappandroid.features.appointments.presentation.AppointmentsScreen
import com.chapuza.chapuzappandroid.features.appointments.presentation.sampleAppointments
import com.chapuza.chapuzappandroid.features.booking.presentation.BookingConfirmationScreen
import com.chapuza.chapuzappandroid.features.home.presentation.HomeScreen
import com.chapuza.chapuzappandroid.features.messages.presentation.MessagesScreen
import com.chapuza.chapuzappandroid.features.professional_detail.presentation.ProfessionalDetailScreen
import com.chapuza.chapuzappandroid.features.profile.presentation.ProfileScreen
import com.chapuza.chapuzappandroid.features.search.presentation.SearchScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Routes.HomeRoute,
        modifier = modifier,
    ) {
        composable<Routes.HomeRoute> {
            HomeScreen(
                onProfessionalClick = { professionalId ->
                    navController.navigate(Routes.ProfessionalDetailRoute(professionalId))
                },
                onSearchClick = {
                    navController.navigate(Routes.SearchRoute)
                },
            )
        }
        composable<Routes.SearchRoute> {
            SearchScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onProfessionalClick = { professionalId ->
                    navController.navigate(Routes.ProfessionalDetailRoute(professionalId))
                },
            )
        }
        composable<Routes.ProfessionalDetailRoute> { backStackEntry ->
            val route = backStackEntry.toRoute<Routes.ProfessionalDetailRoute>()
            ProfessionalDetailScreen(
                professionalId = route.professionalId,
                onBack = {
                    navController.popBackStack()
                },
                onBookClick = { professionalId ->
                    navController.navigate(Routes.BookingRoute(professionalId))
                },
            )
        }
        composable<Routes.BookingRoute> { backStackEntry ->
            val route = backStackEntry.toRoute<Routes.BookingRoute>()
            val (name, service, price) = when (route.professionalId) {
                "2" -> Triple("Laura R.", "Instalación de enchufe", 30)
                "3" -> Triple("Marta S.", "Pintar habitación", 120)
                "4" -> Triple("Pablo G.", "Montaje de mueble", 45)
                else -> Triple("Javier Moreno", "Cambio de grifo", 45)
            }
            BookingConfirmationScreen(
                professionalName = name,
                service = service,
                price = price,
                dateTime = "Jue, 15 oct · 17:00",
                address = "Calle Alan Turing, 12 · 2.º B",
                onViewAppointments = {
                    navController.navigate(Routes.AppointmentsRoute) {
                        popUpTo(Routes.HomeRoute)
                    }
                },
            )
        }
        composable<Routes.AppointmentsRoute> {
            AppointmentsScreen(
                appointments = sampleAppointments,
                onAppointmentClick = {},
                onSearchClick = {
                    navController.navigate(Routes.SearchRoute)
                },
            )
        }
        composable<Routes.MessagesRoute> {
            MessagesScreen()
        }
        composable<Routes.ProfileRoute> {
            ProfileScreen()
        }
    }
}
