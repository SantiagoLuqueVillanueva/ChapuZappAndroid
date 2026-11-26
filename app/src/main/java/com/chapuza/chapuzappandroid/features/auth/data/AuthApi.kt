package com.chapuza.chapuzappandroid.features.auth.data

import com.chapuza.chapuzappandroid.features.auth.data.dto.LoginRequest
import com.chapuza.chapuzappandroid.features.auth.data.dto.LoginResponse
import com.chapuza.chapuzappandroid.features.auth.data.dto.RegisterRequest
import com.chapuza.chapuzappandroid.features.auth.data.dto.UsuarioDto
import retrofit2.http.Body
import retrofit2.http.POST


interface AuthApi {
    @POST("api/auth/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @POST("api/auth/register")
    suspend fun register(@Body request: RegisterRequest): UsuarioDto
}