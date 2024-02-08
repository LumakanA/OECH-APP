package com.example.oech_app.data

import android.content.Context

private const val SharedPreferenceName = "app_preferences"
private const val IsStartup = "is_startup"

class Storage(context: Context) {
    private val prefs = context.getSharedPreferences(
        SharedPreferenceName,
        Context.MODE_PRIVATE
    )

    private fun getString(key: String): String? {
        return prefs.getString(key, null)
    }

    private fun putString(key: String, value: String?) {
        prefs.edit()
            .putString(key, value)
            .apply()
    }

    var isStartup: String?
        get() {
            return getString(IsStartup)
        }
        set(value) {
            putString(IsStartup, value)
        }
}