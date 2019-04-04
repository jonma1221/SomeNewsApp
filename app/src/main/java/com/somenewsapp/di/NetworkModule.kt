package com.somenewsapp.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.somenewsapp.network.NewsApiService
import com.somenewsapp.network.interceptors.ApiKeyInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object {
        private const val BASE_URL = "https://newsapi.org/"
        private const val VERSION  = "v2/"
    }

    @Singleton
    @Provides
    fun providesGson(): Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }

    @Singleton
    @Provides
    fun providesOkHttpClient(): OkHttpClient{
        val builder = OkHttpClient.Builder()
        builder.apply {
            addInterceptor(ApiKeyInterceptor())
            addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        }
        return builder.build()
    }

    @Singleton
    @Provides
    fun providesRetrofit(client: OkHttpClient, gson: Gson): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL + VERSION)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesNewsApiService(retrofit: Retrofit): NewsApiService{
        return retrofit.create(NewsApiService::class.java)
    }
}