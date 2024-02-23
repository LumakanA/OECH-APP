package com.example.oech_app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.oech_app.R
import com.example.oech_app.ui.theme.LightGrayColor
import com.example.oech_app.ui.theme.TextGrayColor
import com.example.oech_app.ui.theme.White
import com.example.oech_app.ui.theme.defaultTextStyle

@Composable
fun SendAPackageCard(
    modifier: Modifier = Modifier,
    nameOfCard: Int,
    firstField: String,
    firstFieldChange: (String) -> Unit,
    secondField: String,
    secondFieldChange: (String) -> Unit,
    thirdField: String,
    thirdFieldChange: (String) -> Unit,
    fourthField: String = "",
    fourthFieldChange: (String) -> Unit = {},
    icon: Int? = null,
    isPackage: Boolean = false
) {


    Column(
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (icon != null) {
                Image(
                    painter = painterResource(R.drawable.orgin_details),
                    contentDescription = ""
                )
            }
            if (!isPackage) {
                Spacer(modifier = Modifier.width(8.dp))
            }
            Text(
                text = stringResource(id = nameOfCard),
                style = defaultTextStyle.bodyMedium12.copy(color = TextGrayColor)
            )
        }

        Column {
            Spacer(modifier = Modifier.height(5.dp))
            SendAPackageCardTextField(
                value = firstField,
                onTextChanged = firstFieldChange,
                hint = if (!isPackage) {
                    R.string.address
                } else {
                    R.string.package_items
                }
            )
            Spacer(modifier = Modifier.height(5.dp))
            SendAPackageCardTextField(
                value = secondField,
                onTextChanged = secondFieldChange,
                hint = if (!isPackage) {
                    R.string.state_country
                } else {
                    R.string.weight_of_item
                }
            )
            Spacer(modifier = Modifier.height(5.dp))
            SendAPackageCardTextField(
                value = thirdField,
                onTextChanged = thirdFieldChange,
                hint = if (!isPackage) {
                    R.string.phone_number
                } else {
                    R.string.worth_of_item
                }
            )
            Spacer(modifier = Modifier.height(5.dp))
            if (!isPackage) {
                SendAPackageCardTextField(
                    value = fourthField,
                    onTextChanged = fourthFieldChange,
                    hint = R.string.others
                )
            }
        }
    }
}

@Composable
fun SendAPackageCardTextField(
    value: String,
    onTextChanged: (String) -> Unit,
    hint: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shadowElevation = 5.dp,
        modifier = Modifier.fillMaxWidth(),
        color = White
    ) {
        BasicTextField(
            value = value,
            onValueChange = onTextChanged,
            singleLine = true,
            textStyle = defaultTextStyle.bodyRegular12.copy(color = TextGrayColor),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .padding(top = 7.dp, bottom = 9.dp, start = 8.dp, end = 8.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        text = if (value.isEmpty()) stringResource(id = hint) else "",
                        style = defaultTextStyle.bodyRegular12.copy(color = LightGrayColor),
                    )
                    innerTextField()
                }
            },
        )
    }
}


@Composable
fun Hint(text: Int) {
    Text(
        text = stringResource(id = text),
        style = defaultTextStyle.bodyRegular12,
        color = LightGrayColor,
    )
}

@Preview
@Composable
private fun SendAPackageCardPreview() {
    SendAPackageCard(
        firstField = "Hello World",
        firstFieldChange = {},
        secondField = "Hello World",
        secondFieldChange = {},
        thirdField = "Hello World",
        thirdFieldChange = {},
        fourthField = "Hello World",
        fourthFieldChange = {},
        icon = R.drawable.back_arrow,
        isPackage = false,
        nameOfCard = R.string.address
    )
}

@Preview
@Composable
private fun SendAPackageCardPreview1() {
    SendAPackageCardTextField(
        hint = R.string.address,
        onTextChanged = {},
        value = "Text"
    )
}