package com.example.oech_app.ui.screen.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import com.example.oech_app.ui.theme.PrimaryColor
import com.example.oech_app.ui.theme.White
import com.example.oech_app.ui.theme.defaultTextStyle
import org.koin.androidx.compose.koinViewModel

@Composable
fun OnboardingTwo(
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
                        .padding(top = 88.dp),
                    alignment = Alignment.TopCenter,
                    painter = painterResource(id = R.drawable.onboarding_two_img),
                    contentDescription = ""
                )
                BasicText(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 48.dp)
                        .align(Alignment.CenterHorizontally),
                    text = stringResource(R.string.flexible_payment),
                    style = defaultTextStyle.textStyle1.copy(
                        textAlign = TextAlign.Center,
                        color = PrimaryColor
                    )
                )
                BasicText(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp),
                    text = stringResource(R.string.different_modes_of_payment_either_before_and_after_delivery_without_stress),
                    style = defaultTextStyle.textStyle2.copy(textAlign = TextAlign.Center),
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 87.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    AppButton(
                        text = "Skip",
                        backgroundColor = White,
                        contentColor = PrimaryColor,
                        onClick = {
                            vm.setStartupTrue()
                            navController.navigate("holder")
                        },
                        textStyle = defaultTextStyle.textButton1
                    )
                    AppButton(
                        text = "Next",
                        onClick = {
                            navController.navigate("onBoardingThree")
                        },
                        textStyle = defaultTextStyle.textButton1
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun OnboardingTwoPreview() {
    OnboardingTwo(
        vm = koinViewModel(),
        navController = rememberNavController()
    )
}