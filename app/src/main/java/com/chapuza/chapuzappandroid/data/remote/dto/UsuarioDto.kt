package com.chapuza.chapuzappandroid.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class UsuarioDto(
    val idUsuario: Int,
    val nombre: String,
    val email: String,
    val rol: String,
    val creadoEn: String,
)