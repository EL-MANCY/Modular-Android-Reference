package com.elmancy.feature.jsonplaceholderService.domain.usecase

import com.elmancy.feature.jsonplaceholderService.data.dto.PostDto
import com.elmancy.feature.jsonplaceholderService.domain.repository.JsonPlaceholderRepository
import org.koin.core.annotation.Single

@Single
class GetPostsUseCase(
    private val repository: JsonPlaceholderRepository,
) {
    operator fun invoke(): Result<List<PostDto>> = repository.getPosts()
}

