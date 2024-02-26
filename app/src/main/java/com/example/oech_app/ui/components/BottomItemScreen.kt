package com.example.oech_app.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.oech_app.R
import com.example.oech_app.ui.navigation.ScreensRouts

enum class BottomItemScreen(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val route: String,
) {
    HOME(title = R.string.home_item, R.drawable.house_2, ScreensRouts.Home.route),
    WALLET(title = R.string.wallet_item, R.drawable.wallet_3, "wallet_item"),
    TRACK(title = R.string.track_item, R.drawable.smart_car, "track_item"),
    PROFILE(title = R.string.profile_item, R.drawable.profile_circle, ScreensRouts.Profile.route),
}