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
import androidx.compose.runtime.LaunchedEffect
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
fun SignUpScreen(
    vm: SignUpViewModel,
    navController: NavController
) {
    val state = vm.state

    LaunchedEffect(state.error) {
        if (state.error == "true") {
            navController.navigate(ScreensRouts.LogInScreen.route)
        }
    }

    if (state.error != null && state.error != "true" ) {
        AlertDialog(
            onDismissRequest = { vm.dismissError() },
            title = { Text(text = "An error occurred") },
            text = { Text(text = state.error.toString()) },
            confirmButton = {
                Button(onClick = { vm.dismissError() }) {
                    Text(text = "Ok")
                }
            }
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
                        modifier = Modifier.padding(top = 33.dp),
                        text = stringResource(R.string.create_an_account),
                        style = defaultTextStyle.textStyle4.copy(color = TextGrayColor)
                    )
                    Text(
                        modifier = Modifier.padding(top = DefaultTopTextPadding),
                        text = stringResource(R.string.complete_the_sign_up_process_to_get_started),
                        style = defaultTextStyle.bodyMedium14.copy(color = DarkGrayColor)
                    )
                    Text(
                        modifier = Modifier.padding(top = 33.dp),
                        text = stringResource(R.string.full_name),
                        style = defaultTextStyle.bodyMedium14.copy(color = DarkGrayColor)
                    )
                    AppTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = DefaultTopTextPadding),
                        value = state.fullName,
                        onValueChange = { newName ->
                            vm.updateName(newName)
                        },
                        hintText = stringResource(R.string.ivanov_ivan)
                    )
                    Text(
                        modifier = Modifier.padding(top = 33.dp),
                        text = stringResource(R.string.phone_number),
                        style = defaultTextStyle.bodyMedium14.copy(color = DarkGrayColor)
                    )
                    AppTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = DefaultTopTextPadding),
                        value = state.phoneNumber,
                        onValueChange = { newPhone ->
                            vm.updatePhone(newPhone)
                        },
                        hintText = stringResource(R.string._7_999_999_99_99)
                    )
                    Text(
                        modifier = Modifier.padding(top = 33.dp),
                        text = stringResource(R.string.email_address),
                        style = defaultTextStyle.bodyMedium14.copy(color = DarkGrayColor)
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
                        modifier = Modifier.padding(top = 33.dp),
                        text = stringResource(R.string.password),
                        style = defaultTextStyle.bodyMedium14.copy(color = DarkGrayColor)
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
                        style = defaultTextStyle.bodyMedium14.copy(color = DarkGrayColor)
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
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 37.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            modifier = Modifier.size(14.dp),
                            checked = state.policyAgree,
                            onCheckedChange = { vm.setAgree(it) }
                        )
                        Text(
                            modifier = Modifier
                                .padding(start = 20.dp),
                            text = stringResource(R.string.by_ticking_this_box_you_agree_to_our_terms_and_conditions_and_private_policy),
                            style = defaultTextStyle.bodyRegular12.copy(color = DarkGrayColor),
                            textAlign = TextAlign.Center
                        )
                    }
                    AppButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 64.dp),
                        text = stringResource(id = R.string.sign_up),
                        textStyle = defaultTextStyle.textButton2,
                        buttonEnabled = state.buttonEnabled,
                        onClick = {
                            if (state.buttonEnabled) vm.signUp()
                        }
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 20.dp, bottom = 18.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            modifier = Modifier.padding(end = 3.dp),
                            text = stringResource(R.string.already_have_an_account),
                            style = defaultTextStyle.textStyle3.copy(color = DarkGrayColor)
                        )
                        Text(
                            modifier = Modifier.clickable { navController.navigate(ScreensRouts.LogInScreen.route) },
                            text = stringResource(R.string.sign_in),
                            style = defaultTextStyle.bodyMedium14.copy(color = PrimaryColor),
                        )
                    }
                    GoogleAuth()
                }
            }

        } else {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
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
private fun SignUpScreenPreview() {
    SignUpScreen(
        vm = koinViewModel(),
        navController = rememberNavController()
    )
}