package com.example.oech_app.ui.screen.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
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
import com.example.oech_app.ui.navigation.ScreensRouts
import com.example.oech_app.ui.theme.DarkGrayColor
import com.example.oech_app.ui.theme.PrimaryColor
import com.example.oech_app.ui.theme.White
import com.example.oech_app.ui.theme.defaultTextStyle
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(
    vm: OnboardingViewModel,
    navController: NavController,
    state: OnboardingState
) {

    vm.setOnboardItems(state.onboardItems)

    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState {
        vm.getOnboardItems().size
    }

    Scaffold { containerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(containerPadding),
            contentAlignment = Alignment.TopCenter
        ) {
            HorizontalPager(state = pagerState) { page ->
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
                            .padding(top = 66.dp),
                        alignment = Alignment.TopCenter,
                        painter = painterResource(id = state.onboardItems[page].imageResId),
                        contentDescription = ""
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 48.dp)
                            .align(Alignment.CenterHorizontally),
                        text = stringResource(state.onboardItems[page].titleResId),
                        style = defaultTextStyle.textStyle1.copy(
                            textAlign = TextAlign.Center,
                            color = PrimaryColor
                        )
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        text = stringResource(state.onboardItems[page].descriptionResId),
                        style = defaultTextStyle.textStyle2.copy(textAlign = TextAlign.Center),
                    )
                    if (pagerState.currentPage == state.onboardItems.size - 1) {
                        AppButton(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 96.dp),
                            text = stringResource(R.string.sign_up),
                            onClick = {
                                vm.setStartupTrue()
                                navController.navigate(ScreensRouts.SignInScreen.route)
                            },
                            textStyle = defaultTextStyle.textButton2.copy(color = White)
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 20.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                modifier = Modifier.padding(end = 1.dp),
                                text = stringResource(R.string.already_have_an_account),
                                style = defaultTextStyle.textStyle3.copy(color = DarkGrayColor)
                            )
                            Text(
                                modifier = Modifier.clickable { },
                                text = stringResource(R.string.sign_in),
                                style = defaultTextStyle.textStyle3Bigger.copy(color = PrimaryColor),
                            )
                        }
                    } else {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 87.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            AppButton(
                                text = stringResource(R.string.skip),
                                backgroundColor = White,
                                contentColor = PrimaryColor,
                                onClick = {
                                    vm.setStartupTrue()
                                    navController.navigate(ScreensRouts.SignInScreen.route)
                                },
                                textStyle = defaultTextStyle.textButton1
                            )
                            AppButton(
                                text = stringResource(R.string.next),
                                onClick = {
                                    if (pagerState.currentPage == state.onboardItems.size - 1) {
                                        navController.navigate(ScreensRouts.SignInScreen.route)
                                    } else {
                                        coroutineScope.launch {
                                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                                        }
                                    }
                                },
                                textStyle = defaultTextStyle.textButton1
                            )
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
private fun OnboardingScreenPreview() {
    OnboardingScreen(
        vm = koinViewModel(),
        navController = rememberNavController(),
        state = OnboardingState()
    )
}