package com.vishnu.workshopone.di

import com.vishnu.workshopone.di.errorconverter.errorConverterModule
import com.vishnu.workshopone.di.network.networkModule
import com.vishnu.workshopone.home.di.homeModule

val appModule = listOf(
    networkModule,
    errorConverterModule,
    homeModule
)
