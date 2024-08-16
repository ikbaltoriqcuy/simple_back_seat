package com.tor.simple_back_seat.ui.viewutils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tor.simple_back_seat.R

/**
Created by ikbaltoriq on 15,July,2024
 **/

@Preview
@Composable
fun QRISView(modifier: Modifier = Modifier) {
    val screenHeight = LocalConfiguration.current.screenHeightDp

    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(16.dp))
            .fillMaxHeight()
            .background(Color.White)
    ) {
        Column(
            modifier
                .padding(16.dp)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_qris_logo),
                contentDescription = "QRIS Logo",
                modifier
                    .height(24.dp),
            )
            val painter = painterResource(id = R.drawable.qris_image)
            val aspectRatio = painter.intrinsicSize.width / painter.intrinsicSize.height
            val imageHeight = (screenHeight * 0.6).toInt()
            Image(
                painter = painter,
                contentDescription = "QRIS QR Code",
                modifier
                    .height(imageHeight.dp)
                    .aspectRatio(aspectRatio)
                    .padding(top = 12.dp)
            )
        }
    }
}