package com.vishnu.workshopone.home

import com.vishnu.core.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: HomeRepository) : BaseViewModel<HomeNavigator>() {

    fun getUser() {
        viewModelScope().launch(Dispatchers.IO) {
            repository.getUserAsync()
                .subscribe { println(it) }
        }
    }
}
