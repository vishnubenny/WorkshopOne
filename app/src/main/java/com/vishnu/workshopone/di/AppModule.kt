package com.vishnu.workshopone.di

import com.vishnu.workshopone.di.network.networkModule
import com.vishnu.workshopone.fraghome.di.homeFragmentModule
import com.vishnu.workshopone.home.di.homeModule
import com.vishnu.workshopone.myaccount.di.myAccountModule

val appModule = listOf(
    networkModule,
    commonModule,
    homeModule,
    homeFragmentModule,
    myAccountModule
)
