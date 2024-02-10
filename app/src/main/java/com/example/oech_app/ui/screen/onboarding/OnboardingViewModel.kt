package com.example.oech_app.ui.screen.onboarding

import androidx.lifecycle.ViewModel
import com.example.oech_app.data.Storage
import com.example.oech_app.domain.onboarding.OnboardItem

class OnboardingViewModel(private val storage: Storage): ViewModel() {
    private var onboardItems: List<OnboardItem> = emptyList()

    fun setOnboardItems(items: List<OnboardItem>) {
        onboardItems = items
    }

    fun getOnboardItems(): List<OnboardItem> {
        return onboardItems
    }

    fun setStartupTrue() {
        storage.isStartup = "true"
    }
}