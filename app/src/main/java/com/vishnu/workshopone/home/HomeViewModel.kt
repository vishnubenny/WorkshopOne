package com.vishnu.workshopone.home

import androidx.lifecycle.MutableLiveData
import com.vishnu.core.base.BaseViewModel
import com.vishnu.workshopone.home.viewstate.UserViewState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: HomeRepository) : BaseViewModel<HomeNavigator>() {

    val userLiveData = MutableLiveData<UserViewState>()

    fun getUser() {
        setIsLoading()
        viewModelScope().launch(errorHandler()) {
            repository.getUserAsync().collect {
                userLiveData.postValue(it)
                setIsLoading(false)
            }
        }
    }
}
