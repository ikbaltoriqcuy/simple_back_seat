package com.tor.simple_back_seat.ui.viewutils

import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
Created by ikbaltoriq on 15,July,2024
 **/


@Composable
fun Headline(label: String, color: Color = Color.White , modifier: Modifier = Modifier) {
    Text(
        text = label,
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold,
        color = color,
        modifier = modifier.absolutePadding(left = 8.dp)
    )
}

@Composable
fun SubTitleBold1(label: String, color: Color = Color.White, modifier: Modifier = Modifier) {
    Text(
        text = label,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = color,
        modifier = modifier.absolutePadding(left = 8.dp)
    )
}

@Composable
fun SubTitle2(label: String, color: Color = Color.White, modifier: Modifier = Modifier) {
    Text(
        text = label,
        fontSize = 16.sp,
        textAlign = TextAlign.Center,
        color = color,
        modifier = modifier.absolutePadding(left = 8.dp)
    )
}

@Composable
fun Body2(label: String, color: Color = Color.White, modifier: Modifier = Modifier) {
    Text(
        text = label,
        fontSize = 14.sp,
        textAlign = TextAlign.Center,
        color = color,
        modifier = modifier.absolutePadding(left = 8.dp)
    )
}

@Composable
fun Body1(label: String, color: Color = Color.White, modifier: Modifier = Modifier) {
    Text(
        text = label,
        fontSize = 12.sp,
        textAlign = TextAlign.Center,
        color = color,
        modifier = modifier.absolutePadding(left = 8.dp)
    )
}