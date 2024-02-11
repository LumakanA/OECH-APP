package com.example.oech_app.ui.screen.signup

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
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.oech_app.R
import com.example.oech_app.ui.components.AppButton
import com.example.oech_app.ui.components.AppTextField
import com.example.oech_app.ui.theme.DarkGrayColor
import com.example.oech_app.ui.theme.PrimaryColor
import com.example.oech_app.ui.theme.SecondaryColor
import com.example.oech_app.ui.theme.TextGrayColor
import com.example.oech_app.ui.theme.defaultTextStyle

private val DefaultTopPadding = 24.dp
private val DefaultTopTextPadding = 8.dp

@Composable
fun SignUpScreen(
    vm: SignUpViewModel,
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
                    onValueChange = { newName ->
                        vm.updateName(newName)
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
                    onValueChange = { newPhone ->
                        vm.updatePhone(newPhone)
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
                    onValueChange = { newEmail ->
                        vm.updateEmail(newEmail)
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
                    onValueChange = { newPassword ->
                        vm.updatePassword(newPassword)
                    },
                    isPassword = true,
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
                    onValueChange = { newConfirmPassword ->
                        vm.updateConfirmPassword(newConfirmPassword)
                    },
                    isPassword = true,
                    hintText = "**********"
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 37.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Checkbox(
                        modifier = Modifier.align(Alignment.Top),
                        checked = state.policyAgree,
                        onCheckedChange = { vm.setAgree(it) }
                    )
                    BasicText(
                        modifier = Modifier,
                        text = "By ticking this box, you agree to our Terms and conditions and private policy",
                        style = defaultTextStyle.textStyleMini.copy(color = DarkGrayColor)
                    )
                }
                AppButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 64.dp),
                    text = "Sign Up",
                    textStyle = defaultTextStyle.textButton2,
                    buttonEnabled = state.buttonEnabled
                )
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 20.dp, bottom = 18.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    BasicText(
                        modifier = Modifier.padding(end = 1.dp),
                        text = stringResource(R.string.already_have_an_account),
                        style = defaultTextStyle.textStyle3.copy(color = DarkGrayColor)
                    )
                    BasicText(
                        modifier = Modifier.clickable { },
                        text = stringResource(R.string.sign_in),
                        style = defaultTextStyle.textStyle3Bigger.copy(color = PrimaryColor),
                    )
                }
                GoogleAuth()
            }
        }
    }
}

@Composable
fun GoogleAuth(
    onClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BasicText(
            modifier = Modifier.padding(end = 1.dp),
            text = stringResource(R.string.or_sign_in_using),
            style = defaultTextStyle.textStyle3.copy(color = DarkGrayColor)
        )
        IconButton(onClick = onClick) {
            Icon(
                painter = painterResource(id = R.drawable.google_auth),
                contentDescription = stringResource(R.string.or_sign_in_using),
                tint = SecondaryColor
            )
        }
    }
}

@Preview
@Composable
private fun SignUpScreenPreview() {
    SignUpScreen(
        vm = SignUpViewModel(),
        navController = rememberNavController()
    )
}