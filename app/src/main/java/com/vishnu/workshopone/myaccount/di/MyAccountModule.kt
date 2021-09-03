package com.vishnu.workshopone.myaccount.di

import com.vishnu.workshopone.myaccount.UserDataSource
import com.vishnu.workshopone.myaccount.MyAccountViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myAccountModule = module {
    factory { UserDataSource() }
    viewModel { MyAccountViewModel(get(), get()) }
}
