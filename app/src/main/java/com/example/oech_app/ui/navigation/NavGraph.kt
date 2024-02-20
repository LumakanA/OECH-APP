package com.example.oech_app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.oech_app.ui.screen.forgotPassword.ForgotPasswordScreen
import com.example.oech_app.ui.screen.home.HomeScreen
import com.example.oech_app.ui.screen.login.LogInScreen
import com.example.oech_app.ui.screen.newPassword.NewPasswordScreen
import com.example.oech_app.ui.screen.onboarding.OnboardingScreen
import com.example.oech_app.ui.screen.onboarding.OnboardingState
import com.example.oech_app.ui.screen.optVerification.OptVerificationScreen
import com.example.oech_app.ui.screen.profile.ProfileScreen
import com.example.oech_app.ui.screen.signup.SignUpScreen
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
        composable(ScreensRouts.SignUpScreen.route) {
            SignUpScreen(
                vm = koinViewModel(),
                navController = navHostController
            )
        }
        composable(ScreensRouts.LogInScreen.route) {
            LogInScreen(
                vm = koinViewModel(),
                navController = navHostController
            )
        }
        composable(ScreensRouts.LogInScreen.route) {
            LogInScreen(
                vm = koinViewModel(),
                navController = navHostController
            )
        }
        composable(ScreensRouts.ForgotPasswordScreen.route) {
            ForgotPasswordScreen(
                vm = koinViewModel(),
                navController = navHostController
            )
        }
        composable(ScreensRouts.OptVerificationScreen.route) {
            OptVerificationScreen(
                vm = koinViewModel(),
                navController = navHostController
            )
        }
        composable(ScreensRouts.NewPasswordScreen.route) {
            NewPasswordScreen(
                vm = koinViewModel(),
                navController = navHostController
            )
        }
        composable(ScreensRouts.Home.route) {
            HomeScreen(
                vm = koinViewModel(),
                navController = navHostController
            )
        }
        composable(ScreensRouts.Profile.route) {
            ProfileScreen(
                vm = koinViewModel(),
                navController = navHostController
            )
        }
    }
}