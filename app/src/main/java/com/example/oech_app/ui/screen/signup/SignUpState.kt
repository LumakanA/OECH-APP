package com.example.oech_app.ui.screen.signup

data class SignUpState(
    val fullName: String = "",
    val phoneNumber: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = ""
)