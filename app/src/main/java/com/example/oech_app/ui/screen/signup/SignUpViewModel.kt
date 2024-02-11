package com.example.oech_app.ui.screen.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {
    var state by mutableStateOf(SignUpState())
        private set

    fun updateName(name: String) {
        state = state.copy(fullName = name)
        buttonEnabled()
    }

    fun updatePhone(phone: String) {
        state = state.copy(phoneNumber = phone)
        buttonEnabled()
    }

    fun updateEmail(email: String) {
        state = state.copy(
            email = email,
            errorEmail = !emailValidate(email)
        )
        buttonEnabled()
    }

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

    private fun emailValidate(email: String): Boolean {
        val regex = Regex("""([a-z0-9]+)@([a-z0-9]{3,})\.([a-z]{2,3})""")
        return regex.matches(email)
    }

    private fun passwordValidate(password: String, confirmPassword: String): Boolean {
        return password != confirmPassword
    }
    fun setAgree(isAgreed: Boolean) {
        state = state.copy(
            policyAgree = isAgreed
        )
        buttonEnabled()
    }

    private fun buttonEnabled() {
        state =
            if (state.fullName.isNotEmpty() &&
                state.phoneNumber.isNotEmpty() &&
                state.email.isNotEmpty() &&
                state.password.isNotEmpty() &&
                state.confirmPassword.isNotEmpty() &&
                !state.errorConfirmPassword &&
                !state.errorEmail &&
                state.policyAgree
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

data class SignUpState(
    val fullName: String = "",
    val phoneNumber: String = "",
    val email: String = "",
    val errorEmail: Boolean = false,
    val password: String = "",
    val confirmPassword: String = "",
    val errorConfirmPassword: Boolean = false,
    val buttonEnabled: Boolean = false,
    val policyAgree: Boolean = false
)