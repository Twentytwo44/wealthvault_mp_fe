package org.example.project.presentation.auth.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.launch

import org.example.project.domain.usecase.LoginUseCase

class LoginViewModel(private val loginUseCase: LoginUseCase) : ScreenModel {

    // ✅ เรียกใช้ LoginState ได้เลย (เพราะอยู่ใน package เดียวกัน)
    var state by mutableStateOf(LoginState())
        private set

    fun onUsernameChange(input: String) {
        state = state.copy(username = input)
    }

    fun onPasswordChange(input: String) {
        state = state.copy(password = input)
    }

    fun login() {
        screenModelScope.launch {
            state = state.copy(isLoading = true, error = null)

            val result = loginUseCase(state.username, state.password)

            result.onSuccess {
                state = state.copy(
                    isLoading = false,
                    isLoggedIn = true,
                    error = null
                )
            }.onFailure { e ->
                state = state.copy(
                    isLoading = false,
                    error = e.message ?: "Unknown Error"
                )
            }
        }
    }
}