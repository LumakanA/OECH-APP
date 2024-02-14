package com.example.oech_app.data.supabase

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.postgrest.Postgrest

class SupabaseClient {
    val supabase = createSupabaseClient(
        supabaseUrl = "https://iprezyrfnemwovxtywwc.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImlwcmV6eXJmbmVtd292eHR5d3djIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDc5MzQxNDAsImV4cCI6MjAyMzUxMDE0MH0.p29L1M4cgVaSeTRnjxE5FUihkGx8pNb1ZPuqKVZXAng"
    ) {
        install(Auth)
        install(Postgrest)
    }

}