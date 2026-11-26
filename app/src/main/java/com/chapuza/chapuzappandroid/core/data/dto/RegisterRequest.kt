package com.chapuza.chapuzappandroid.features.auth.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class RegisterRequest(
    val nombre: String,
    val email: String,
    val password: String,
    val rol: String,
)