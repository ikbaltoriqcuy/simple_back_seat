package com.tor.simple_back_seat.adsdisplay.right_content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
Created by ikbaltoriq on 05,July,2024
 **/

@Composable
fun OSMMapCompose(lat: Double, long: Double) {
    Box(
        Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .fillMaxHeight(0.90f)
    ) {
    }
}
