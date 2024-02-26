package com.example.oech_app.ui.screen.sendAPackage

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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.oech_app.R
import com.example.oech_app.ui.components.AppButton
import com.example.oech_app.ui.theme.DarkGrayColor
import com.example.oech_app.ui.theme.PrimaryColor
import com.example.oech_app.ui.theme.SecondaryColor
import com.example.oech_app.ui.theme.TextGrayColor
import com.example.oech_app.ui.theme.White
import com.example.oech_app.ui.theme.defaultTextStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SendAPackageReceiptScreen(
    editPackage: () -> Unit,
    makePayment: () -> Unit,
    packageData: SendAPackageState,
    vm: SendAPackageReceiptViewModel,
    navController: NavController
) {

    vm.receiveData(data = packageData)

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
            Column(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .background(White)
                    .fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Package Information",
                    style = defaultTextStyle.subtitleMedium16.copy(color = PrimaryColor)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Origin details",
                    style = defaultTextStyle.bodyRegular12.copy(color = TextGrayColor)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${packageData.details.address}, ${packageData.details.country}",
                    style = defaultTextStyle.bodyRegular12.copy(color = DarkGrayColor)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = packageData.details.phone,
                    style = defaultTextStyle.bodyRegular12.copy(color = DarkGrayColor)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Destination details",
                    style = defaultTextStyle.bodyRegular12.copy(color = TextGrayColor)
                )
                packageData.destinationDetails.forEachIndexed { index, details ->
                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "${index + 1}.${details.address}${details.country}",
                        style = defaultTextStyle.bodyRegular12.copy(color = DarkGrayColor)
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = packageData.details.phone,
                        style = defaultTextStyle.bodyRegular12.copy(color = DarkGrayColor)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Other details",
                    style = defaultTextStyle.bodyRegular12.copy(color = TextGrayColor)
                )

                Spacer(modifier = Modifier.height(4.dp))

                DetailsReceiptField(
                    type = R.string.big_package_items,
                    field = packageData.packageDetails.packageItems
                )

                Spacer(modifier = Modifier.height(8.dp))

                DetailsReceiptField(
                    type = R.string.weight_of_item,
                    field = packageData.packageDetails.weight.toString()
                )

                Spacer(modifier = Modifier.height(8.dp))

                DetailsReceiptField(
                    type = R.string.worth_of_item,
                    field = packageData.packageDetails.worth.toString()
                )

                Spacer(modifier = Modifier.height(8.dp))

                DetailsReceiptField(
                    type = R.string.tracking_number,
                    field = packageData.trackingNumber
                )

                Spacer(modifier = Modifier.height(37.dp))

                Divider(modifier = Modifier.fillMaxWidth())

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Charges",
                    style = defaultTextStyle.subtitleMedium16.copy(color = PrimaryColor)
                )

                Spacer(modifier = Modifier.height(10.dp))

                DetailsReceiptField(
                    type = R.string.delivery_charges,
                    field = vm.state.deliveryCharges.toString()
                )

                Spacer(modifier = Modifier.height(8.dp))

                DetailsReceiptField(
                    type = R.string.instant_delivery,
                    field = vm.state.instantDelivery.toString()
                )

                Spacer(modifier = Modifier.height(8.dp))

                DetailsReceiptField(
                    type = R.string.tax_and_service_charges,
                    field = vm.state.tax.toString()
                )

                Spacer(modifier = Modifier.height(9.dp))

                Divider(modifier = Modifier.fillMaxWidth())

                Spacer(modifier = Modifier.height(4.dp))

                DetailsReceiptField(
                    type = R.string.package_total,
                    field = vm.state.packageTotal.toString()
                )

                Spacer(modifier = Modifier.height(46.dp))

                Row(modifier = Modifier.fillMaxWidth()) {
                    AppButton(
                        text = "Edit package",
                        textStyle = defaultTextStyle.subtitleBold16.copy(color = PrimaryColor),
                        onClick = {
                            editPackage()
                        },
                        backgroundColor = White,
                        contentColor = PrimaryColor,
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    AppButton(
                        text = "Make payment",
                        textStyle = defaultTextStyle.subtitleBold16,
                        onClick = {
                            makePayment()
                        }
                    )
                }
                Spacer(modifier = Modifier.height(46.dp))
            }
        }
    }
}

@Composable
fun DetailsReceiptField(
    modifier: Modifier = Modifier,
    type: Int,
    field: String
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(id = type),
            style = defaultTextStyle.bodyRegular12.copy(color = DarkGrayColor)
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            textAlign = TextAlign.End,
            text = field,
            style = defaultTextStyle.bodyRegular12.copy(color = SecondaryColor)
        )
    }
}

@Preview
@Composable
private fun SendAPackagePreview1() {

    SendAPackageReceiptScreen(
        vm = SendAPackageReceiptViewModel(),
        navController = rememberNavController(),
        editPackage = {},
        makePayment = {},
        packageData = SendAPackageState()
    )
}
