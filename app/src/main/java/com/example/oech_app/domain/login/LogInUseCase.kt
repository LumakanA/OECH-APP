package com.example.oech_app.domain.login

import com.example.oech_app.data.repo.RediRepository
import com.example.oech_app.domain.models.User

class LogInUseCase(private val repository: RediRepository) {
    suspend fun execute(user: User) {
        repository.logInUser(user)
    }
}