package com.elmancy.feature.auth.data.repository

import com.elmancy.caching.domain.repository.CachingRepository
import com.elmancy.feature.auth.domain.model.AuthUser
import com.elmancy.feature.auth.domain.repository.AuthRepository
import kotlinx.coroutines.flow.firstOrNull
import org.koin.core.annotation.Single

@Single(binds = [AuthRepository::class])
class AuthRepositoryImpl(
    private val cache: CachingRepository,
) : AuthRepository {
    override suspend fun register(username: String, password: String): Result<Unit> {
        if (username.isBlank() || password.isBlank()) {
            return Result.failure(IllegalArgumentException("Please fill all fields"))
        }

        val newUser = AuthUser(username, password)
        cache.save(KEY_CURRENT_USER, newUser, AuthUser.serializer())

        return Result.success(Unit)
    }

    override suspend fun login(username: String, password: String): Result<Unit> {
        val savedUser = cache.get(KEY_CURRENT_USER, AuthUser.serializer()).firstOrNull()

        if (savedUser?.username == username && savedUser.password == password) {
            return Result.success(Unit)
        }

        return Result.failure(IllegalStateException("Wrong credentials"))
    }

    private companion object {
        private const val KEY_CURRENT_USER = "CURRENT_USER"
    }
}

