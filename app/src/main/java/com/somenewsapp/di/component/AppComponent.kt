package com.somenewsapp.di.component

import com.somenewsapp.di.AppModule
import com.somenewsapp.di.NetworkModule
import com.somenewsapp.ui.FragmentSearchNews
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {
    fun inject(f: FragmentSearchNews)
}