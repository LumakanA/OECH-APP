package com.example.oech_app.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class PackageDetails(
    val packageItems: String = "",
    val weight: Float = 0f,
    val worth: Float = 0f
)
