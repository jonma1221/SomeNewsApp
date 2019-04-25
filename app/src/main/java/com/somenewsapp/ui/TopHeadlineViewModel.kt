package com.somenewsapp.ui

import android.arch.lifecycle.ViewModel
import com.somenewsapp.data.source.remote.HeadlineRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class TopHeadlineViewModel @Inject constructor(repository: HeadlineRepository) : ViewModel() {

    val compositeDisposable: CompositeDisposable = CompositeDisposable()
}