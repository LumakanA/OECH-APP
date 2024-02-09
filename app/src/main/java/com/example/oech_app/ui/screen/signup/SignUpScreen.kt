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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.oech_app.ui.theme.DarkGrayColor
import com.example.oech_app.ui.theme.LightGrayColor
import com.example.oech_app.ui.theme.TextGrayColor
import com.example.oech_app.ui.theme.defaultTextStyle

private val DefaultTopPadding = 24.dp
private val DefaultTopTextPadding = 8.dp

@Composable
fun SignUpScreen(
    vm: SignUpViewModel,
    navController: NavController
) {
    var text by remember { mutableStateOf("") }

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

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = text,
                    onValueChange = { text = it },
                    label = {
                        BasicText(
                            text = "",
                            style = defaultTextStyle.textStyle3Bigger.copy(color = LightGrayColor)
                        )
                    }
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
        navController = rememberNavController()
    )
}