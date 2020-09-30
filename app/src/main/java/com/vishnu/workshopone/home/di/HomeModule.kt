package com.vishnu.workshopone.home.di

import com.vishnu.workshopone.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    viewModel { HomeViewModel() }
}
