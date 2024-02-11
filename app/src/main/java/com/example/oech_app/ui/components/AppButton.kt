package com.example.oech_app.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.oech_app.ui.theme.DarkGrayColor
import com.example.oech_app.ui.theme.PrimaryColor
import com.example.oech_app.ui.theme.TextBlackColor
import com.example.oech_app.ui.theme.White
import com.example.oech_app.ui.theme.defaultTextStyle

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    modifierText: Modifier = Modifier,
    backgroundColor: Color = PrimaryColor,
    contentColor: Color = White,
    text: String,
    textStyle: TextStyle,
    buttonEnabled: Boolean = true,
    onClick: () -> Unit = {}
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
        shape = RoundedCornerShape(CornerSize(4.69.dp)),
        border = BorderStroke(1.dp, if (buttonEnabled) PrimaryColor else DarkGrayColor)
    ) {
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


@Preview
@Composable
private fun AppButtonPreview1() {
    AppButton(
        text = "sadasdasd",
        textStyle = defaultTextStyle.textButton1
    )
}

@Preview
@Composable
private fun AppButtonPreview2() {
    AppButton(
        text = "sadasdasd",
        backgroundColor = White,
        contentColor = PrimaryColor,
        textStyle = defaultTextStyle.textButton1
    )
}

@Preview
@Composable
private fun AppButtonPreview3() {
    AppButton(
        text = "sadasdasd",
        textStyle = defaultTextStyle.textButton1,
        buttonEnabled = false
    )
}