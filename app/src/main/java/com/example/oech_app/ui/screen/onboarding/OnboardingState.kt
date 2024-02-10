package com.example.oech_app.ui.screen.onboarding

import com.example.oech_app.R
import com.example.oech_app.domain.onboarding.OnboardItem

data class OnboardingState(
    val onboardItems: List<OnboardItem> = listOf(
        OnboardItem(
            R.drawable.onboarding_one_img,
            R.string.quick_delivery_at_your_doorstep,
            R.string.enjoy_quick_pick_up_and_delivery_to_your_destination
        ),
        OnboardItem(
            R.drawable.onboarding_two_img,
            R.string.flexible_payment,
            R.string.different_modes_of_payment_either_before_and_after_delivery_without_stress
        ),
        OnboardItem(
            R.drawable.onboarding_three_img,
            R.string.real_time_tracking,
            R.string.track_your_packages_items_from_the_comfort_of_your_home_till_final_destination
        ),
    )
)