package com.example.oech_app.ui.screen.sendAPackage

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.oech_app.R
import com.example.oech_app.ui.components.SendAPackageCard
import com.example.oech_app.ui.navigation.ScreensRouts
import com.example.oech_app.ui.theme.DarkGrayColor
import com.example.oech_app.ui.theme.LightGrayColor
import com.example.oech_app.ui.theme.PrimaryColor
import com.example.oech_app.ui.theme.TextBlackColor
import com.example.oech_app.ui.theme.TextGrayColor
import com.example.oech_app.ui.theme.White
import com.example.oech_app.ui.theme.defaultTextStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SendAPackageScreen(
    onSendButtonClick: (SendAPackageState) -> Unit,
    vm: SendAPackageViewModel,
    navController: NavController
) {
    Scaffold(
        modifier = Modifier.background(color = White),
        topBar = {
            Surface(color = White, shadowElevation = 8.dp) {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentSize(Alignment.Center),
                            text = stringResource(R.string.send_a_package),
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
                .fillMaxWidth()
                .background(White)
                .padding(containerPadding),
            contentAlignment = Alignment.Center
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth()
            ) {
                item { Spacer(modifier = Modifier.height(43.dp)) }
                item {
                    SendAPackageCard(
                        icon = R.drawable.orgin_details,
                        nameOfCard = R.string.origin_details,
                        firstField = vm.state.details.address,
                        firstFieldChange = { vm.changeDetailsAddress(it) },
                        secondField = vm.state.details.country,
                        secondFieldChange = { vm.changeDetailsCountry(it) },
                        thirdField = vm.state.details.phone,
                        thirdFieldChange = { vm.changeDetailsPhone(it) },
                        fourthField = vm.state.details.others,
                        fourthFieldChange = { vm.changeDetailsOthers(it) },
                    )

                }

                item { Spacer(modifier = Modifier.height(39.dp)) }

                itemsIndexed(vm.state.destinationDetails) { index, item ->
                    SendAPackageCard(
                        nameOfCard = R.string.destination_details,
                        icon = R.drawable.map_ping,
                        firstField = vm.state.destinationDetails[index].address,
                        firstFieldChange = { vm.changeDestinationDetailsAddress(it, index) },
                        secondField = vm.state.destinationDetails[index].country,
                        secondFieldChange = { vm.changeDestinationDetailsCountry(it, index) },
                        thirdField = vm.state.destinationDetails[index].phone,
                        thirdFieldChange = { vm.changeDestinationDetailsPhone(it, index) },
                        fourthField = vm.state.destinationDetails[index].others,
                        fourthFieldChange = { vm.changeDestinationDetailsOthers(it, index) }
                    )
                    if (vm.state.destinationDetails.last() != item) {
                        Spacer(modifier = Modifier.height(24.dp))
                    }
                }

                item { Spacer(modifier = Modifier.height(10.dp)) }

                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = { vm.addDestination() },
                            modifier = Modifier.size(14.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.add_square),
                                contentDescription = null,
                                tint = PrimaryColor
                            )
                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = stringResource(R.string.add_destination),
                            style = defaultTextStyle.bodyRegular12.copy(color = DarkGrayColor)
                        )
                    }
                }

                item { Spacer(modifier = Modifier.height(13.dp)) }

                item {
                    SendAPackageCard(
                        nameOfCard = R.string.package_details,
                        firstField = vm.state.packageDetails.packageItems,
                        firstFieldChange = { vm.changePackageItems(it) },
                        secondField = vm.state.packageDetails.weight.toString(),
                        secondFieldChange = { vm.changePackageWeight(it) },
                        thirdField = vm.state.packageDetails.worth.toString(),
                        thirdFieldChange = { vm.changePackageWorth(it) },
                        isPackage = true
                    )
                }

                item { Spacer(modifier = Modifier.height(39.dp)) }

                item {
                    Column {
                        Text(
                            text = stringResource(R.string.select_delivery_type),
                            style = defaultTextStyle.bodyMedium14.copy(color = TextGrayColor)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(modifier = Modifier.fillMaxWidth()) {
                            ButtonPackagePrimary(
                                onClick = {
                                    navController.navigate("${ScreensRouts.SendAPackageReceipt.route}/data")
                                    onSendButtonClick(vm.state)
                                },
                                text = stringResource(R.string.instant_delivery),
                                textStyle = defaultTextStyle.bodyMedium14.copy(color = White),
                                icon = R.drawable.clock
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            ButtonPackageWhite(
                                text = stringResource(R.string.scheduled_delivery),
                                textStyle = defaultTextStyle.bodyMedium14.copy(color = DarkGrayColor),
                                icon = R.drawable.simple_line_icons_calender,
                                backgroundColor = White,
                                contentColor = DarkGrayColor
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ButtonPackagePrimary(
    modifier: Modifier = Modifier,
    modifierText: Modifier = Modifier,
    backgroundColor: Color = PrimaryColor,
    contentColor: Color = White,
    text: String,
    textStyle: TextStyle,
    buttonEnabled: Boolean = true,
    onClick: () -> Unit = {},
    icon: Int
) {
    Button(
        modifier = modifier,
        colors = if (buttonEnabled) {
            ButtonDefaults.buttonColors(
                containerColor = backgroundColor,
                contentColor = contentColor
            )
        } else ButtonDefaults.buttonColors(
            containerColor = DarkGrayColor,
            contentColor = contentColor
        ),
        onClick = onClick,
        shape = RoundedCornerShape(CornerSize(8.dp)),
        border = BorderStroke(1.dp, if (buttonEnabled) PrimaryColor else DarkGrayColor)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(10.dp))
            BasicText(
                modifier = modifierText.padding(horizontal = 8.dp, vertical = 4.dp),
                text = text,
                style = if (backgroundColor == PrimaryColor) {
                    textStyle.copy(color = White)
                } else {
                    textStyle.copy(color = TextBlackColor)
                }
            )
        }
    }
}

@Composable
fun ButtonPackageWhite(
    modifier: Modifier = Modifier,
    modifierText: Modifier = Modifier,
    backgroundColor: Color = PrimaryColor,
    contentColor: Color = White,
    text: String,
    textStyle: TextStyle,
    buttonEnabled: Boolean = true,
    onClick: () -> Unit = {},
    icon: Int
) {
    Button(
        modifier = modifier,
        colors = if (buttonEnabled) {
            ButtonDefaults.buttonColors(
                containerColor = backgroundColor,
                contentColor = contentColor
            )
        } else ButtonDefaults.buttonColors(
            containerColor = DarkGrayColor,
            contentColor = contentColor
        ),
        onClick = onClick,
        shape = RoundedCornerShape(CornerSize(8.dp)),
        border = BorderStroke(1.dp, if (buttonEnabled) LightGrayColor else DarkGrayColor)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(10.dp))
            BasicText(
                modifier = modifierText.padding(vertical = 4.dp),
                text = text,
                style = if (backgroundColor == PrimaryColor) {
                    textStyle.copy(color = White)
                } else {
                    textStyle.copy(color = TextBlackColor)
                }
            )
        }
    }
}

@Preview
@Composable
private fun SendAPackagePreview1() {
    SendAPackageScreen(
        vm = SendAPackageViewModel(),
        navController = rememberNavController(),
        onSendButtonClick = {}
    )
}
