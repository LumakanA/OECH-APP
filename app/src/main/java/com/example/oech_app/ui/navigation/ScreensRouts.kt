package com.example.oech_app.ui.navigation

sealed class ScreensRouts(val route: String) {
    data object OnBoarding : ScreensRouts("OnBoarding")
    data object SignInScreen : ScreensRouts("SignInScreen")
    data object LogInScreen : ScreensRouts("LogInScreen")
    data object Holder : ScreensRouts("Holder")
}