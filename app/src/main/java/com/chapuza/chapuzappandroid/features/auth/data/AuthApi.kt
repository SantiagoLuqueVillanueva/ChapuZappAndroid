package com.chapuza.chapuzappandroid.data.remote

import com.chapuza.chapuzappandroid.data.remote.dto.LoginRequest
import com.chapuza.chapuzappandroid.data.remote.dto.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST


interface AuthApi {
    @POST("api/auth/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse
}