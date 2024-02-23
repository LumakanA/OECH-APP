package com.example.oech_app.ui.screen.addPaymentMethod

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import com.example.oech_app.ui.theme.DarkGrayColor
import com.example.oech_app.ui.theme.PrimaryColor
import com.example.oech_app.ui.theme.White
import com.example.oech_app.ui.theme.defaultTextStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPaymentMethodScreen(
    navController: NavController
) {

    Scaffold(
        topBar = {
            Surface(color = White, shadowElevation = 8.dp) {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentSize(Alignment.Center),
                            text = stringResource(R.string.add_payment_method),
                            style = defaultTextStyle.subtitleMedium16.copy(color = DarkGrayColor)
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                painter = painterResource(id = R.drawable.arrow_square_right),
                                contentDescription = "",
                                tint = PrimaryColor,
                            )
                        }
                    },
                    modifier = Modifier.clickable { navController.navigateUp() }
                )
            }
        }
    )
    { containerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(containerPadding),
            contentAlignment = Alignment.Center
        ) {
        }
    }
}

@Preview
@Composable
private fun HolderPreview() {
    AddPaymentMethodScreen(
        navController = rememberNavController()
    )
}