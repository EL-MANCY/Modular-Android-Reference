package com.elmancy.feature.jsonplaceholderService.domain.dataSource

import com.elmancy.feature.jsonplaceholderService.data.dto.AlbumDto
import com.elmancy.feature.jsonplaceholderService.data.dto.CommentDto
import com.elmancy.feature.jsonplaceholderService.data.dto.PhotoDto
import com.elmancy.feature.jsonplaceholderService.data.dto.PostDto
import com.elmancy.feature.jsonplaceholderService.data.dto.TodoDto
import com.elmancy.feature.jsonplaceholderService.data.dto.UserDto


interface JsonPlaceholderRemoteDataSource {
    fun getPosts(): Result<List<PostDto>>
    fun getPost(id: Int): Result<PostDto>
    fun getCommentsForPost(postId: Int): Result<List<CommentDto>>
    fun getComments(postId: Int): Result<List<CommentDto>>
    fun createPost(post: PostDto): Result<PostDto>
    fun updatePost(id: Int, post: PostDto): Result<PostDto>
    fun patchPost(id: Int, fields: Map<String, Any?>): Result<PostDto>
    fun deletePost(id: Int): Result<Unit>
    fun getAlbums(): Result<List<AlbumDto>>
    fun getPhotos(): Result<List<PhotoDto>>
    fun getTodos(): Result<List<TodoDto>>
    fun getTodo(id: Int): Result<TodoDto>
    fun getUsers(): Result<List<UserDto>>
}

