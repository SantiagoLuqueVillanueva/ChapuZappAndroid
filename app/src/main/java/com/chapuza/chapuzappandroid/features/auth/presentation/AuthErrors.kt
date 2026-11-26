package com.chapuza.chapuzappandroid.features.auth.presentation

import retrofit2.HttpException
import java.io.IOException

fun authErrorMessage(e: Throwable): String = when (e) {
    is HttpException -> when (e.code()) {
        401 -> "Correo o contraseña incorrectos"
        409 -> "Ese correo ya está registrado"
        400 -> "Revisa los datos del formulario"
        else -> "Error del servidor, inténtalo más tarde"
    }
    is IOException -> "No hay conexión con el servidor"
    else -> "Ha ocurrido un error inesperado"
}