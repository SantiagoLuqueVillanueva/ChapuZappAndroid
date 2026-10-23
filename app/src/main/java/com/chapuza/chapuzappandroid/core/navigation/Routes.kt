package com.chapuza.chapuzappandroid.core.navigation

import kotlinx.serialization.Serializable //Importamos el @Serializable

//@Serializable convierte los objetos Route a texto para que el Navigation pueda aceptarlo como ruta
// Declaramos los objetos necesarios para cada ruta

@Serializable
sealed class Routes(val route:String) {
    @Serializable
    object HomeRoute: Routes("home")
    @Serializable
    object ProfileRoute: Routes("profile")

    @Serializable
    object AppointmentsRoute: Routes("appointments")

    @Serializable
    object MessagesRoute:Routes("messages")
}