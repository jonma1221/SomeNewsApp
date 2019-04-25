package com.somenewsapp.ui

import android.app.Application
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.somenewsapp.R
import com.somenewsapp.SomeNewsApplication
import com.somenewsapp.network.NewsApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FragmentSearchNews: Fragment() {

    @Inject lateinit var newsService:NewsApiService

    companion object {
        fun newInstance(): FragmentSearchNews{
            val f = FragmentSearchNews()
            val args = Bundle()
            f.arguments = args
            return f
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        SomeNewsApplication.getNewsApplication().component.inject(this)

        //todo - remove this
        newsService.getTopHeadLines()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response -> Log.d("Success", response.status) },
                { error -> Log.d("Error", error.message)}
            )
    }
}