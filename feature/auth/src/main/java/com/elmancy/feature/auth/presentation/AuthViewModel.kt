package com.elmancy.feature.auth.presentation

import com.elmancy.feature.auth.domain.usecase.LoginUseCase
import com.elmancy.feature.auth.domain.usecase.RegisterUseCase
import com.elmancy.presentation.viewModel.CoreViewModel
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class AuthViewModel(
    private val registerUseCase: RegisterUseCase,
    private val loginUseCase: LoginUseCase,
) : CoreViewModel<AuthViewModel.AuthEvent, Unit>() {

    fun register(username: String, password: String) {
        launchCore {
            sendEvent(AuthEvent.Loading(true))

            val result = registerUseCase(username, password)
            result
                .onSuccess { sendEvent(AuthEvent.Success("Registration Successful")) }
                .onFailure { sendEvent(AuthEvent.Error(it.message ?: "Registration failed")) }

            sendEvent(AuthEvent.Loading(false))
        }
    }

    fun login(username: String, password: String) {
        launchCore {
            sendEvent(AuthEvent.Loading(true))

            val result = loginUseCase(username, password)
            result
                .onSuccess { sendEvent(AuthEvent.Success("Login Successful!")) }
                .onFailure { sendEvent(AuthEvent.Error(it.message ?: "Wrong credentials")) }

            sendEvent(AuthEvent.Loading(false))
        }
    }

    sealed class AuthEvent {
        data class Loading(val isLoading: Boolean) : AuthEvent()
        data class Success(val message: String) : AuthEvent()
        data class Error(val message: String) : AuthEvent()
    }
}

