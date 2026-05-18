package com.elmancy.feature.jsonplaceholderService.domain.repository

import com.elmancy.feature.jsonplaceholderService.data.dto.PostDto
import com.elmancy.feature.jsonplaceholderService.data.dto.UserDto

interface JsonPlaceholderRepository {
    fun getPosts(): Result<List<PostDto>>
    fun getUsers(): Result<List<UserDto>>
}

