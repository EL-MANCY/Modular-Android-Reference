package com.elmancy.feature.jsonplaceholderService.data.repository

import com.elmancy.feature.jsonplaceholderService.data.dto.PostDto
import com.elmancy.feature.jsonplaceholderService.data.dto.UserDto
import com.elmancy.feature.jsonplaceholderService.domain.dataSource.JsonPlaceholderRemoteDataSource
import com.elmancy.feature.jsonplaceholderService.domain.repository.JsonPlaceholderRepository
import org.koin.core.annotation.Single

@Single(binds = [JsonPlaceholderRepository::class])
class JsonPlaceholderRepositoryImpl(
    private val remote: JsonPlaceholderRemoteDataSource,
) : JsonPlaceholderRepository {
    override fun getPosts(): Result<List<PostDto>> = remote.getPosts()

    override fun getUsers(): Result<List<UserDto>> = remote.getUsers()
}