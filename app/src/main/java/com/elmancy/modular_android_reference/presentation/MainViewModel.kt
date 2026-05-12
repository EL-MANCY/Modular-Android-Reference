package com.elmancy.modular_android_reference.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elmancy.caching.domain.repository.CachingRepository
import com.elmancy.modular_android_reference.domain.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.serialization.builtins.serializer
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class MainViewModel(
    private val cache: CachingRepository
) : ViewModel() {

    val userProfile: Flow<User?> = cache.get("Mancy", User.serializer())

    fun saveUser(name: String) {
        viewModelScope.launch {
            val newUser = User(
                name = name,
                age = 24,
            )

            cache.save("Mancy", newUser, User.serializer())
        }
    }


    fun saveInt(value: Int) {
        viewModelScope.launch {

            cache.save("Mancy2", value, Int.serializer())
        }
    }

    fun getInt(): Flow<Int?> = cache.get("Mancy2", Int.serializer())



    fun clearCache() {
        viewModelScope.launch {
            cache.clear("Mancy")
        }
    }
}