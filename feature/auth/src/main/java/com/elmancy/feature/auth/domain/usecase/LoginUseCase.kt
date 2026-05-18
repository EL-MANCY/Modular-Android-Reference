package com.elmancy.feature.auth.domain.usecase

import com.elmancy.feature.auth.domain.repository.AuthRepository
import kotlinx.coroutines.delay
import org.koin.core.annotation.Single

@Single
class LoginUseCase(
    private val repository: AuthRepository,
) {
    suspend operator fun invoke(username: String, password: String): Result<Unit> {
        delay(1500)
        return repository.login(username, password)
    }
}

