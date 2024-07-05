package com.tor.simple_back_seat.adsdisplay.right_content

import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.tor.simple_back_seat.R
import com.tor.simple_back_seat.utils.OSMUtils.loadOSM
import com.tor.simple_back_seat.utils.OSMUtils.setupOSM
import org.osmdroid.views.MapView

/**
Created by ikbaltoriq on 05,July,2024
 **/

@Composable
fun OSMMapXML(lat: Double, long: Double) {
    Box(
        Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .fillMaxHeight(0.90f)
    )
    {
        AndroidView(
            factory = { context ->
                context.loadOSM()
                val parent = FrameLayout(context)

                LayoutInflater
                    .from(context)
                    .inflate(R.layout.osm_map, parent, false)
                    .apply {
                        findViewById<MapView>(R.id.map).setupOSM(lat, long)
                    }
            },
            update = {}
        )
    }
}
