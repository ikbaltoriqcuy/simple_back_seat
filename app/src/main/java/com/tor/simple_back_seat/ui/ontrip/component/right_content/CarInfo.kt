package com.tor.simple_back_seat.ui.ontrip.component.right_content

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tor.simple_back_seat.data.Profile
import com.tor.simple_back_seat.data.ui.ItemCarInfo
import com.tor.simple_back_seat.ui.viewutils.Body1
import com.tor.simple_back_seat.ui.viewutils.SubTitle2
import com.tor.simple_back_seat.ui.viewutils.SubTitleBold1

/**
Created by ikbaltoriq on 05,July,2024
 **/


@Composable
fun CarInfo(profile: Profile, itemsCarInfo: List<ItemCarInfo> = listOf()) {
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(size = 8.dp))
            .background(color = Color.Black.copy(alpha = 0.7f))
            .padding(horizontal = 32.dp, vertical = 24.dp)
            .fillMaxHeight(fraction = 0.62f)
    ) {
        Column {
            Profile(profile = profile)
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
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
private fun Profile(profile: Profile, modifier: Modifier = Modifier) {
    Row {
        Box(
            modifier = modifier
                .size(size = 70.dp)
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
            SubTitleBold1(label = profile.name)
            SubTitle2(label = "NIP: ${profile.nip}")
        }
    }
}

@Composable
private fun ItemCarInfo(data: ItemCarInfo, modifier: Modifier = Modifier) {
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
                SubTitleBold1(label = data.valueInfo)
            }
        }
    }
}
