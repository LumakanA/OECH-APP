package com.example.oech_app.ui.screen.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.oech_app.ui.components.AppButton
import com.example.oech_app.ui.components.AppTextField
import com.example.oech_app.ui.theme.DarkGrayColor
import com.example.oech_app.ui.theme.TextGrayColor
import com.example.oech_app.ui.theme.defaultTextStyle

private val DefaultTopPadding = 24.dp
private val DefaultTopTextPadding = 8.dp

@Composable
fun SignUpScreen(
    vm: SignUpViewModel,
    navController: NavController,
    state: SignUpState
) {

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
                BasicText(
                    modifier = Modifier.padding(top = 33.dp),
                    text = "Create an account",
                    style = defaultTextStyle.textStyle4.copy(color = TextGrayColor)
                )
                BasicText(
                    modifier = Modifier.padding(top = DefaultTopTextPadding),
                    text = "Complete the sign up process to get started",
                    style = defaultTextStyle.textStyle3Bigger.copy(color = DarkGrayColor)
                )
                BasicText(
                    modifier = Modifier.padding(top = 33.dp),
                    text = "Full name",
                    style = defaultTextStyle.textStyle3Bigger.copy(color = DarkGrayColor)
                )
                AppTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = DefaultTopTextPadding),
                    value = state.fullName,
                    onValueChange = {
                        SignUpViewAction.UpdateName(it)
                    },
                    hintText = "Ivanov Ivan"
                )
                BasicText(
                    modifier = Modifier.padding(top = 33.dp),
                    text = "Phone Number",
                    style = defaultTextStyle.textStyle3Bigger.copy(color = DarkGrayColor)
                )
                AppTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = DefaultTopTextPadding),
                    value = state.phoneNumber,
                    onValueChange = {
                        SignUpViewAction.UpdatePhone(it)
                    },
                    hintText = "+7(999)999-99-99"
                )
                BasicText(
                    modifier = Modifier.padding(top = 33.dp),
                    text = "Email Address",
                    style = defaultTextStyle.textStyle3Bigger.copy(color = DarkGrayColor)
                )
                AppTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = DefaultTopTextPadding),
                    value = state.email,
                    onValueChange = {
                        SignUpViewAction.UpdateEmail(it)
                    },
                    hintText = "***********@mail.com"
                )
                BasicText(
                    modifier = Modifier.padding(top = 33.dp),
                    text = "Password",
                    style = defaultTextStyle.textStyle3Bigger.copy(color = DarkGrayColor)
                )
                AppTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = DefaultTopTextPadding),
                    value = state.password,
                    onValueChange = {
                        SignUpViewAction.UpdatePassword(it)
                    },
                    hintText = "**********"
                )
                BasicText(
                    modifier = Modifier.padding(top = 33.dp),
                    text = "Confirm Password",
                    style = defaultTextStyle.textStyle3Bigger.copy(color = DarkGrayColor)
                )
                AppTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = DefaultTopTextPadding),
                    value = state.confirmPassword,
                    onValueChange = {
                        SignUpViewAction.UpdateConfirmPassword(it)
                    },
                    hintText = "**********"
                )
                AppButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 129.dp),
                    text = "Sign Up",
                    textStyle = defaultTextStyle.textButton2
                )
            }
        }
    }
}


@Preview
@Composable
private fun SignUpScreenPreview() {
    SignUpScreen(
        vm = SignUpViewModel(),
        navController = rememberNavController(),
        state = SignUpState()
    )
}