package com.vishnu.workshopone.home

import androidx.lifecycle.MutableLiveData
import com.vishnu.core.base.BaseViewModel
import com.vishnu.core.home.api.ApiUser
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: HomeRepository) : BaseViewModel<HomeNavigator>() {

    val userLiveData = MutableLiveData<ApiUser>()

    fun getUser() {
        setIsLoading()
        viewModelScope().launch(errorHandler()) {
            val user = repository.getUserAsync().await()
            userLiveData.postValue(user)
            setIsLoading(false)
        }
    }
}
