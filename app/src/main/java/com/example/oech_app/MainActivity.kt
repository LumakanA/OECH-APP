package com.example.oech_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.oech_app.data.Storage
import com.example.oech_app.ui.screen.holder.Holder
import com.example.oech_app.ui.screen.onboarding.OnboardingOne
import com.example.oech_app.ui.screen.onboarding.OnboardingThree
import com.example.oech_app.ui.screen.onboarding.OnboardingTwo
import com.example.oech_app.ui.theme.OECHAPPTheme
import org.koin.android.ext.android.inject
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    private val storage: Storage by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OECHAPPTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = if (storage.isStartup != null) {
                        "holder"
                    } else {
                        "onBoardingOne"
                    }
                ) {
                    composable("onBoardingOne") {
                        OnboardingOne(
                            vm = koinViewModel(),
                            navController = navController
                        )
                    }
                    composable("onBoardingTwo") {
                        OnboardingTwo(
                            vm = koinViewModel(),
                            navController = navController
                        )
                    }
                    composable("onBoardingThree") {
                        OnboardingThree(
                            vm = koinViewModel(),
                            navController = navController
                        )
                    }
                    composable("holder") { Holder() }
                }
            }
        }
    }
}

