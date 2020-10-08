package com.vishnu.workshopone.home

import androidx.lifecycle.MutableLiveData
import com.vishnu.core.base.BaseViewModel
import com.vishnu.core.home.api.ApiUser
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: HomeRepository) : BaseViewModel<HomeNavigator>() {

    val isLoadingLiveData = MutableLiveData(false)
    val userLiveData = MutableLiveData<ApiUser>()

    fun getUser() {
        isLoadingLiveData.postValue(true)
        viewModelScope().launch(errorHandler()) {
            val user = repository.getUserAsync().await()
            userLiveData.postValue(user)
            isLoadingLiveData.postValue(false)
        }
    }
}
