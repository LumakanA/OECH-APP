package com.example.oech_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.oech_app.ui.screen.onboarding.OnboardingOne
import com.example.oech_app.ui.screen.onboarding.OnboardingThree
import com.example.oech_app.ui.screen.onboarding.OnboardingViewModel
import com.example.oech_app.ui.theme.OECHAPPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OECHAPPTheme {
                OnboardingThree(
                    vm = OnboardingViewModel(),
                    navController = rememberNavController()
                )
            }
        }
    }
}

