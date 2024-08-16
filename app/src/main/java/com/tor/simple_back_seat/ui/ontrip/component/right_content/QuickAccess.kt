package com.tor.simple_back_seat.ui.ontrip.component.right_content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tor.simple_back_seat.R
import com.tor.simple_back_seat.data.ui.StyleButtonIcon
import com.tor.simple_back_seat.data.ui.StyleButtonIconWithText
import com.tor.simple_back_seat.ui.ontrip.OnTripViewModel

/**
Created by ikbaltoriq on 05,July,2024
 **/

@Composable
fun QuickAccess(viewModel: OnTripViewModel) {

    val menu = viewModel.menu.collectAsState()


    Column(modifier = Modifier.fillMaxHeight()) {
        val weight50 = Modifier.weight(weight = 0.5f)

        Row(modifier = weight50) {
            ButtonIcon(
                style = StyleButtonIcon(
                    id = OnTripViewModel.ID_QRIS,
                    imgResId = R.drawable.ic_qris_black,
                    imgSize = 60.dp
                ),
                modifier = weight50,
                idHighlights = menu.value,
                onClick = {
                    viewModel.setMenu(it)
                }
            )

            Spacer(modifier = Modifier.width(width = 16.dp))

            ButtonIconWithText(
                style = StyleButtonIconWithText(
                    id = OnTripViewModel.ID_EZ_POINT,
                    imgResId = R.drawable.ic_point,
                    imgSize = 40.dp,
                    label = "Point",
                    textColor = if (menu.value == OnTripViewModel.ID_EZ_POINT) Color.White else Color(0xFFFF753F)
                ),
                modifier = weight50,
                idHighlights = menu.value,
                onClick = {
                    viewModel.setMenu(it)
                }
            )
        }

        Spacer(modifier = Modifier.height(height = 8.dp))

        Row(modifier = weight50) {
            ButtonIconWithText(
                style = StyleButtonIconWithText(
                    id = OnTripViewModel.ID_ROUTE,
                    imgResId = R.drawable.ic_route,
                    imgSize = 25.dp,
                    label = "Peta rute",
                    imgColor = ColorFilter.tint(
                        if (menu.value == OnTripViewModel.ID_ROUTE) Color.White
                        else Color(0xFF005EB8)
                    ),
                    textColor =  if (menu.value == OnTripViewModel.ID_ROUTE) Color.White else Color(0xFF005EB8)
                ),
                modifier = weight50,
                idHighlights = menu.value,
                onClick = {
                    viewModel.setMenu(it)
                }
            )

            Spacer(modifier = Modifier.width(width = 16.dp))

            ButtonIconWithText(
                style = StyleButtonIconWithText(
                    id = OnTripViewModel.ID_ADS,
                    imgResId = R.drawable.ic_promo,
                    imgSize = 25.dp,
                    label = "Promo",
                    imgColor = ColorFilter.tint(
                        if (menu.value == OnTripViewModel.ID_ADS) Color.White
                        else Color(0xFF005EB8)
                    ),
                    textColor = if (menu.value == OnTripViewModel.ID_ADS) Color.White else Color(0xFF005EB8)
                ),
                modifier = weight50,
                idHighlights = menu.value,
                onClick = {
                    viewModel.setMenu(it)
                }
            )
        }
    }
}

@Composable
private fun ButtonIcon(
    style: StyleButtonIcon,
    idHighlights: Int,
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit = {}
) {
    val interactionSource = remember { MutableInteractionSource() }
    Row(
        modifier = modifier
            .clip(shape = RoundedCornerShape(size = 8.dp))
            .background(color = (if (style.id == idHighlights) Color.Black.copy(alpha = 0.7f) else Color.White))
            .fillMaxHeight()
            .clickable(
                interactionSource = interactionSource,
                indication = rememberRipple(color = (if (style.id == idHighlights) Color.White else Color.Black))
            ) { onClick.invoke(style.id) },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = style.imgResId),
            contentDescription = "bluebird",
            modifier = Modifier.size(size = style.imgSize),
            colorFilter = ColorFilter.tint(color = (if (style.id == idHighlights) Color.White else Color.Black))
        )
    }
}

@Composable
private fun ButtonIconWithText(
    style: StyleButtonIconWithText,
    idHighlights: Int,
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit = {}
) {
    val interactionSource = remember { MutableInteractionSource() }
    Row(
        modifier = modifier
            .clip(shape = RoundedCornerShape(size = 8.dp))
            .background(color = (if (idHighlights == style.id) Color.Black.copy(alpha = 0.7f) else Color.White))
            .fillMaxHeight()
            .clickable(
                interactionSource = interactionSource,
                indication = rememberRipple(color = (if (idHighlights == style.id) Color.White else Color.Black))
            ) { onClick.invoke(style.id) },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Image(
            painter = painterResource(id = style.imgResId),
            contentDescription = "Payment",
            modifier = Modifier.size(size = style.imgSize),
            colorFilter = style.imgColor,
        )
        Text(
            text = style.label,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = style.textColor,
            modifier = Modifier.absolutePadding(left = 8.dp)
        )
    }
}

