package com.somenewsapp

import android.app.Application
import com.somenewsapp.di.AppModule
import com.somenewsapp.di.component.AppComponent
import com.somenewsapp.di.component.DaggerAppComponent

class SomeNewsApplication: Application() {
    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        context = this
        component = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    companion object {
        lateinit var context: SomeNewsApplication
        fun getNewsApplication(): SomeNewsApplication = context
    }
}