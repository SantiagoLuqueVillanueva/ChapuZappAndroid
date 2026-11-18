package com.chapuza.chapuzappandroid.features.auth.data

import com.chapuza.chapuzappandroid.core.data.local.TokenStore
import com.chapuza.chapuzappandroid.features.auth.data.AuthApi
import com.chapuza.chapuzappandroid.features.auth.data.dto.LoginRequest
import com.chapuza.chapuzappandroid.features.auth.data.dto.UsuarioDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(private val api: AuthApi, private val tokenStore: TokenStore){
    suspend fun login(email: String, password: String): Result<UsuarioDto>{
        return try {
            val response = api.login(LoginRequest(email, password))
            tokenStore.saveToken(response.token)
            Result.success(response.usuario.usuario)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}