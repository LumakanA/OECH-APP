//package com.example.oech_app.ui.components
//
//import androidx.compose.foundation.border
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.text.BasicText
//import androidx.compose.foundation.text.BasicTextField
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import com.example.oech_app.ui.theme.DarkGrayColor
//import com.example.oech_app.ui.theme.ErrorColor
//import com.example.oech_app.ui.theme.LightGrayColor
//import com.example.oech_app.ui.theme.TextGrayColor
//import com.example.oech_app.ui.theme.defaultTextStyle
//
//private val DefaultBorderSize = 1.dp
//
//@Composable
//fun AppTextField(
//    modifier: Modifier = Modifier,
//    value: String,
//    hint: String,
//    onValueChange: (String) -> Unit
//) {
//    val isError = remember { mutableStateOf(false) }
//    BasicTextField(
//        modifier = Modifier
//            .border(
//                DefaultBorderSize, if (isError) {
//                    ErrorColor
//                } else {
//                    DarkGrayColor
//                },
//                shape = RoundedCornerShape(4.dp)
//            ),
//        value = value,
//        singleLine = true,
//        onValueChange = { onValueChange(it) },
//        textStyle = defaultTextStyle.textStyle3Bigger.copy(color = TextGrayColor),
//        decorationBox = { innerTextField ->
//            Box(
//                modifier = Modifier
//                    .clip(RoundedCornerShape(16.dp)),
//                contentAlignment = Alignment.Center
//            ) {
//                BasicText(
//                    text = if (value.isEmpty()) hint else "",
//                    style = defaultTextStyle.textStyle3Bigger.copy(color = LightGrayColor)
//                )
//                innerTextField()
//            }
//        }
//    )
//}
//
//@Preview
//@Composable
//private fun AppTextFieldPreview() {
//    AppTextField(
//        value = "TestTest",
//        hint = "TestTest",
//        onValueChange = {}
//    )
//}