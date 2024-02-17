package com.example.oech_app.ui.screen.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import com.example.oech_app.ui.navigation.ScreensRouts
import com.example.oech_app.ui.theme.DarkGrayColor
import com.example.oech_app.ui.theme.PrimaryColor
import com.example.oech_app.ui.theme.SecondaryColor
import com.example.oech_app.ui.theme.TextGrayColor
import com.example.oech_app.ui.theme.defaultTextStyle
import org.koin.androidx.compose.koinViewModel

private val DefaultTopPadding = 24.dp
private val DefaultTopTextPadding = 8.dp

@Composable
fun LogInScreen(
    vm: LogInViewModel,
    navController: NavController
) {
    val state = vm.state

    if (state.error != null && state.error != "successful") {
        AlertDialog(
            onDismissRequest = { vm.dismissError() },
            title = { Text(text = "Возникла ошибка") },
            text = { Text(text = state.error) },
            confirmButton = {
                Button(onClick = { vm.dismissError() }) {
                    Text(text = "Ok")
                }
            },
        )
    }

    Scaffold { containerPadding ->
        if (!state.isLoading) {
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
                        text = stringResource(R.string.welcome_back),
                        style = defaultTextStyle.textStyle4.copy(color = TextGrayColor)
                    )
                    Text(
                        modifier = Modifier.padding(top = DefaultTopTextPadding),
                        text = stringResource(R.string.fill_in_your_email_and_password_to_continue),
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
                    Text(
                        modifier = Modifier.padding(top = 24.dp),
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
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 17.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            modifier = Modifier.size(14.dp),
                            checked = state.rememberAgree,
                            onCheckedChange = { vm.setAgree(it) }
                        )
                        Text(
                            modifier = Modifier.padding(start = 10.dp),
                            text = stringResource(R.string.remember_password),
                            style = defaultTextStyle.bodyMedium12.copy(color = DarkGrayColor)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .clickable { navController.navigate(ScreensRouts.ForgotPasswordScreen.route) },
                            text = stringResource(R.string.forgot_password_question),
                            style = defaultTextStyle.bodyMedium12.copy(color = PrimaryColor)
                        )
                    }
                    AppButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 187.dp),
                        text = stringResource(R.string.sign_up),
                        textStyle = defaultTextStyle.textButton2,
                        buttonEnabled = state.buttonEnabled,
                        onClick = {
                            if (state.enter) {
                                vm.logIn()
                            }
                            if (state.buttonEnabled) {
                                navController.navigate(
                                    ScreensRouts.Home.route,
                                    builder = {
                                        popUpTo(ScreensRouts.SignUpScreen.route) {
                                            inclusive = true
                                        }
                                    }
                                )
                            }
                            if (state.rememberAgree) vm.savePassword(state.password)
                        }
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 20.dp, bottom = 18.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            modifier = Modifier.padding(end = 1.dp),
                            text = stringResource(R.string.already_have_an_account),
                            style = defaultTextStyle.textStyle3.copy(color = DarkGrayColor)
                        )
                        Text(
                            modifier = Modifier.clickable { navController.navigateUp() },
                            text = stringResource(R.string.sign_up),
                            style = defaultTextStyle.textStyle3Bigger.copy(color = PrimaryColor),
                        )
                    }
                    GoogleAuth()
                }
            }
        } else {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator()
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
        Text(
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
private fun LogInScreenPreview() {
    LogInScreen(
        vm = koinViewModel(),
        navController = rememberNavController()
    )
}