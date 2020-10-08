package com.vishnu.workshopone.common.util

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.databinding.BindingAdapter

class BindingHelper {

    companion object {

        @BindingAdapter("isVisible")
        @JvmStatic
        fun isVisible(view: View, isVisible: Boolean) {
            view.visibility = when {
                isVisible -> VISIBLE
                else -> GONE
            }
        }
    }
}
