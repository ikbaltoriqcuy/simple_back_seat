package com.tor.simple_back_seat.adsdisplay.left_content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tor.simple_back_seat.R
import com.tor.simple_back_seat.adsdisplay.data.ItemCarInfo
import com.tor.simple_back_seat.adsdisplay.data.Profile

/**
Created by ikbaltoriq on 05,July,2024
 **/


val itemsCarInfo = listOf(
    ItemCarInfo(
        R.drawable.ic_info_taxi,
        "No. Taksi",
        "ABC123"
    ),
    ItemCarInfo(
        R.drawable.ic_distance,
        "Jarak",
        "05.2 km"
    ),
    ItemCarInfo(
        R.drawable.ic_clock,
        "Durasi",
        "00:12:34"
    ),
    ItemCarInfo(
        R.drawable.ic_cash,
        "Tarif",
        "Rp100.000"
    )
)


@Composable
fun Body(profile: Profile) {
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(size = 8.dp))
            .background(color = Color.Black.copy(alpha = 0.7f))
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxHeight(fraction = 0.7f)
    ) {
        Column {
            Profile(profile = profile)
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 128.dp),
                content = {
                    items(itemsCarInfo.size) {
                        ItemCarInfo(
                            data = itemsCarInfo[it],
                            modifier = Modifier.absolutePadding(top = 32.dp)
                        )
                    }
                })
        }
    }
}

@Composable
private fun Profile(profile: Profile) {
    Row {
        Box(
            modifier = Modifier
                .size(size = 80.dp)
                .clip(shape = CircleShape)
                .background(color = Color.White)
                .align(alignment = Alignment.CenterVertically)
        ) {
            Image(
                painter = painterResource(id = profile.imgProfile),
                contentDescription = "Profile",
                modifier = Modifier.size(size = 80.dp)
            )
        }
        Column {
            SubTitle2(label = profile.position)
            SubTitle1(label = profile.name)
            SubTitle2(label = "NIP: ${profile.nip}")
        }
    }
}

@Composable
private fun ItemCarInfo(data: ItemCarInfo, modifier: Modifier) {
    Box(modifier = modifier) {
        Row {
            Box(
                modifier = Modifier
                    .size(size = 50.dp)
                    .clip(shape = CircleShape)
                    .background(color = Color.White),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = data.icon),
                    contentDescription = "Car Info",
                    modifier = Modifier.size(size = 30.dp)
                )
            }
            Column {
                Body1(label = data.titleInfo)
                SubTitle1(label = data.valueInfo)
            }
        }
    }
}

// components

@Composable
private fun SubTitle1(label: String) {
    Text(
        text = label,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        modifier = Modifier.absolutePadding(left = 8.dp)
    )
}

@Composable
private fun SubTitle2(label: String) {
    Text(
        text = label,
        fontSize = 15.sp,
        textAlign = TextAlign.Center,
        color = Color.White,
        modifier = Modifier.absolutePadding(left = 8.dp)
    )
}

@Composable
private fun Body1(label: String) {
    Text(
        text = label,
        fontSize = 12.sp,
        textAlign = TextAlign.Center,
        color = Color.White,
        modifier = Modifier.absolutePadding(left = 8.dp)
    )
}
