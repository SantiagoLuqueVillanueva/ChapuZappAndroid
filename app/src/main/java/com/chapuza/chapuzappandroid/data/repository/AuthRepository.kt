package com.chapuza.chapuzappandroid.data.repository

import com.chapuza.chapuzappandroid.data.local.TokenStore
import com.chapuza.chapuzappandroid.data.remote.AuthApi
import com.chapuza.chapuzappandroid.data.remote.dto.LoginRequest
import com.chapuza.chapuzappandroid.data.remote.dto.UsuarioDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(private val api: AuthApi, private val tokenStore: TokenStore){
    suspend fun login(email: String, password: String): Result<UsuarioDto>{
        return try {
            val response = api.login(LoginRequest(email, password))
            tokenStore.saveToken(response.token)
            Result.success(response.usuario)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}