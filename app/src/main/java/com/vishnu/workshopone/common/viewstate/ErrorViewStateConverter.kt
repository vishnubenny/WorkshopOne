package com.vishnu.workshopone.common.viewstate

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableSource
import io.reactivex.rxjava3.core.ObservableTransformer

class ErrorViewStateConverter : ObservableTransformer<ResponseViewState, ResponseViewState> {

    override fun apply(upstream: Observable<ResponseViewState>): ObservableSource<ResponseViewState> {
        return upstream.onErrorResumeNext {
            Observable.just(ResponseViewState.Error)
        }
    }
}
