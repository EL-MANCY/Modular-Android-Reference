package com.elmancy.modular_android_reference.presentation.features.register

import com.elmancy.caching.domain.repository.CachingRepository
import com.elmancy.modular_android_reference.presentation.model.User
import com.elmancy.presentation.viewModel.CoreViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.firstOrNull
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class AuthViewModel(
    private val repository: CachingRepository
) : CoreViewModel<AuthViewModel.AuthEvent>() {

    fun register(username: String, pass: String) {
        launchCore {
            sendEvent(AuthEvent.Loading(true))

            if (username.isBlank() || pass.isBlank()) {
                sendEvent(AuthEvent.Error("Please fill all fields"))
                sendEvent(AuthEvent.Loading(false))
                return@launchCore
            }
            delay(1000)

            val newUser = User(username, pass)
            repository.save("CURRENT_USER", newUser, User.serializer())

            sendEvent(AuthEvent.Success("Registration Successful"))
            sendEvent(AuthEvent.Loading(false))
        }
    }

    fun login(username: String, pass: String) {
        launchCore {
            sendEvent(AuthEvent.Loading(true))

            val savedUser = repository.get("CURRENT_USER", User.serializer()).firstOrNull()
            delay(1500)

            if (savedUser?.username == username && savedUser.password == pass) {
                sendEvent(AuthEvent.Success("Login Successful!"))
            } else {
                sendEvent(AuthEvent.Error("Wrong credentials"))
            }
            sendEvent(AuthEvent.Loading(false))
        }
    }

    sealed class AuthEvent {
        data class Loading(val isLoading: Boolean) : AuthEvent()
        data class Success(val message: String) : AuthEvent()
        data class Error(val message: String) : AuthEvent()
    }
}