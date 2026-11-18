package com.chapuza.chapuzappandroid.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val usuario: UsuarioDto,
    val token : String
)