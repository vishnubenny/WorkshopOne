package com.vishnu.workshopone.fraghome

import com.vishnu.core.base.BaseViewModel
import com.vishnu.workshopone.common.util.SingleLiveEvent

class HomeFragmentViewModel : BaseViewModel<HomeFragmentNavigator>() {

    val event = SingleLiveEvent<Any>()

    fun onShowFragment2Clicked() {
        event.call()
    }
}
