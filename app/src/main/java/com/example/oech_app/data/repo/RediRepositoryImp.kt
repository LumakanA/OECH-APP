package com.example.oech_app.data.repo

import com.example.oech_app.domain.models.User
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.Postgrest
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put

private const val supabaseUrl = "https://iprezyrfnemwovxtywwc.supabase.co"
private const val supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImlwcmV6eXJmbmVtd292eHR5d3djIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDc5MzQxNDAsImV4cCI6MjAyMzUxMDE0MH0.p29L1M4cgVaSeTRnjxE5FUihkGx8pNb1ZPuqKVZXAng"

class RediRepositoryImp : RediRepository {
    val supabase = createSupabaseClient(
        supabaseUrl = supabaseUrl,
        supabaseKey = supabaseKey
    ) {
        install(Auth)
        install(Postgrest)
    }

    override suspend fun registerUser(user: User) {
        supabase.auth.signUpWith(Email) {
            email = user.email
            password = user.password
            data = buildJsonObject {
                put("full_name", user.name)
                put("phone_number", user.phoneNumber)
            }
        }
    }

    override suspend fun logInUser(user: User) {
        supabase.auth.signInWith(Email) {
            email = user.email
            password = user.password
        }
    }

    override suspend fun forgotPassword(user: User) {
        supabase.auth.resetPasswordForEmail(
            email = user.email
        )
    }

    override suspend fun logOut() {
        supabase.auth.signOut()
    }

}