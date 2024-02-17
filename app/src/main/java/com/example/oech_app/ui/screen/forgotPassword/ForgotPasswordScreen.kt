package com.example.oech_app.ui.screen.forgotPassword

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

private val DefaultTopPadding = 24.dp
private val DefaultTopTextPadding = 8.dp

@Composable
fun ForgotPasswordScreen(
    vm: ForgotPasswordViewModel,
    navController: NavController
) {
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
                    text = stringResource(R.string.forgot_password_question),
                    style = defaultTextStyle.textStyle4.copy(color = TextGrayColor)
                )
                Text(
                    modifier = Modifier.padding(top = DefaultTopTextPadding),
                    text = stringResource(R.string.enter_your_email_address),
                    style = defaultTextStyle.textStyle3Bigger.copy(color = DarkGrayColor)
                )
                Text(
                    modifier = Modifier.padding(top = 20.dp),
                    text = stringResource(R.string.email_address),
                    style = defaultTextStyle.textStyle3Bigger.copy(color = DarkGrayColor)
                )
                AppTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = DefaultTopTextPadding),
                    value = state.email,
                    onValueChange = { newEmail ->
                        vm.updateEmail(newEmail)
                    },
                    hintText = stringResource(R.string.mail_com)
                )
                AppButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 56.dp),
                    text = stringResource(R.string.send_otp),
                    textStyle = defaultTextStyle.textButton2,
                    buttonEnabled = state.buttonEnabled,
                    onClick = {
                        if (state.buttonEnabled) navController.navigate(ScreensRouts.OptVerificationScreen.route)
                    }
                )
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 20.dp, bottom = 18.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier.padding(end = 2.dp),
                        text = stringResource(R.string.remember_password_back_to),
                        style = defaultTextStyle.textStyle3.copy(color = DarkGrayColor)
                    )
                    Text(
                        modifier = Modifier.clickable { navController.navigateUp() },
                        text = stringResource(R.string.sign_in),
                        style = defaultTextStyle.textStyle3Bigger.copy(color = PrimaryColor),
                    )
                }
            }
        }
    }
}


@Preview
@Composable
private fun ForgotPasswordScreenPreview() {
    ForgotPasswordScreen(
        vm = ForgotPasswordViewModel(),
        navController = rememberNavController()
    )
}