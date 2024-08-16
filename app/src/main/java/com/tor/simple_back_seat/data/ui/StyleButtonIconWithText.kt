package com.tor.simple_back_seat.data.ui

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.Dp

/**
Created by ikbaltoriq on 16,July,2024
 **/
data class StyleButtonIconWithText (
    val id: Int = 0,
    val imgResId: Int,
    val imgSize: Dp,
    val imgColor: ColorFilter? = null,
    val textColor: Color = Color.Black,
    val label: String
)