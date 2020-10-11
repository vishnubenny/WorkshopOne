package com.vishnu.workshopone.home.di

import com.vishnu.core.home.api.HomeApiFetcher
import com.vishnu.core.home.api.HomeBackend
import com.vishnu.workshopone.home.HomeRepository
import com.vishnu.workshopone.home.HomeViewModel
import com.vishnu.workshopone.home.viewstate.BiUserConverter
import com.vishnu.workshopone.home.viewstate.UserViewStateConverter
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val homeModule = module {
    factory { provideBackend(get()) }
    factory { HomeApiFetcher(get()) }
    factory { UserViewStateConverter() }
    factory { BiUserConverter() }
    factory { HomeRepository(get(), get(), get(), get()) }
    viewModel { HomeViewModel(get()) }
}

private fun provideBackend(builder: Retrofit.Builder): HomeBackend {
    return builder.build()
        .create(HomeBackend::class.java)
}
