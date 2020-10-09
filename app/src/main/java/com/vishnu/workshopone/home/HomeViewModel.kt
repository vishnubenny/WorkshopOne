package com.vishnu.workshopone.home

import androidx.lifecycle.MutableLiveData
import com.vishnu.core.base.BaseViewModel
import com.vishnu.core.base.BaseViewState
import com.vishnu.workshopone.home.viewstate.UserViewState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: HomeRepository) : BaseViewModel<HomeNavigator>() {

    val userLiveData = MutableLiveData<UserViewState>()

    @ExperimentalCoroutinesApi
    fun getUser() {
        viewModelScope().launch(errorHandler()) {
            repository.getUserAsync()
                .collect {
                    setIsLoading(it is BaseViewState.Loading)
                    if (it is BaseViewState.Success<*> && it.data is UserViewState) {
                        userLiveData.postValue(it.data as UserViewState)
                    }
                }
        }
    }
}
