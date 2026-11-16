package com.chapuza.chapuzappandroid.core.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes(val route: String) {
    @Serializable
    object HomeRoute : Routes("home")

    @Serializable
    object ProfileRoute : Routes("profile")

    @Serializable
    object AppointmentsRoute : Routes("appointments")

    @Serializable
    object MessagesRoute : Routes("messages")

    @Serializable
    data class ProfessionalDetailRoute(val professionalId: String) : Routes("professional_detail")

    @Serializable
    data class BookingRoute(val professionalId: String) : Routes("booking")

    @Serializable
    object SearchRoute : Routes("search")
}
