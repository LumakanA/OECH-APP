package com.example.oech_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.oech_app.data.Storage
import com.example.oech_app.ui.navigation.NavGraph
import com.example.oech_app.ui.navigation.ScreensRouts
import com.example.oech_app.ui.theme.OECHAPPTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    private val storage: Storage by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            OECHAPPTheme {
                NavGraph(
                    navHostController = navController,
                    startScreen = if (storage.isStartup != null) {
                        ScreensRouts.Holder.route
                    } else {
                        ScreensRouts.OnBoarding.route
                    }
                )
            }
        }
    }
}

