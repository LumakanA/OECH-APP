package com.example.oech_app.domain.usecases.profile

import com.example.oech_app.data.repo.RediRepository

class LogOutUseCase(private val repository: RediRepository) {
    suspend fun execute(){
        repository.logOut()
    }
}