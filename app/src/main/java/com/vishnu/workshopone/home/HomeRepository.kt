package com.vishnu.workshopone.home

import com.vishnu.core.home.api.HomeApiFetcher
import com.vishnu.workshopone.home.viewstate.HomeViewState
import com.vishnu.workshopone.home.viewstate.HomeViewStateConverter
import io.reactivex.rxjava3.core.Observable

class HomeRepository(
    private val fetcher: HomeApiFetcher,
    private val converter: HomeViewStateConverter
) {

    suspend fun getUserAsync(): Observable<HomeViewState> {
        return fetcher.getUserAsync()
            .toObservable()
            .map(converter)
            .startWithItem(HomeViewState.Loading)
    }
}
