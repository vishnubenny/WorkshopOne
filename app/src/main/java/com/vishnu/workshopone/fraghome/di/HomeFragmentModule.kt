package com.vishnu.workshopone.fraghome.di

import android.os.Build
import androidx.annotation.RequiresApi
import com.vishnu.workshopone.fraghome.HomeFragmentViewModel
import com.vishnu.workshopone.jobscheduler.SampleJobService
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
val homeFragmentModule = module {
    factory { SampleJobService() }
    viewModel { HomeFragmentViewModel(get()) }
}
