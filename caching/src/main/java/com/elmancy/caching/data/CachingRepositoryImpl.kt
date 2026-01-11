package com.elmancy.caching.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.elmancy.caching.domain.repository.CachingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.koin.core.annotation.Single

private val Context.dataStore by preferencesDataStore(name = "app_settings")

@Single(binds = [CachingRepository::class])
class CachingRepositoryImpl(private val context: Context) : CachingRepository {
    override suspend fun saveToken(token: String) {
        context.dataStore.edit { it[TOKEN_KEY] = token }
    }

    override fun getToken(): Flow<String?> = context.dataStore.data.map { it[TOKEN_KEY] }

    override suspend fun clearStorage() {
        context.dataStore.edit { it.clear() }
    }

    companion object {
        val TOKEN_KEY = stringPreferencesKey("auth_token")
    }
}