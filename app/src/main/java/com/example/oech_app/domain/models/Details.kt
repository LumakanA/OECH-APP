package com.example.oech_app.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Details(
    val address: String = "",
    val country: String = "",
    val phone: String = "",
    val others: String = ""
)
