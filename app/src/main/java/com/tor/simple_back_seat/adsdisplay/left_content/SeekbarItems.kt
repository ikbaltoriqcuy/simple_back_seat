package com.tor.simple_back_seat.adsdisplay.left_content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tor.simple_back_seat.R

/**
Created by ikbaltoriq on 05,July,2024
 **/

@Composable
fun SeekbarItems() {
    var sliderPositionSound by remember { mutableStateOf(0f) }
    var sliderPositionBrightness by remember { mutableStateOf(0f) }

    Row(modifier = Modifier.fillMaxHeight()) {

        SeekbarIcon(
            value = sliderPositionSound,
            onValueChange = { sliderPositionSound = it},
            icon = R.drawable.ic_speaker,
            modifier = Modifier.weight(0.5f)
        )

        Spacer(modifier = Modifier.width(16.dp))

        SeekbarIcon(
            value = sliderPositionBrightness,
            onValueChange = { sliderPositionBrightness = it},
            icon = R.drawable.ic_brightness,
            modifier = Modifier.weight(0.5f)
        )
    }
}

@Composable
private fun SeekbarIcon(
    value: Float,
    onValueChange: (Float) -> Unit,
    icon: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color.Black.copy(alpha = 0.7f))
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = "Seekbar",
            modifier = Modifier.size(25.dp)
        )
        Slider(
            colors = SliderDefaults.colors(
                thumbColor = Color.White,
                activeTrackColor = Color.Blue,
                inactiveTrackColor = Color.White
            ),
            value = value,
            onValueChange = onValueChange,
            valueRange = 0f..100f,
            modifier = Modifier
                .absolutePadding(left = 8.dp)
                .fillMaxWidth()
        )
    }
}
