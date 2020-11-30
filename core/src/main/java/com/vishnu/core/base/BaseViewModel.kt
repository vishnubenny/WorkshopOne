package com.vishnu.core.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import java.lang.ref.WeakReference

open class BaseViewModel<N : BaseNavigator> : ViewModel() {

    val isLoading = MutableLiveData(false)

    private lateinit var navigator: WeakReference<N>

    fun setNavigator(navigator: N) {
        this.navigator = WeakReference(navigator)
    }

    fun navigator(): N? = navigator.get()

    fun viewModelScope(): CoroutineScope {
        return viewModelScope
    }

    fun setIsLoading(isLoading: Boolean = true) {
        this.isLoading.postValue(isLoading)
    }

}
