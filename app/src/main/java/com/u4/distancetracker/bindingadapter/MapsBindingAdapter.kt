package com.u4.distancetracker.bindingadapter

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.databinding.BindingAdapter

class MapsBindingAdapter {
    companion object {
        @BindingAdapter("android:observeTracking")
        @JvmStatic
        fun observeTracking(view: View, started: Boolean) {
            when (view) {
                is Button -> {
                    view.visibility = if (started) View.VISIBLE else View.INVISIBLE
                }
                is TextView -> {
                    view.visibility = if (started) View.INVISIBLE else View.VISIBLE
                }
            }
        }
    }
}