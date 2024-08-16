package com.tor.simple_back_seat.ui.ontrip.component.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tor.simple_back_seat.R
import com.tor.simple_back_seat.data.ui.ItemNavigation
import com.tor.simple_back_seat.ui.viewutils.Body2

/**
Created by ikbaltoriq on 05,July,2024
 **/

const val ID_ORDER = 0
const val ID_ENTERTAINMENT = 1

@Preview
@Composable
fun Navigation(modifier: Modifier = Modifier) {
    var idHighlights by remember { mutableIntStateOf(0) }

    val items = mutableListOf(
        ItemNavigation(ID_ORDER, R.drawable.icon_taxi, "Order"),
        ItemNavigation(ID_ENTERTAINMENT, R.drawable.ic_cinema, "Hiburan"),
    )

    val gradient = Brush.linearGradient(
        colors = listOf(Color(0xFF002253), Color(0xFF0D47A1))
    )

    Column(
        modifier = modifier
            .fillMaxHeight(fraction = 0.2f)
            .background(brush = gradient),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        items.forEach { itemNavigation ->
            ItemNavigation(itemNavigation, idHighlights) { id ->
                idHighlights = id
            }
        }
    }
}

@Composable
private fun ItemNavigation(item: ItemNavigation, idHighlights: Int, onClick: (Int)-> Unit = {}) {
    val interactionSource = remember { MutableInteractionSource() }
    Column(
        modifier = Modifier.padding(bottom = 8.dp),
    ) {
        Box(
            modifier = Modifier
                .width(width = 60.dp)
                .height(height = 60.dp)
                .clip(shape = RoundedCornerShape(size = 8.dp))
                .background(color = if (idHighlights == item.id) Color.Black.copy(alpha = 0.3f) else Color.White)
                .clickable(
                    interactionSource = interactionSource,
                    indication = rememberRipple(color = Color.Black)
                ) { onClick.invoke(item.id) }
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
        Body2(item.title)
    }
}