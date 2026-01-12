package com.elmancy.modular_android_reference.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elmancy.caching.domain.repository.CachingRepository
import com.elmancy.caching.domain.repository.get
import com.elmancy.modular_android_reference.domain.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class MainViewModel(
    private val cache: CachingRepository
) : ViewModel() {

    val userProfile: Flow<User?> = cache.get<User>("Mancy")

    fun saveUser(name: String) {
        viewModelScope.launch {
            val newUser = User(
                name = name,
                age = 24,
            )

            cache.save("Mancy", newUser)
        }
    }


    fun saveInt(value: Int) {
        viewModelScope.launch {

            cache.save("Mancy2", value)
        }
    }

     fun getInt() : Flow<Int?> = cache.get<Int>("Mancy2")



    fun clearCache() {
        viewModelScope.launch {
            cache.clear("Mancy")
        }
    }
}