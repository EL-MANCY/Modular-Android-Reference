package com.elmancy.modular_android_reference.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elmancy.caching.domain.repository.CachingRepository
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class MainViewModel(
    private val repository: CachingRepository
) : ViewModel() {

    val tokenFlow = repository.getToken()

    fun saveToken(token: String) {
        viewModelScope.launch {
            repository.saveToken(token)
        }
    }
}