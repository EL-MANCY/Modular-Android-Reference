package com.elmancy.modular_android_reference.domain

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val name: String,
    val age: Int,
)