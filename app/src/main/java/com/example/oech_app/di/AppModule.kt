package com.example.oech_app.di

import com.example.oech_app.data.Storage
import com.example.oech_app.ui.screen.onboarding.OnboardingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        Storage(get())
    }
    viewModel {
        OnboardingViewModel(get())
    }
}