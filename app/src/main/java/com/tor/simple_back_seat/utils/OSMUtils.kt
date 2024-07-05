package com.tor.simple_back_seat.utils

import android.content.Context
import android.preference.PreferenceManager
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

/**
Created by ikbaltoriq on 03,August,2023
 **/

object OSMUtils {

    private const val LOG_LOAD_OSM = "load OSM"
    private const val LOG_SETUP_OSM = "setup OSM "

    fun Context.loadOSM() {
        Configuration
            .getInstance()
            .load(this, PreferenceManager.getDefaultSharedPreferences(this))
    }

    fun MapView.setupOSM(lat: Double, long: Double) {
        val startMarker = Marker(this)
        val mapController = controller
        val startPoint = GeoPoint(lat, long)

        setBuiltInZoomControls(true)
        setMultiTouchControls(true)

        mapController.apply {
            setZoom(18.0)
            setCenter(startPoint)
        }

        startMarker.apply {
            position = startPoint
            setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
            setOnMarkerClickListener { marker, _ ->
                marker.infoWindow.close()
                true

            }
        }
        overlays.add(startMarker)
    }
}