package com.somenewsapp.data.source.remote

import com.somenewsapp.data.model.HeadlineResponse
import com.somenewsapp.network.NewsApiService
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HeadlineRepositoryImpl @Inject constructor(val newsApiService: NewsApiService): HeadlineRepository {

    override fun getTopHeadlines(): Single<HeadlineResponse> {
        return newsApiService.getTopHeadLines()
            .subscribeOn(Schedulers.io())
    }
}