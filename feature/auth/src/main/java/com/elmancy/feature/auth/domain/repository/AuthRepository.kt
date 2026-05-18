package com.elmancy.feature.auth.domain.repository

interface AuthRepository {
    suspend fun register(username: String, password: String): Result<Unit>
    suspend fun login(username: String, password: String): Result<Unit>
}

