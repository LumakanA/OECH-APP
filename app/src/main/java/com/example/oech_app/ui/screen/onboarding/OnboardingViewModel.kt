package com.example.oech_app.ui.screen.onboarding

import androidx.lifecycle.ViewModel
import com.example.oech_app.data.Storage

class OnboardingViewModel(private val storage: Storage): ViewModel() {
    fun setStartupTrue() {
        storage.isStartup = "true"
    }
}