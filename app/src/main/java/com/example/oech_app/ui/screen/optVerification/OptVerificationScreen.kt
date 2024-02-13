package com.example.oech_app.ui.screen.optVerification

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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.oech_app.R
import com.example.oech_app.ui.components.AppButton
import com.example.oech_app.ui.components.AppTextField
import com.example.oech_app.ui.navigation.ScreensRouts
import com.example.oech_app.ui.theme.DarkGrayColor
import com.example.oech_app.ui.theme.PrimaryColor
import com.example.oech_app.ui.theme.TextGrayColor
import com.example.oech_app.ui.theme.defaultTextStyle
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private val DefaultTopPadding = 24.dp
private val DefaultTopTextPadding = 8.dp

@Composable
fun OptVerificationScreen(
    vm: OptVerificationViewModel,
    navController: NavController
) {
    var codeState by remember { mutableStateOf(List(6) { "" }) } // Список состояний для каждого квадратика
    val isCodeValid = codeState.all { it.isNotEmpty() } // Проверяем, все ли квадратики заполнены
    var remainingTime by remember { mutableIntStateOf(0) }
    var isTimerRunning by remember { mutableStateOf(false) }
    fun startTimer() {
        remainingTime = 60
        isTimerRunning = true
        vm.viewModelScope.launch {
            while (remainingTime > 0) {
                delay(1000)
                remainingTime--
            }
            isTimerRunning = false
        }
    }


    val state = vm.state
    Scaffold { containerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(containerPadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = DefaultTopPadding, end = 23.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    modifier = Modifier.padding(top = 110.dp),
                    text = stringResource(R.string.otp_verification),
                    style = defaultTextStyle.textStyle4.copy(color = TextGrayColor)
                )
                Text(
                    modifier = Modifier.padding(top = DefaultTopTextPadding),
                    text = stringResource(R.string.enter_the_6_digit_numbers_sent_to_your_email),
                    style = defaultTextStyle.textStyle3Bigger.copy(color = DarkGrayColor)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 52.dp),
                    horizontalArrangement = Arrangement.spacedBy(30.dp)
                ) {
                    for (i in codeState.indices) {
                        AppTextField(
                            modifier = Modifier.size(32.dp),
                            value = codeState[i],
                            onValueChange = { newValue ->
                                if (newValue.length <= 1) {
                                    codeState = codeState.toMutableList().also { it[i] = newValue }
                                }
                            },
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 30.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier.padding(end = 2.dp),
                        text = stringResource(R.string.if_you_didn_t_receive_code),
                        style = defaultTextStyle.textStyle3.copy(color = DarkGrayColor)
                    )
                    Text(
                        modifier = Modifier.clickable {
                            if (!isTimerRunning) {
                                startTimer()
                            }
                        },
                        text = if (remainingTime > 0) {
                            "Resend after $remainingTime"
                        } else {
                            "Resend"
                        },
                        style = defaultTextStyle.textStyle3Bigger.copy(color = PrimaryColor),
                    )
                }
                AppButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 82.dp),
                    text = stringResource(R.string.set_new_password),
                    textStyle = defaultTextStyle.textButton2,
                    buttonEnabled = state.buttonEnabled,
                    onClick = {
                        if (state.buttonEnabled) navController.navigate(ScreensRouts.NewPasswordScreen.route)
                    }
                )
            }
        }
    }
}


@Preview
@Composable
private fun OptVerificationScreenPreview() {
    OptVerificationScreen(
        vm = OptVerificationViewModel(),
        navController = rememberNavController()
    )
}