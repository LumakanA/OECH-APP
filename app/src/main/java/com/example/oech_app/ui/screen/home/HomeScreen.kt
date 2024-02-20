package com.example.oech_app.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.oech_app.ui.components.BottomItemScreen
import com.example.oech_app.ui.theme.DarkGrayColor
import com.example.oech_app.ui.theme.PrimaryColor
import com.example.oech_app.ui.theme.White
import com.example.oech_app.ui.theme.defaultTextStyle

@Composable
fun HomeScreen(
    vm: HomeViewModel,
    navController: NavController
) {
    val bottomItems = BottomItemScreen.entries.toTypedArray()

    Scaffold(
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
        }
    }
}

@Preview
@Composable
private fun HolderPreview() {
    HomeScreen(
        vm = HomeViewModel(),
        navController = rememberNavController()
    )
}

@Composable
fun RowScope.AddItem(
    item: BottomItemScreen,
    currentDestination: NavDestination?,
    navController: NavHostController,
) {
    NavigationBarItem(
        label = {
            Text(
                text = stringResource(id = item.title),
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == item.route
        } == true,
        onClick = {
            navController.navigate(
                route = item.route,
            ) {
                popUpTo(BottomItemScreen.HOME.route)
                launchSingleTop = true
            }
        },
        icon = {
            Icon(
                painter = painterResource(id = item.icon),
                contentDescription = "Navigaton icon",
                tint = PrimaryColor
            )
        }
    )
}