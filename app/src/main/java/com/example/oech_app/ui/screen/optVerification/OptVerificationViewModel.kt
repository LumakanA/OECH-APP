package com.example.oech_app.ui.screen.optVerification

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class OptVerificationViewModel : ViewModel() {
    var state by mutableStateOf(OptVerificationState())
        private set

    fun updateEmail(email: String) {
        state = state.copy(
            email = email,
            errorEmail = !emailValidate(email)
        )
        buttonEnabled()
    }

    private fun emailValidate(email: String): Boolean {
        val regex = Regex("""([a-z0-9]+)@([a-z0-9]{3,})\.([a-z]{2,3})""")
        return regex.matches(email)
    }

    private fun buttonEnabled() {
        state =
            if (state.email.isNotEmpty() &&
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

data class OptVerificationState(
    val email: String = "",
    val errorEmail: Boolean = false,
    val buttonEnabled: Boolean = false,
)

