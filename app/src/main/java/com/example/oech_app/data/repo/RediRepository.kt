package com.example.oech_app.data.repo

import com.example.oech_app.domain.models.User

interface RediRepository {
    suspend fun registerUser(user: User)

    suspend fun logInUser(user: User)

    suspend fun forgotPassword(user: User)
    suspend fun logOut()
}