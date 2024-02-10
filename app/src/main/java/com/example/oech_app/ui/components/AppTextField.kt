package com.example.oech_app.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.oech_app.R
import com.example.oech_app.ui.theme.DarkGrayColor
import com.example.oech_app.ui.theme.ErrorColor
import com.example.oech_app.ui.theme.LightGrayColor
import com.example.oech_app.ui.theme.TextGrayColor
import com.example.oech_app.ui.theme.defaultTextStyle


@Composable
fun AppTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    isError: Boolean = false,
    isPassword: Boolean = false,
    hintText: String = ""
) {
    val borderColor by remember { mutableStateOf(getBorderColor(isError)) }
    val textColor by remember { mutableStateOf(getTextColor(isError)) }
    val textHintColor by remember { mutableStateOf(getTextHintColor(isError)) }

    var isTextVisible by remember { mutableStateOf(!isPassword) }

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = defaultTextStyle.textStyle3Bigger.copy(color = textColor),
        modifier = modifier
            .border(BorderStroke(1.dp, borderColor), RoundedCornerShape(4.dp)),
        singleLine = true,
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .padding(vertical = 14.dp, horizontal = 10.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                BasicText(
                    text = if (value.isEmpty()) hintText else "",
                    style = defaultTextStyle.textStyle3Bigger.copy(color = textHintColor),
                )
                if (isPassword) {
                    Image(
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .clickable { isTextVisible = !isTextVisible },
                        painter = painterResource(id = R.drawable.eye_slash),
                        contentDescription = ""
                    )
                }
                innerTextField()
            }
        },
        visualTransformation = if (isPassword && !isTextVisible) PasswordVisualTransformation('*') else VisualTransformation.None
    )
}

private fun getBorderColor(isError: Boolean): Color {
    return if (isError) ErrorColor else DarkGrayColor
}

private fun getTextColor(isError: Boolean): Color {
    return if (isError) ErrorColor else TextGrayColor
}

private fun getTextHintColor(isError: Boolean): Color {
    return if (isError) ErrorColor else LightGrayColor
}

@Preview
@Composable
private fun AppTextFieldPreview() {
    AppTextField(
        modifier = Modifier.fillMaxWidth(),
        value = "TestTest",
        hintText = "TestTest",
        onValueChange = {}
    )
}

@Preview
@Composable
private fun AppTextFieldErrorPreview() {
    AppTextField(
        modifier = Modifier.fillMaxWidth(),
        value = "TestTest",
        hintText = "TestTest",
        isError = true,
        onValueChange = {}
    )
}