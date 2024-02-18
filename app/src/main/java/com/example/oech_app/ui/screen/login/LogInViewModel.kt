package com.example.oech_app.ui.screen.login

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.oech_app.data.Storage
import com.example.oech_app.domain.login.LogInUseCase
import com.example.oech_app.domain.models.User
import kotlinx.coroutines.launch
import java.math.BigInteger
import java.security.MessageDigest

class LogInViewModel(private val storage: Storage, private val logInUseCase: LogInUseCase) :
    ViewModel() {

    var state by mutableStateOf(LogInState())
        private set

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

    private fun emailValidate(email: String): Boolean {
        val regex = Regex("""([a-z0-9]+)@([a-z0-9]{3,})\.([a-z]{2,3})""")
        return regex.matches(email)
    }

    fun setAgree(isAgreed: Boolean) {
        state = state.copy(
            rememberAgree = isAgreed
        )
        buttonEnabled()
    }

    fun savePassword(password: String) {
        val hashedPassword = hashPassword(password)
        storage.password = hashedPassword
        buttonEnabled()
        Log.d("PasswordSave", "Password saved: $hashedPassword")
    }

    private fun hashPassword(password: String): String {
        val md = MessageDigest.getInstance("SHA-512")
        val digest = md.digest(password.toByteArray())
        val bigInt = BigInteger(1, digest)
        return bigInt.toString(16)
    }

    private fun buttonEnabled() {
        state =
            if (state.email.isNotEmpty() &&
                state.password.isNotEmpty() &&
                !state.errorEmail
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

    fun logIn() {
        state = state.copy(
            isLoading = true
        )
        viewModelScope.launch {
            try {
                logInUseCase.execute(
                    User(
                        email = state.email,
                        password = state.password
                    )
                )
                state = state.copy(
                    isLoading = false,
                    error = "true"
                )
            } catch (e: Exception) {
                state = state.copy(
                    isLoading = false,
                    error = e.message?.substringBefore('.') ?: "An error occurred"
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

data class LogInState(
    val error: String? = null,
    val isLoading: Boolean = false,
    val email: String = "",
    val errorEmail: Boolean = false,
    val password: String = "",
    val buttonEnabled: Boolean = false,
    val rememberAgree: Boolean = false
)

