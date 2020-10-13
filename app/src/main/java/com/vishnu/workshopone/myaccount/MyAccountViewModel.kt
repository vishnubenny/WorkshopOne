package com.vishnu.workshopone.myaccount

import androidx.lifecycle.MutableLiveData
import com.vishnu.core.base.BaseViewModel
import com.vishnu.core.base.BaseViewState
import com.vishnu.workshopone.home.HomeRepository
import com.vishnu.workshopone.home.viewstate.UserViewState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MyAccountViewModel(private val repository: HomeRepository) :
    BaseViewModel<MyAccountNavigator>() {

    val userViewStateData = MutableLiveData<UserViewState>()

    fun getUser() {
        viewModelScope().launch {
            repository.getUserAsync()
                .collect { viewState ->
                    when (viewState) {
                        BaseViewState.Loading -> setIsLoading()
                        is BaseViewState.Success<*> -> if (viewState.data is UserViewState) {
                            userViewStateData.postValue(viewState.data as UserViewState)
                            setIsLoading(false)
                        }
                        is BaseViewState.Error -> setIsLoading(false)
                    }
                }
        }
    }
}
