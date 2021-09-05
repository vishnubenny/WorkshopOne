package com.vishnu.workshopone.home

import androidx.lifecycle.ViewModel
import com.vishnu.workshopone.common.util.SingleLiveEvent

class SharedHomeViewModel : ViewModel() {
    val tapOnComposeHomeActivityEvent = SingleLiveEvent<Any>()
}
