package com.elmancy.caching.domain.repository

import kotlinx.coroutines.flow.Flow

interface CachingRepository {

    suspend fun saveToken(token: String)

    fun getToken(): Flow<String?>

    suspend fun clearStorage()
}