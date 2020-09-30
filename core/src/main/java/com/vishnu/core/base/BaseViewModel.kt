package com.vishnu.core.base

import androidx.lifecycle.ViewModel
import java.lang.ref.WeakReference

open class BaseViewModel<N : BaseNavigator> : ViewModel() {

    private lateinit var navigator: WeakReference<N>

    fun setNavigator(navigator: N) {
        this.navigator = WeakReference(navigator)
    }
}
