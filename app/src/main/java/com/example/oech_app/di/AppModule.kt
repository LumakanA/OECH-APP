package com.example.oech_app.di

import com.example.oech_app.data.Storage
import com.example.oech_app.data.repo.RediRepository
import com.example.oech_app.data.repo.RediRepositoryImp
import com.example.oech_app.domain.usecases.login.LogInUseCase
import com.example.oech_app.domain.usecases.profile.LogOutUseCase
import com.example.oech_app.domain.usecases.registration.RegistrationUseCase
import com.example.oech_app.ui.screen.forgotPassword.ForgotPasswordViewModel
import com.example.oech_app.ui.screen.home.HomeViewModel
import com.example.oech_app.ui.screen.login.LogInViewModel
import com.example.oech_app.ui.screen.newPassword.NewPasswordViewModel
import com.example.oech_app.ui.screen.onboarding.OnboardingViewModel
import com.example.oech_app.ui.screen.optVerification.OptVerificationViewModel
import com.example.oech_app.ui.screen.profile.ProfileViewModel
import com.example.oech_app.ui.screen.sendAPackage.SendAPackageReceiptViewModel
import com.example.oech_app.ui.screen.sendAPackage.SendAPackageViewModel
import com.example.oech_app.ui.screen.signup.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        Storage(get())
    }

    single {
        RediRepositoryImp()
    }
    single<RediRepository> { RediRepositoryImp() }
    factory {
        RegistrationUseCase(get())
    }
    factory {
        LogInUseCase(get())
    }
    factory {
        LogOutUseCase(get())
    }
    viewModel {
        OnboardingViewModel(get())
    }
    viewModel {
        SignUpViewModel(get())
    }
    viewModel {
        LogInViewModel(get(), get())
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
    viewModel {
        HomeViewModel()
    }
    viewModel {
        ProfileViewModel(get())
    }
    viewModel {
        SendAPackageViewModel()
    }
    viewModel {
        SendAPackageReceiptViewModel()
    }
}