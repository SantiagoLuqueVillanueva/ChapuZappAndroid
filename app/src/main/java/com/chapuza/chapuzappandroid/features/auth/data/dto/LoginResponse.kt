package com.chapuza.chapuzappandroid.features.auth.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val usuario: UsuarioDto,
    val token : String
)