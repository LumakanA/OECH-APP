package com.example.oech_app.ui.screen.newPassword

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class NewPasswordViewModel : ViewModel() {
    var state by mutableStateOf(NewPasswordState())
        private set

    fun updatePassword(password: String) {
        state = state.copy(password = password)
        buttonEnabled()
    }

    fun updateConfirmPassword(confirmPassword: String) {
        state = state.copy(
            confirmPassword = confirmPassword,
            errorConfirmPassword = passwordValidate(state.password, confirmPassword)
        )
        buttonEnabled()
    }

    private fun passwordValidate(password: String, confirmPassword: String): Boolean {
        return password != confirmPassword
    }

    private fun buttonEnabled() {
        state =
            if (state.confirmPassword.isNotEmpty() &&
                state.password.isNotEmpty() &&
                !state.errorConfirmPassword
            ) {
                state.copy(
                    buttonEnabled = true
                )
            } else {
                state.copy(
                    buttonEnabled = false
                )
            }
    }
}

data class NewPasswordState(
    val password: String = "",
    val confirmPassword: String = "",
    val errorConfirmPassword: Boolean = false,
    val buttonEnabled: Boolean = false,
)

