package com.example.oech_app.ui.navigation

sealed class ScreensRouts(val route: String) {
    data object OnBoarding : ScreensRouts("onBoarding")
    data object Holder : ScreensRouts("holder")
}