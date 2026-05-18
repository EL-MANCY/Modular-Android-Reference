package com.elmancy.feature.jsonplaceholderService.data.dataSourceImpl

import com.elmancy.feature.jsonplaceholderService.data.api.JsonPlaceholderService
import com.elmancy.feature.jsonplaceholderService.data.dto.AlbumDto
import com.elmancy.feature.jsonplaceholderService.data.dto.CommentDto
import com.elmancy.feature.jsonplaceholderService.data.dto.PhotoDto
import com.elmancy.feature.jsonplaceholderService.data.dto.PostDto
import com.elmancy.feature.jsonplaceholderService.data.dto.TodoDto
import com.elmancy.feature.jsonplaceholderService.data.dto.UserDto
import com.elmancy.feature.jsonplaceholderService.domain.dataSource.JsonPlaceholderRemoteDataSource
import com.elmancy.network.domain.coreRepository.CoreRepository

class JsonPlaceholderRemoteDataSourceImpl(
    val service: JsonPlaceholderService
) : JsonPlaceholderRemoteDataSource, CoreRepository() {


    override fun getPosts(): Result<List<PostDto>> =
        execute(service.getPosts())

    override fun getPost(id: Int): Result<PostDto> =
        execute(service.getPost(id))

    override fun getCommentsForPost(postId: Int): Result<List<CommentDto>> =
        execute(service.getCommentsForPost(postId))

    override fun getComments(postId: Int): Result<List<CommentDto>> =
        execute(service.getComments(postId))

    override fun createPost(post: PostDto): Result<PostDto> =
        execute(service.createPost(post))

    override fun updatePost(id: Int, post: PostDto): Result<PostDto> =
        execute(service.updatePost(id, post))

    override fun patchPost(id: Int, fields: Map<String, Any?>): Result<PostDto> =
        execute(service.patchPost(id, fields))

    override fun deletePost(id: Int): Result<Unit> =
        execute(service.deletePost(id))

    override fun getAlbums(): Result<List<AlbumDto>> =
        execute(service.getAlbums())

    override fun getPhotos(): Result<List<PhotoDto>> =
        execute(service.getPhotos())

    override fun getTodos(): Result<List<TodoDto>> =
        execute(service.getTodos())

    override fun getTodo(id: Int): Result<TodoDto> =
        execute(service.getTodo(id))

    override fun getUsers(): Result<List<UserDto>> =
        execute(service.getUsers())
}



