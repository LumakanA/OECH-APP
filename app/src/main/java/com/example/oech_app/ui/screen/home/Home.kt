package com.example.oech_app.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.oech_app.R

@Composable
fun Home() {
    Scaffold { containerPadding ->
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
    Home()
}