package com.example.oech_app.domain.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Onboarding(
    @DrawableRes val imageResId: Int,
    @StringRes val titleResId: Int,
    @StringRes val descriptionResId: Int
)
