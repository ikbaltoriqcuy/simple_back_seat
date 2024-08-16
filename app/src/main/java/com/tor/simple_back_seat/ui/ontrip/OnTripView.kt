package com.tor.simple_back_seat.ui.ontrip

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.tor.simple_back_seat.R
import com.tor.simple_back_seat.data.Profile
import com.tor.simple_back_seat.data.ui.ItemCarInfo
import com.tor.simple_back_seat.ui.ontrip.component.left_content.LeftContent
import com.tor.simple_back_seat.ui.ontrip.component.navigation.Navigation
import com.tor.simple_back_seat.ui.ontrip.component.right_content.RightContent
import com.tor.simple_back_seat.utils.ViewUtils.linkConstraints
import com.tor.simple_back_seat.utils.ViewUtils.size
import org.koin.androidx.compose.koinViewModel

/**
Created by ikbaltoriq on 16,July,2024
 **/


val tempItemsCarInfo = listOf(
    ItemCarInfo(
        R.drawable.ic_info_taxi, "No. Taksi", "ABC123"
    ), ItemCarInfo(
        R.drawable.ic_distance, "Jarak", "05.2 km"
    ), ItemCarInfo(
        R.drawable.ic_clock, "Durasi", "00:12:34"
    ), ItemCarInfo(
        R.drawable.ic_cash, "Tarif", "Rp100.000"
    )
)

@Preview(showSystemUi = true, device = Devices.TABLET)
@Composable
fun DefaultPreview() {
    OnTripPage()
}

@Composable
fun OnTripPage(viewModel: OnTripViewModel = koinViewModel()) {

    val lat = -6.246790325844873
    val long = 106.82571194576865
    val profile = Profile(R.drawable.minion, "Aldi Sugiarto", "00667788", "Pembina Utama")

    val gradient = Brush.linearGradient(
        colors = listOf(Color(0xFF005EB8), Color(0xFF337EC6))
    )

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .width(width = 1.dp)
            .background(brush = gradient)
            .paint(
                painter = painterResource(id = R.drawable.bg_page),
                contentScale = ContentScale.FillWidth
            )
    ) {
        val (navigation, leftContent, rightContent) = createRefs()

        val navigationModifier = Modifier.constrainAs(navigation) {
            this.linkConstraints(end = null)
            this.size(width = Dimension.percent(0.1f), height = Dimension.fillToConstraints)
        }

        val leftContentModifier = Modifier.constrainAs(leftContent) {
            this.linkConstraints(start = navigation.end, end = rightContent.start)
            this.size(width = Dimension.percent(0.4f), height = Dimension.fillToConstraints)
        }

        val rightContentModifier = Modifier.constrainAs(rightContent) {
            this.linkConstraints(start = leftContent.end)
            this.size(width = Dimension.percent(0.4f), height = Dimension.fillToConstraints)
        }

        Navigation(modifier = navigationModifier)
        LeftContent(
            viewModel = viewModel,
            lat = lat,
            long = long,
            modifier = leftContentModifier
        )
        RightContent(
            viewModel = viewModel,
            profile = profile,
            itemsCarInfo = tempItemsCarInfo,
            modifier = rightContentModifier
        )
    }
}
