package com.example.oech_app.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.oech_app.R

data class AppTextStyles(
    val textStyle1: TextStyle,
    val textStyle2: TextStyle,
    val textStyle3: TextStyle,
    val bodyRegular12: TextStyle,
    val bodyMedium12: TextStyle,
    val textStyle4: TextStyle,
    val bodyMedium14: TextStyle,
    val textButton1: TextStyle,
    val textButton2: TextStyle,
    val subtitleMedium16: TextStyle,
    val textStyle5: TextStyle,
    val textStyle6: TextStyle,
    val subtitleBold16: TextStyle
)

val defaultTextStyle = AppTextStyles(
    textStyle1 = TextStyle(
        fontSize = 24.sp,
        lineHeight = 24.sp,
        fontFamily = FontFamily(Font(R.font.roboto_700))
    ),
    textStyle2 = TextStyle(
        fontSize = 16.sp,
        lineHeight = 20.sp,
        fontFamily = FontFamily(Font(R.font.roboto_400))
    ),
    bodyRegular12 = TextStyle(
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontFamily = FontFamily(Font(R.font.roboto_400))
    ),
    bodyMedium12 = TextStyle(
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontFamily = FontFamily(Font(R.font.roboto_500))
    ),
    textStyle3 = TextStyle(
        fontSize = 14.sp,
        lineHeight = 16.sp,
        fontFamily = FontFamily(Font(R.font.roboto_400))
    ),
    bodyMedium14 = TextStyle(
        fontSize = 14.sp,
        lineHeight = 16.sp,
        fontFamily = FontFamily(Font(R.font.roboto_500))
    ),
    textButton1 = TextStyle(
        fontSize = 14.sp,
        lineHeight = 9.38.sp,
        fontFamily = FontFamily(Font(R.font.roboto_700))
    ),
    textButton2 = TextStyle(
        fontSize = 16.sp,
        lineHeight = 16.sp,
        fontFamily = FontFamily(Font(R.font.roboto_700))
    ),
    textStyle4 = TextStyle(
        fontSize = 24.sp,
        lineHeight = 30.sp,
        fontFamily = FontFamily(Font(R.font.roboto_500))
    ),
    subtitleMedium16 = TextStyle(
        fontSize = 16.sp,
        lineHeight = 16.sp,
        fontFamily = FontFamily(Font(R.font.roboto_500))
    ),
    textStyle5 = TextStyle(
        fontSize = 12.sp,
        lineHeight = 14.06.sp,
        fontFamily = FontFamily(Font(R.font.roboto_400))
    ),
    textStyle6 = TextStyle(
        fontSize = 16.sp,
        lineHeight = 30.sp,
        fontFamily = FontFamily(Font(R.font.roboto_500))
    ),
    subtitleBold16 = TextStyle(
        fontSize = 16.sp,
        lineHeight = 16.sp,
        fontFamily = FontFamily(Font(R.font.roboto_700))
    ),
)