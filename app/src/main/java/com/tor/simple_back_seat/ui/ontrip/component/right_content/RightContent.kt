package com.tor.simple_back_seat.ui.ontrip.component.right_content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tor.simple_back_seat.data.Profile
import com.tor.simple_back_seat.data.ui.ItemCarInfo
import com.tor.simple_back_seat.ui.ontrip.OnTripViewModel

/**
Created by ikbaltoriq on 05,July,2024
 **/

@Composable
fun RightContent(
    viewModel: OnTripViewModel,
    profile: Profile,
    itemsCarInfo: List<ItemCarInfo>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(space = 8.dp)
    ) {
        CustomerInfo()
        CarInfo(profile = profile, itemsCarInfo = itemsCarInfo)
        QuickAccess(viewModel = viewModel)
    }
}