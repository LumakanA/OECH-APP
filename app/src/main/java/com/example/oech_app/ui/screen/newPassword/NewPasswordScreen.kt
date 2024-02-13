package com.example.oech_app.ui.screen.newPassword

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import com.example.oech_app.ui.theme.TextGrayColor
import com.example.oech_app.ui.theme.defaultTextStyle

private val DefaultTopPadding = 24.dp
private val DefaultTopTextPadding = 8.dp

@Composable
fun NewPasswordScreen(
    vm: NewPasswordViewModel,
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
                    text = stringResource(R.string.new_password),
                    style = defaultTextStyle.textStyle4.copy(color = TextGrayColor)
                )
                Text(
                    modifier = Modifier.padding(top = DefaultTopTextPadding),
                    text = stringResource(R.string.enter_new_password),
                    style = defaultTextStyle.textStyle3Bigger.copy(color = DarkGrayColor)
                )
                Text(
                    modifier = Modifier.padding(top = 33.dp),
                    text = stringResource(R.string.password),
                    style = defaultTextStyle.textStyle3Bigger.copy(color = DarkGrayColor)
                )
                AppTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = DefaultTopTextPadding),
                    value = state.password,
                    onValueChange = { newPassword ->
                        vm.updatePassword(newPassword)
                    },
                    isPassword = true,
                    hintText = stringResource(R.string.hint_password)
                )
                Text(
                    modifier = Modifier.padding(top = 33.dp),
                    text = stringResource(R.string.confirm_password),
                    style = defaultTextStyle.textStyle3Bigger.copy(color = DarkGrayColor)
                )
                AppTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = DefaultTopTextPadding),
                    value = state.confirmPassword,
                    onValueChange = { newConfirmPassword ->
                        vm.updateConfirmPassword(newConfirmPassword)
                    },
                    isPassword = true,
                    hintText = stringResource(R.string.hint_password)
                )
                AppButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 71.dp),
                    text = stringResource(R.string.log_in),
                    textStyle = defaultTextStyle.textButton2,
                    buttonEnabled = state.buttonEnabled,
                    onClick = {
                        if (state.buttonEnabled) navController.navigate(ScreensRouts.LogInScreen.route)
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun LogInScreenPreview() {
    NewPasswordScreen(
        vm = NewPasswordViewModel(),
        navController = rememberNavController()
    )
}