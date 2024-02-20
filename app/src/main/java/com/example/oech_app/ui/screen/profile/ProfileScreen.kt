package com.example.oech_app.ui.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.rememberNavController
import com.example.oech_app.R
import com.example.oech_app.ui.components.BottomItemScreen
import com.example.oech_app.ui.theme.DarkGrayColor
import com.example.oech_app.ui.theme.PrimaryColor
import com.example.oech_app.ui.theme.White
import com.example.oech_app.ui.theme.defaultTextStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    vm: ProfileViewModel,
    navController: NavController
) {
    val bottomItems = BottomItemScreen.entries.toTypedArray()

    Scaffold(
        topBar = {
            Surface(color = White, shadowElevation = 8.dp) {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentSize(Alignment.Center),
                            text = "Profile",
                            style = defaultTextStyle.subtitleMedium16.copy(color = DarkGrayColor)
                        )
                    },
//                    navigationIcon = {
//                        IconButton(onClick = { navController.navigateUp() }) {
//                            Icon(
//                                painter = painterResource(id = R.drawable.arrow_square_right),
//                                contentDescription = "stringResource(R.string.turn_back)",
//                                tint = PrimaryColor,
//                            )
//                        }
//                    },
                    modifier = Modifier.clickable { navController.navigateUp() }
                )
            }
        },
        bottomBar = {
            Surface(color = White, shadowElevation = 8.dp) {
                BottomAppBar(
                    containerColor = White,
                    tonalElevation = 16.dp
                ) {
                    bottomItems.forEach { item ->
                        NavigationBarItem(
                            label = {
                                Text(
                                    text = stringResource(id = item.title),
                                    style = defaultTextStyle.textStyle5.copy(color = DarkGrayColor)
                                )
                            },
                            selected = navController.currentDestination?.hierarchy?.any { it.route == item.route } == true,
                            onClick = { navController.navigate(item.route) },
                            icon = {
                                Icon(
                                    painter = painterResource(id = item.icon),
                                    contentDescription = "Navigation icon",
                                    tint = if (navController.currentDestination?.hierarchy?.any { it.route == item.route } == true) {
                                        PrimaryColor // Установка цвета иконки, если выбрана
                                    } else {
                                        DarkGrayColor // Установка серого цвета, если не выбрана
                                    }
                                )
                            }
                        )
                    }
                }
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
            Text(
                text = stringResource(R.string.home),
                style = TextStyle.Default.copy(
                    color = Color.Black,
                    fontSize = 24.sp,
                    lineHeight = 28.13.sp
                )
            )
        }
    }
}

@Preview
@Composable
private fun HolderPreview() {
    ProfileScreen(
        vm = ProfileViewModel(),
        navController = rememberNavController()
    )
}
