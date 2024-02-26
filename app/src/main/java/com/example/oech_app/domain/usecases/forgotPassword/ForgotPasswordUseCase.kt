package com.example.oech_app.domain.usecases.forgotPassword

import com.example.oech_app.data.repo.RediRepository
import com.example.oech_app.domain.models.User

class ForgotPasswordUseCase(private val repository: RediRepository) {
    suspend fun execute(user: User) {
        repository.registerUser(user)
    }
}