package com.elmancy.feature.jsonplaceholderService.domain.usecase

import com.elmancy.feature.jsonplaceholderService.data.dto.UserDto
import com.elmancy.feature.jsonplaceholderService.domain.repository.JsonPlaceholderRepository
import org.koin.core.annotation.Single

@Single
class GetUsersUseCase(
    private val repository: JsonPlaceholderRepository,
) {
    operator fun invoke(): Result<List<UserDto>> = repository.getUsers()
}

