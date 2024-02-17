package com.example.oech_app.domain.models

data class User(
    val email: String,
    val password: String,
    val name: String = "",
    val phoneNumber: String = ""
)