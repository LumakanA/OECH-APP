package com.example.oech_app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.oech_app.ui.screen.holder.Holder
import com.example.oech_app.ui.screen.onboarding.OnboardingScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun NavGraph(
    navHostController: NavHostController,
    startScreen: String
) {
    NavHost(navController = navHostController, startDestination = startScreen) {
        composable(ScreensRouts.OnBoarding.route) {
            OnboardingScreen(
                vm = koinViewModel(),
                navController = navHostController
            )
        }
        composable(ScreensRouts.Holder.route) {
            Holder()
        }
    }
}