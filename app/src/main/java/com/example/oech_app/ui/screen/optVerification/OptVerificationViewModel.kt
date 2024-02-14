package com.example.oech_app.ui.screen.optVerification

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class OptVerificationViewModel : ViewModel() {
    var state by mutableStateOf(OptVerificationState())
        private set

    private fun buttonEnabled() {
        state =
            if (state.isCodeValid) {
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
    val buttonEnabled: Boolean = false,
    val isCodeValid: Boolean = false
)

