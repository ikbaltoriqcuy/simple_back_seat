package com.tor.simple_back_seat.adsdisplay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.tor.simple_back_seat.R
import com.tor.simple_back_seat.adsdisplay.data.Profile
import com.tor.simple_back_seat.adsdisplay.left_content.Body
import com.tor.simple_back_seat.adsdisplay.left_content.Header
import com.tor.simple_back_seat.adsdisplay.left_content.PaymentItems
import com.tor.simple_back_seat.adsdisplay.left_content.SeekbarItems
import com.tor.simple_back_seat.adsdisplay.navigation.Navigation
import com.tor.simple_back_seat.adsdisplay.right_content.ButtonMenu
import com.tor.simple_back_seat.adsdisplay.right_content.OSMMapXML
import com.tor.simple_back_seat.ui.theme.SimpleBackSeatTheme


class AdsDisplayActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mapPage()
        }
    }
}

@Preview(
    showSystemUi = true,
    device = "spec:" +
            "width=1024dp," +
            "height=600dp," +
            "dpi=420," +
            "isRound=false," +
            "chinSize=0dp," +
            "orientation=landscape"
)
@Composable
private fun mapPage() {
    val lat = -6.246790325844873
    val long = 106.82571194576865
    val profile = Profile(R.drawable.minion, "Aldi Sugiarto", "00667788", "Pembina Utama")

    val gradient = Brush.linearGradient(
        colors = listOf(Color(0xFF005EB8), Color(0xFF337EC6))
    )

    SimpleBackSeatTheme {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .width(1.dp)
                .background(brush = gradient)
                .paint(
                    painter = painterResource(id = R.drawable.bg_page),
                    contentScale = ContentScale.FillWidth
                )
        ) {
            val (navigation, leftContent, rightContent) = createRefs()

            Navigation(Modifier.constrainAs(navigation) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                width = Dimension.percent(0.1f)
                height = Dimension.fillToConstraints
            })

            Column(
                Modifier
                    .constrainAs(leftContent) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(navigation.end)
                        end.linkTo(rightContent.start)
                        width = Dimension.percent(0.4f)
                        height = Dimension.fillToConstraints
                    }
                    .padding(vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Header()
                Body(profile)
                PaymentItems()
                SeekbarItems()
            }

            Column(
                Modifier
                    .constrainAs(rightContent) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(leftContent.end)
                        end.linkTo(parent.end)
                        width = Dimension.percent(0.4f)
                        height = Dimension.fillToConstraints
                    }
                    .padding(vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OSMMapXML(lat, long)
                ButtonMenu()
            }

        }
    }
}