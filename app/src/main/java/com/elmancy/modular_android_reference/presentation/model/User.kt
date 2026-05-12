package com.elmancy.modular_android_reference.presentation.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class User(
    @SerialName("username")
    val username: String,
    @SerialName("password")
    val password: String
)