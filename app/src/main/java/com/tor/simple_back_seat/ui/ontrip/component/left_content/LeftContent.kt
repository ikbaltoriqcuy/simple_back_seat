package com.tor.simple_back_seat.ui.ontrip.component.left_content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tor.simple_back_seat.ui.ontrip.OnTripViewModel
import com.tor.simple_back_seat.ui.viewutils.QRISView

/**
Created by ikbaltoriq on 05,July,2024
 **/


@Composable
fun LeftContent(
    viewModel: OnTripViewModel,
    lat: Double = 0.0,
    long: Double = 0.0,
    modifier: Modifier = Modifier
) {
    val menu = viewModel.menu.collectAsState()
    Column(
        modifier = modifier.padding(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(space = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(size = 8.dp))
                .background(color = Color.White)
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.9f),
            contentAlignment = Alignment.Center
        )
        {
            when(menu.value) {
                OnTripViewModel.ID_QRIS -> QRISView()
                OnTripViewModel.ID_EZ_POINT -> QRISView()
                OnTripViewModel.ID_ROUTE -> OSMMapXML(lat, long)
                OnTripViewModel.ID_ADS -> {}
            }
        }
        VolumeBrightnessControl()
    }
}