package com.chapuza.chapuzappandroid.core.navigation

import kotlinx.serialization.Serializable

@Serializable //Esto serializa el objeto "HomeRoute" a texto para que el Navigation pueda aceptarlo como ruta
object HomeRoute
@Serializable
object ProfileRoute

@Serializable
object AppointmentsRoute

@Serializable
object MessagesRoute