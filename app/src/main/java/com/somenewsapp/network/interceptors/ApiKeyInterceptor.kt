package com.somenewsapp.network.interceptors

import com.somenewsapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val oldRequest = chain.request()

        val newUrl = oldRequest.url().newBuilder()
            .addQueryParameter("apiKey", BuildConfig.NewsApiKey).build()

        val builder = oldRequest.newBuilder().url(newUrl)
        val request = builder.build()
        return chain.proceed(request)
    }
}