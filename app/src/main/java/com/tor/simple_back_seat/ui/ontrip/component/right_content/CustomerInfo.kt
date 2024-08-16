package com.tor.simple_back_seat.ui.ontrip.component.right_content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tor.simple_back_seat.R
import com.tor.simple_back_seat.ui.viewutils.Body2
import com.tor.simple_back_seat.ui.viewutils.SubTitleBold1

/**
Created by ikbaltoriq on 05,July,2024
 **/

@Preview
@Composable
fun CustomerInfo() {
    Box {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(size = 8.dp))
                .background(color = Color.Black.copy(alpha = 0.7f))
                .padding(horizontal = 32.dp, vertical = 8.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon_badge),
                contentDescription = "bluebird",
                modifier = Modifier.size(size = 60.dp)
            )
            Column(modifier = Modifier.padding(top = 8.dp)) {
                SubTitleBold1(label = "Halo Heruyan!")
                Body2(label = "Kamu Memiliki 116.000 EZPoint", modifier = Modifier.padding(top = 4.dp))
            }
        }
    }
}
