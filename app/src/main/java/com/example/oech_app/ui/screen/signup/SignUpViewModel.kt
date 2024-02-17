package com.example.oech_app.ui.screen.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.oech_app.domain.models.User
import com.example.oech_app.domain.registration.RegistrationUseCase
import kotlinx.coroutines.launch

class SignUpViewModel(val registrationUseCase: RegistrationUseCase) : ViewModel() {
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

    fun signUp() {
        state = state.copy(
            isLoading = true
        )
        viewModelScope.launch {
            try {
                registrationUseCase.execute(
                    User(
                        name = state.fullName,
                        phoneNumber = state.phoneNumber,
                        email = state.email,
                        password = state.password
                    )
                )
                state = state.copy(
                    isLoading = false
                )
            } catch (e: Exception) {
                state = state.copy(
                    isLoading = false,
                    error = "Something went wrong"
                )
            }

        }

    }

    fun dismissError() {
        state = state.copy(
            error = null
        )
    }
}

data class SignUpState(
    val error: String? = null,
    val isLoading: Boolean = false,
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