package com.example.oech_app.di

import com.example.oech_app.data.Storage
import com.example.oech_app.ui.screen.forgotPassword.ForgotPasswordViewModel
import com.example.oech_app.ui.screen.login.LogInViewModel
import com.example.oech_app.ui.screen.newPassword.NewPasswordViewModel
import com.example.oech_app.ui.screen.onboarding.OnboardingViewModel
import com.example.oech_app.ui.screen.optVerification.OptVerificationViewModel
import com.example.oech_app.ui.screen.signup.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        Storage(get())
    }
    viewModel {
        OnboardingViewModel(get())
    }
    viewModel {
        SignUpViewModel()
    }
    viewModel {
        LogInViewModel()
    }
    viewModel {
        ForgotPasswordViewModel()
    }
    viewModel {
        OptVerificationViewModel()
    }
    viewModel {
        NewPasswordViewModel()
    }
}