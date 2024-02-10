package com.example.oech_app.ui.screen.signup

sealed interface SignUpViewAction {
    data class UpdateName(
        val name: String,
    ) : SignUpViewAction

    data class UpdatePhone(
        val phone: String,
    ) : SignUpViewAction

    data class UpdateEmail(
        val email: String,
    ) : SignUpViewAction

    data class UpdatePassword(
        val password: String,
    ) : SignUpViewAction

    data class UpdateConfirmPassword(
        val confirmPassword: String
    ) : SignUpViewAction
}