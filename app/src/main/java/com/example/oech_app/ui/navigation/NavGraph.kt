package com.example.oech_app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.oech_app.ui.screen.addPaymentMethod.AddPaymentMethodScreen
import com.example.oech_app.ui.screen.forgotPassword.ForgotPasswordScreen
import com.example.oech_app.ui.screen.home.HomeScreen
import com.example.oech_app.ui.screen.login.LogInScreen
import com.example.oech_app.ui.screen.newPassword.NewPasswordScreen
import com.example.oech_app.ui.screen.notification.NotificationScreen
import com.example.oech_app.ui.screen.onboarding.OnboardingScreen
import com.example.oech_app.ui.screen.onboarding.OnboardingState
import com.example.oech_app.ui.screen.optVerification.OptVerificationScreen
import com.example.oech_app.ui.screen.profile.ProfileScreen
import com.example.oech_app.ui.screen.sendAPackage.SendAPackageReceiptScreen
import com.example.oech_app.ui.screen.sendAPackage.SendAPackageScreen
import com.example.oech_app.ui.screen.sendAPackage.SendAPackageState
import com.example.oech_app.ui.screen.signup.SignUpScreen
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
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
        composable(ScreensRouts.AddPaymentMethod.route) {
            AddPaymentMethodScreen(
                navController = navHostController
            )
        }
        composable(ScreensRouts.Notification.route) {
            NotificationScreen(
                navController = navHostController
            )
        }
        composable(ScreensRouts.SendAPackage.route) {
            SendAPackageScreen(
                onSendButtonClick = { data ->
                    val json = Json.encodeToString(data)
                    navHostController.navigate("${ScreensRouts.SendAPackageReceipt.route}/$json")
                },
                vm = koinViewModel(),
                navController = navHostController
            )
        }
        composable(
            route = "${ScreensRouts.SendAPackageReceipt.route}/{data}",
            arguments = listOf(navArgument("data") { type = NavType.StringType })
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            arguments.getString("data")?.let { detailsDataString ->
                val detailsData = Json.decodeFromString<SendAPackageState>(detailsDataString)
                SendAPackageReceiptScreen(
                    packageData = detailsData,
                    makePayment = { navHostController.navigate(ScreensRouts.Home.route) },
                    editPackage = { navHostController.navigateUp() },
                    vm = koinViewModel(),
                    navController = navHostController
                )
            }
        }
    }
}