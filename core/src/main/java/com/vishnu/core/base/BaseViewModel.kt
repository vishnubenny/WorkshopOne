package com.vishnu.core.base

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import java.lang.ref.WeakReference

open class BaseViewModel<N : BaseNavigator> : ViewModel() {

    private lateinit var navigator: WeakReference<N>

    private val errorHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        handleException(throwable)
    }
    private val errorLiveData = MutableLiveData<ErrorViewState>()

    fun setNavigator(navigator: N) {
        this.navigator = WeakReference(navigator)
    }

    fun viewModelScope(): CoroutineScope {
        return viewModelScope
    }

    fun errorHandler(): CoroutineExceptionHandler = errorHandler
    fun errorLiveData(): MutableLiveData<ErrorViewState> = errorLiveData

    private fun handleException(throwable: Throwable) {
        Log.e("tag", throwable.message, throwable)
        errorLiveData.postValue(ErrorViewState(throwable))
    }
}
