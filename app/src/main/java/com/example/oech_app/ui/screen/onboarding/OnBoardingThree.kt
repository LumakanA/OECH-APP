package com.example.oech_app.ui.screen.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.oech_app.R
import com.example.oech_app.ui.components.AppButton
import com.example.oech_app.ui.theme.DarkGrayColor
import com.example.oech_app.ui.theme.PrimaryColor
import com.example.oech_app.ui.theme.White
import com.example.oech_app.ui.theme.defaultTextStyle
import org.koin.androidx.compose.koinViewModel

@Composable
fun OnboardingThree(
    vm: OnboardingViewModel,
    navController: NavController
) {
    Scaffold { containerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(containerPadding),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 24.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(400.dp)
                        .padding(top = 105.dp),
                    alignment = Alignment.TopCenter,
                    painter = painterResource(id = R.drawable.onboarding_three_img),
                    contentDescription = ""
                )
                BasicText(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 48.dp)
                        .align(Alignment.CenterHorizontally),
                    text = stringResource(R.string.real_time_tracking),
                    style = defaultTextStyle.textStyle1.copy(
                        textAlign = TextAlign.Center,
                        color = PrimaryColor
                    )
                )
                BasicText(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp),
                    text = stringResource(R.string.track_your_packages_items_from_the_comfort_of_your_home_till_final_destination),
                    style = defaultTextStyle.textStyle2.copy(textAlign = TextAlign.Center),
                )

                AppButton(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 96.dp),
                    text = "Sign Up",
                    onClick = {
                        vm.setStartupTrue()
                        navController.navigate("holder")
                    },
                    textStyle = defaultTextStyle.textButton2.copy(color = White)
                )
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 20.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    BasicText(
                        modifier = Modifier.padding(end = 1.dp),
                        text = "Already have an account?",
                        style = defaultTextStyle.textStyle3.copy(color = DarkGrayColor)
                    )
                    BasicText(
                        modifier = Modifier.clickable { },
                        text = "Sign in",
                        style = defaultTextStyle.textStyle3Bigger.copy(color = PrimaryColor),
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun OnboardingThreePreview() {
    OnboardingThree(
        vm = koinViewModel(),
        navController = rememberNavController()
    )
}