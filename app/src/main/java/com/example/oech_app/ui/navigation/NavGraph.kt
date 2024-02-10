package com.example.oech_app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.oech_app.ui.screen.onboarding.OnboardingScreen
import com.example.oech_app.ui.screen.onboarding.OnboardingState
import com.example.oech_app.ui.screen.signup.SignUpScreen
import com.example.oech_app.ui.screen.signup.SignUpState
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
                navController = navHostController,
                state = OnboardingState()
            )
        }
        composable(ScreensRouts.SignInScreen.route) {
            SignUpScreen(
                vm = koinViewModel(),
                navController = navHostController,
                state = SignUpState()
            )
        }
    }
}