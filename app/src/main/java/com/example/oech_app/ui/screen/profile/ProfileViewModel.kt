package com.example.oech_app.ui.screen.profile

import android.media.Image
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.oech_app.domain.usecases.profile.LogOutUseCase
import kotlinx.coroutines.launch

/**
 *Класс LogInViewModel необходим для взаимодействия между экраном LogIn и сервером
 *Создан Александром Николаевичем Рыжковым
 *Дата создания: 18.02.2024 в 19:04
 */

class ProfileViewModel(val logOutUseCase: LogOutUseCase) :
    ViewModel() {
    var state by mutableStateOf(ProfileState())
        private set

    fun showBalance() {
        state = state.copy(
            showBalance = !state.showBalance
        )
    }

    fun logOut() {
        viewModelScope.launch {
            logOutUseCase.execute()
        }
    }
}

data class ProfileState(
    val name: String = "",
    val profileIcon: Image? = null,
    val balance: String = "",
    val showBalance: Boolean = true,
    val enableDarkMode: Boolean = false,
    val darkModeIsEnabled: Boolean = false
)

