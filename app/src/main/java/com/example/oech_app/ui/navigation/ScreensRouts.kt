package com.example.oech_app.ui.navigation

sealed class ScreensRouts(val route: String) {
    data object OnBoarding : ScreensRouts("OnBoarding")
    data object SignUpScreen : ScreensRouts("SignUpScreen")
    data object LogInScreen : ScreensRouts("LogInScreen")
    data object ForgotPasswordScreen : ScreensRouts("ForgotPasswordScreen")
    data object OptVerificationScreen : ScreensRouts("OptVerificationScreen")
    data object NewPasswordScreen : ScreensRouts("NewPasswordScreen")
    data object Home : ScreensRouts("Home")
    data object Profile : ScreensRouts("Profile")
    data object AddPaymentMethod : ScreensRouts("AddPaymentMethod")
    data object Notification : ScreensRouts("Notification")
    data object SendAPackage : ScreensRouts("SendAPackage")
}