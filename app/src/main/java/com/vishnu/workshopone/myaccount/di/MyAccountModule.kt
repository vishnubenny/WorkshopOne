package com.vishnu.workshopone.myaccount.di

import com.vishnu.workshopone.myaccount.MyAccountViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myAccountModule = module {
    viewModel { MyAccountViewModel(get()) }
}