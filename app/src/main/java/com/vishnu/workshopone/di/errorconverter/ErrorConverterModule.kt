package com.vishnu.workshopone.di.errorconverter

import com.vishnu.workshopone.common.viewstate.ErrorViewStateConverter
import org.koin.dsl.module

val errorConverterModule = module {
    factory { ErrorViewStateConverter() }
}
