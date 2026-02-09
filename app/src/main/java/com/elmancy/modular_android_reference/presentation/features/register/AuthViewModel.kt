package com.elmancy.modular_android_reference.presentation.features.register

import com.elmancy.caching.domain.repository.CachingRepository
import com.elmancy.modular_android_reference.presentation.model.User
import com.elmancy.presentation.viewModel.CoreViewModel
import kotlinx.coroutines.flow.firstOrNull
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class AuthViewModel(
    private val repository: CachingRepository
) : CoreViewModel<AuthViewModel.AuthEvent>() {

    fun register(username: String, pass: String) {
        launchCore {
            if (username.isBlank() || pass.isBlank()) {
                sendEvent(AuthEvent.Error("Please fill all fields"))
            }

            val newUser = User(username, pass)
            repository.save("CURRENT_USER", newUser)

            sendEvent(AuthEvent.Success("Registration Successful"))
        }
    }

    fun login(username: String, pass: String) {
        launchCore {
            val savedUser = repository.get("CURRENT_USER", User::class.java).firstOrNull()

            if (savedUser == null) {
                sendEvent(AuthEvent.Error("No user found. Please register."))
            } else if (savedUser.username == username && savedUser.password == pass) {
                sendEvent(AuthEvent.Success("Login Successful!"))
            } else {
                sendEvent(AuthEvent.Error("Wrong credentials"))
            }
        }
    }

    sealed class AuthEvent {
        data class Success(val message: String) : AuthEvent()
        data class Error(val message: String) : AuthEvent()
    }
}