package com.vishnu.workshopone.home

import androidx.lifecycle.MutableLiveData
import com.vishnu.core.base.BaseViewModel
import com.vishnu.core.base.BaseViewState
import com.vishnu.workshopone.home.viewstate.UserViewState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: HomeRepository) : BaseViewModel<HomeNavigator>() {

    val userLiveData = MutableLiveData<UserViewState>()

    fun getUser() {
        viewModelScope().launch {
            repository.getUserAsync()
                .collect { viewState ->
                    setIsLoading(viewState is BaseViewState.Loading)
                    when (viewState) {
                        BaseViewState.Loading -> setIsLoading(true)
                        is BaseViewState.Success<*> -> handleSuccessViewState(viewState)
                        is BaseViewState.Error -> setIsLoading(false, viewState.errorViewState)
                    }
                }
        }
    }

    private fun handleSuccessViewState(viewState: BaseViewState.Success<*>) {
        if (viewState.data is UserViewState) {
            userLiveData.postValue(viewState.data as UserViewState)
        }
        setIsLoading(false)
    }
}
