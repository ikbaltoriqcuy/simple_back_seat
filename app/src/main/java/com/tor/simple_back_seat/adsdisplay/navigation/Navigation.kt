package com.tor.simple_back_seat.adsdisplay.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tor.simple_back_seat.R
import com.tor.simple_back_seat.adsdisplay.data.ItemNavigation

/**
Created by ikbaltoriq on 05,July,2024
 **/

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val items = mutableListOf(
        ItemNavigation(R.drawable.ic_bluebird, "Order"),
        ItemNavigation(R.drawable.ic_cinema, "Hiburan"),
    )

    val gradient = Brush.linearGradient(
        colors = listOf(Color(0xFF002253), Color(0xFF0D47A1))
    )

    Column(
        modifier = modifier
            .fillMaxHeight(fraction = 0.2f)
            .background(brush = gradient),
        verticalArrangement = Arrangement.Center,
    ) {
        items.forEach {
            ItemNavigation(it)
        }
    }
}

@Composable
private fun ItemNavigation(item: ItemNavigation) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .padding(bottom = 8.dp),
    ) {
        Box(
            modifier = Modifier
                .width(width = 60.dp)
                .height(height = 60.dp)
                .clip(shape = RoundedCornerShape(size = 8.dp))
                .background(color = Color.White)
        )
        {
            Image(
                painter = painterResource(id = item.icon),
                contentDescription = "Navigation",
                modifier = Modifier
                    .align(alignment = Alignment.Center)
                    .size(size = 40.dp)
            )
        }
        Text(
            text = item.title,
            fontSize = 14.sp,
            modifier = Modifier.width(width = 60.dp),
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}