package com.somenewsapp.network

import com.somenewsapp.data.HeadlineResponse
import io.reactivex.Single
import retrofit2.http.GET


interface NewsApiService {

    @GET("top-headlines?country=us")
    fun getTopHeadLines(): Single<HeadlineResponse>
}