package com.example.compose_camp_mvvm.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_camp_mvvm.ui.theme.AppTheme

@Composable
fun BottomText() {
    Text("Made by GDSC AIT",
        color = Color.Red,
        fontSize = 20.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(Color.White)
            .padding(10.dp)
        )
}


@Preview
@Composable
fun PreviewUsernameSearch() {
    AppTheme {
        BottomText()
    }
}