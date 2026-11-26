package com.chapuza.chapuzappandroid.core.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

//private val Context.dataStore by preferencesDataStore(name = "auth")

@Singleton
class TokenStore @Inject constructor(
    private val dataStore: DataStore<Preferences>,
) {
    //@ApplicationContext private val context: Context) {
    private val tokenKey = stringPreferencesKey("token")
    val token: Flow<String?> = dataStore.data.map { preferences -> preferences[tokenKey] }
    suspend fun saveToken(token: String){
        dataStore.edit { preferences -> preferences[tokenKey] = token }
    }
    suspend fun clearToken() {
        dataStore.edit { preferences -> preferences.remove(tokenKey) }
    }
}