package com.u4.distancetracker.ui.maps

import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.SphericalUtil
import java.text.DecimalFormat

object MapUtil {

    fun setCameraPosition(location: LatLng): CameraPosition {
        return CameraPosition.Builder().target(location).zoom(18f).build()
    }

    fun calculateElapsedTime(startTime: Long, stopTime: Long): String {
        val elapsedTime = stopTime - startTime
//        val seconds = (elapsedTime / 1000).toInt() % 60
//        val minutes = (elapsedTime / (1000 * 60) % 60)
//        val hours = (elapsedTime / (1000 * 60 * 60) % 24)
        val seconds = (elapsedTime / 1000).toInt()
        val finalSeconds = seconds % 60
        val minutes = (seconds - finalSeconds) / 60
        val finalMinutes = minutes % 60
        val finalHours = (minutes - finalMinutes) / 60

        return "$finalHours:$finalMinutes:$finalSeconds"
    }

    fun calculateTheDistance(locationList: MutableList<LatLng>): String {
        if (locationList.size > 1) {
            val meters =
                SphericalUtil.computeDistanceBetween(locationList.first(), locationList.last())
            val kilometers = meters / 1000
            return DecimalFormat("#.##").format(kilometers)
        }
        return "0.00"
    }

}