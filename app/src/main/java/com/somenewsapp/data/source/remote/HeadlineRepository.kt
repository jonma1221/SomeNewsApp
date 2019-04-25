package com.somenewsapp.data.source.remote

import com.somenewsapp.data.model.HeadlineResponse
import io.reactivex.Single

interface HeadlineRepository {

    fun getTopHeadlines() : Single<HeadlineResponse>
}