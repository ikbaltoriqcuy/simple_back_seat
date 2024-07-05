package com.tor.simple_back_seat.adsdisplay.left_content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tor.simple_back_seat.R

/**
Created by ikbaltoriq on 05,July,2024
 **/

@Composable
fun PaymentItems() {
    Row(modifier = Modifier.fillMaxHeight(fraction =  0.60f)) {
        PaymentIcon(
            imgResId = R.drawable.ic_qris,
            imgSize = 60.dp,
            modifier = Modifier.weight(weight = 0.5f)
        )

        Spacer(modifier = Modifier.width(width = 16.dp))

        PaymentIconWithText(
            imgResId = R.drawable.ic_ezpoint,
            imgSize = 40.dp,
            label = "EZ Point",
            modifier = Modifier.weight(weight = 0.5f)
        )

    }
}

@Composable
private fun PaymentIcon(
    imgResId: Int,
    imgSize: Dp,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(shape = RoundedCornerShape(size = 8.dp))
            .background(color = Color.White)
            .fillMaxHeight(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imgResId),
            contentDescription = "bluebird",
            modifier = Modifier.size(size = imgSize)
        )
    }
}

@Composable
private fun PaymentIconWithText(
    imgResId: Int,
    imgSize: Dp,
    label: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(shape = RoundedCornerShape(size = 8.dp))
            .background(color = Color.White)
            .fillMaxHeight(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Image(
            painter = painterResource(id = imgResId),
            contentDescription = "Payment",
            modifier = Modifier.size(size = imgSize)
        )
        Text(
            text = label,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFF753F),
            modifier = Modifier.absolutePadding(left = 8.dp)
        )
    }
}
