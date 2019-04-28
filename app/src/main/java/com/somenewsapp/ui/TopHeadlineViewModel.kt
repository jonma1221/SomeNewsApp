package com.somenewsapp.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.somenewsapp.data.model.ArticlesItem
import com.somenewsapp.data.model.HeadlineResponse
import com.somenewsapp.data.source.remote.HeadlineRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class TopHeadlineViewModel @Inject constructor(repository: HeadlineRepository) : ViewModel() {

    val headlineList = MutableLiveData<List<ArticlesItem>>()
    val compositeDisposable: CompositeDisposable = CompositeDisposable()
}