package com.chapuza.chapuzappandroid.features.auth.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val usuario: UsuarioWrapperDto,
    val token : String
)