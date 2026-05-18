package com.elmancy.feature.auth.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class AuthUser(
    val username: String,
    val password: String,
)