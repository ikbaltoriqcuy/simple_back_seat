package com.tor.simple_back_seat.adsdisplay.right_content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
Created by ikbaltoriq on 05,July,2024
 **/

@Composable
fun RightContent(lat: Double, long: Double, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(space = 8.dp)
    ) {
        OSMMapXML(lat, long)
        ButtonMenu()
    }
}