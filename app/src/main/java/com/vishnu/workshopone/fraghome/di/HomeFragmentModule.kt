package com.vishnu.workshopone.fraghome.di

import com.vishnu.workshopone.fraghome.HomeFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeFragmentModule = module {
    viewModel { HomeFragmentViewModel() }
}
