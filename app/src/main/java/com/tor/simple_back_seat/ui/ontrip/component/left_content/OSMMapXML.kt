package com.tor.simple_back_seat.ui.ontrip.component.left_content

import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.tor.simple_back_seat.R
import com.tor.simple_back_seat.utils.OSMUtils.loadOSM
import com.tor.simple_back_seat.utils.OSMUtils.setupOSM
import org.osmdroid.views.MapView

/**
Created by ikbaltoriq on 05,July,2024
 **/
@Preview
@Composable
fun OSMMapXML(lat: Double = 0.0, long: Double = 0.0) {
    AndroidView(
        factory = { context ->
            context.loadOSM()

            val parent = FrameLayout(context)

            LayoutInflater
                .from(context)
                .inflate(R.layout.osm_map, parent, false)
                .apply {
                    runCatching {
                        findViewById<MapView>(R.id.map).setupOSM(lat, long)
                    }.onFailure {  }
                }
        },
        update = {}
    )
}
