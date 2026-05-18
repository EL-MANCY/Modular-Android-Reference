package com.elmancy.feature.jsonplaceholderService.data.api

import com.elmancy.feature.jsonplaceholderService.data.dto.AlbumDto
import com.elmancy.feature.jsonplaceholderService.data.dto.CommentDto
import com.elmancy.feature.jsonplaceholderService.data.dto.PhotoDto
import com.elmancy.feature.jsonplaceholderService.data.dto.PostDto
import com.elmancy.feature.jsonplaceholderService.data.dto.TodoDto
import com.elmancy.feature.jsonplaceholderService.data.dto.UserDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface JsonPlaceholderService {
    @GET("posts")
    fun getPosts(): Call<List<PostDto>>

    @GET("posts/{id}")
    fun getPost(@Path("id") id: Int): Call<PostDto>

    @GET("posts/{id}/comments")
    fun getCommentsForPost(@Path("id") postId: Int): Call<List<CommentDto>>

    @GET("comments")
    fun getComments(@Query("postId") postId: Int): Call<List<CommentDto>>

    @POST("posts")
    fun createPost(@Body post: PostDto): Call<PostDto>

    @PUT("posts/{id}")
    fun updatePost(@Path("id") id: Int, @Body post: PostDto): Call<PostDto>

    @PATCH("posts/{id}")
    fun patchPost(@Path("id") id: Int, @Body fields: Map<String, Any?>): Call<PostDto>

    @DELETE("posts/{id}")
    fun deletePost(@Path("id") id: Int): Call<Unit>

    @GET("albums")
    fun getAlbums(): Call<List<AlbumDto>>

    @GET("photos")
    fun getPhotos(): Call<List<PhotoDto>>

    @GET("todos")
    fun getTodos(): Call<List<TodoDto>>

    @GET("todos/{id}")
    fun getTodo(@Path("id") id: Int): Call<TodoDto>

    @GET("users")
    fun getUsers(): Call<List<UserDto>>
}


