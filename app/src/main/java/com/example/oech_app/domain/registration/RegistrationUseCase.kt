package com.example.oech_app.domain.registration

import com.example.oech_app.data.repo.RediRepository
import com.example.oech_app.domain.models.User

class RegistrationUseCase(private val repository: RediRepository) {
    suspend fun execute(user: User) {
        repository.registerUser(user)
    }
}