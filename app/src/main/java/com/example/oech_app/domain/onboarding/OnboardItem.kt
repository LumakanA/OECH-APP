package com.example.oech_app.domain.onboarding

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class OnboardItem(
    @DrawableRes val imageResId: Int,
    @StringRes val titleResId: Int,
    @StringRes val descriptionResId: Int
)
