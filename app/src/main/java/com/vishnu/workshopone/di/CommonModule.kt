package com.vishnu.workshopone.di

import com.vishnu.core.base.ErrorViewStateConverter
import org.koin.dsl.module

val commonModule = module {
    factory { ErrorViewStateConverter() }
}
