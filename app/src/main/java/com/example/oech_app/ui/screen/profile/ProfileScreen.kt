package com.example.oech_app.ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.rememberNavController
import com.example.oech_app.R
import com.example.oech_app.ui.components.BottomItemScreen
import com.example.oech_app.ui.components.ProfileItem
import com.example.oech_app.ui.navigation.ScreensRouts
import com.example.oech_app.ui.theme.DarkGrayColor
import com.example.oech_app.ui.theme.PrimaryColor
import com.example.oech_app.ui.theme.TextGrayColor
import com.example.oech_app.ui.theme.White
import com.example.oech_app.ui.theme.defaultTextStyle
import org.koin.androidx.compose.koinViewModel
import kotlin.enums.EnumEntries

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
                            text = stringResource(R.string.profile),
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
                .fillMaxWidth()
                .background(White)
                .padding(containerPadding)
                .verticalScroll(rememberScrollState()),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 24.dp)
            ) {
                ProfileUser(
                    modifier = Modifier.padding(top = 27.dp, bottom = 19.dp),
                    name = vm.state.name,
                    showBalance = vm.state.showBalance,
                    balanceIsShow = { vm.showBalance() },
                    balance = vm.state.balance
                )
                Row(
                    modifier = Modifier
                        .padding(top = 24.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.enable_dark_mode),
                        style = defaultTextStyle.subtitleMedium16.copy(color = TextGrayColor)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Switch(
                        checked = vm.state.darkModeIsEnabled,
                        onCheckedChange = { vm.state.enableDarkMode })
                }
                Spacer(modifier = Modifier.height(19.dp))
                ProfileCard(onClick = { /*TODO*/ }, index = 0)
                Spacer(modifier = Modifier.height(12.dp))
                ProfileCard(
                    onClick = { navController.navigate(ScreensRouts.SendAPackage.route) },
                    index = 1
                )
                Spacer(modifier = Modifier.height(12.dp))
                ProfileCard(
                    onClick = { navController.navigate(ScreensRouts.Notification.route) },
                    index = 2
                )
                Spacer(modifier = Modifier.height(12.dp))
                ProfileCard(
                    onClick = { navController.navigate(ScreensRouts.AddPaymentMethod.route) },
                    index = 3
                )
                Spacer(modifier = Modifier.height(12.dp))
                ProfileCard(onClick = { /*TODO*/ }, index = 4)
                Spacer(modifier = Modifier.height(12.dp))
                ProfileCard(
                    onClick = { navController.navigate(ScreensRouts.Home.route) },
                    index = 5
                )
                Spacer(modifier = Modifier.height(12.dp))
                ElevatedCard(
                    modifier = Modifier.padding(bottom = 16.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp
                    ),
                    onClick = {
                        vm.logOut()
                        navController.navigate(ScreensRouts.LogInScreen.route) {
                            popUpTo(ScreensRouts.Home.route) {
                                inclusive = true
                            }
                        }
                    },
                    shape = RectangleShape,
                    colors = CardDefaults.cardColors(
                        containerColor = White
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            modifier = Modifier.padding(start = 12.dp),
                            painter = painterResource(id = R.drawable.ic_round_log_out),
                            contentDescription = ""
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .padding(vertical = 13.dp),
                        ) {
                            Text(
                                modifier = Modifier.padding(),
                                text = stringResource(R.string.log_out),
                                style = defaultTextStyle.subtitleMedium16.copy(color = TextGrayColor)
                            )
                        }

                        Spacer(modifier = Modifier.weight(1f))

                        Image(
                            modifier = Modifier
                                .padding(end = 10.dp),
                            painter = painterResource(id = R.drawable.back_arrow),
                            contentDescription = "",
                            alignment = Alignment.CenterEnd
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileUser(
    modifier: Modifier = Modifier,
    profileIcon: Int = R.drawable.profile_circle,
    name: String,
    showBalance: Boolean,
    balanceIsShow: () -> Unit,
    balance: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape),
            painter = painterResource(id = profileIcon),
            contentDescription = ""
        )
        Column(
            modifier = Modifier
                .padding(start = 5.dp),
        ) {
            Text(
                modifier = Modifier,
                text = stringResource(R.string.hello, name),
                style = defaultTextStyle.textStyle6.copy(color = TextGrayColor)
            )
            Row(modifier = Modifier.padding(top = 1.dp)) {
                Text(
                    text = "Current balance:",
                    style = defaultTextStyle.bodyRegular12.copy(color = TextGrayColor)
                )
                Text(
                    modifier = Modifier.padding(start = 5.dp),
                    text = if (showBalance) balance else stringResource(id = R.string.hint_password),
                    style = defaultTextStyle.bodyMedium12.copy(color = PrimaryColor)
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Image(
            modifier = Modifier
                .padding(end = 10.dp)
                .clickable { balanceIsShow() },
            painter = painterResource(id = R.drawable.eye_slash),
            contentDescription = "",
            alignment = Alignment.CenterEnd
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    item: EnumEntries<ProfileItem> = ProfileItem.entries,
    index: Int
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        onClick = onClick,
        shape = RectangleShape,
        colors = CardDefaults.cardColors(
            containerColor = White
        )
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.padding(start = 12.dp),
                painter = painterResource(id = item[index].image),
                contentDescription = ""
            )
            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .padding(vertical = 13.dp),
            ) {
                Text(
                    modifier = Modifier.padding(),
                    text = stringResource(id = item[index].title),
                    style = defaultTextStyle.subtitleMedium16.copy(color = TextGrayColor)
                )
                Row(modifier = Modifier.padding(top = 1.dp)) {
                    Text(
                        text = stringResource(item[index].description),
                        style = defaultTextStyle.bodyRegular12.copy(color = DarkGrayColor)
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Image(
                modifier = Modifier
                    .padding(end = 10.dp),
                painter = painterResource(id = R.drawable.back_arrow),
                contentDescription = "",
                alignment = Alignment.CenterEnd
            )
        }
    }
}

@Preview
@Composable
private fun ProfilePreview() {
    ProfileScreen(
        vm = koinViewModel(),
        navController = rememberNavController()
    )
}