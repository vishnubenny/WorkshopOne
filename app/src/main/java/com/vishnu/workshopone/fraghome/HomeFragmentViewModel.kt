package com.vishnu.workshopone.fraghome

import com.vishnu.core.base.BaseViewModel
import com.vishnu.workshopone.common.util.SingleLiveEvent

class HomeFragmentViewModel : BaseViewModel<HomeFragmentNavigator>() {

    private val showFragment2Event = SingleLiveEvent<Any>()

    fun showFragment2Event(): SingleLiveEvent<Any> = showFragment2Event

    fun onShowFragment2Clicked() {
        showFragment2Event.call()
    }
}
