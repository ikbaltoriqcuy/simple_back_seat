package com.tor.simple_back_seat.adsdisplay.right_content

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tor.simple_back_seat.R

/**
Created by ikbaltoriq on 05,July,2024
 **/

@Composable
fun ButtonMenu() {
    Row {
        val modifier = Modifier.weight(0.5f)
        ButtonIcon(
            label = "Peta Rute",
            icon = R.drawable.ic_speaker,
            modifier = modifier
        )
        Spacer(modifier = Modifier.width(16.dp))
        ButtonIcon(
            label = "Iklan",
            icon = R.drawable.ic_play,
            modifier = modifier
        )
    }
}

@Composable
fun ButtonIcon(
    label: String,
    icon: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Black.copy(alpha = 0.7f))
            .fillMaxHeight(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = "Button",
            modifier = Modifier.size(30.dp)
        )
        Text(
            modifier = Modifier.absolutePadding(left = 8.dp),
            text = label,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}
