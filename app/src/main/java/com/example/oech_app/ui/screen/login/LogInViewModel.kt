package com.example.oech_app.ui.screen.login

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.oech_app.data.Storage
import java.math.BigInteger
import java.security.MessageDigest

class LogInViewModel(private val storage: Storage) : ViewModel() {
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
}

data class LogInState(
    val email: String = "",
    val errorEmail: Boolean = false,
    val password: String = "",
    val buttonEnabled: Boolean = false,
    val rememberAgree: Boolean = false
)

