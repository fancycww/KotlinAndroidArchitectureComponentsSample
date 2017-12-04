package com.cww.sample.kotlin

import android.app.Application
import com.cww.sample.kotlin.inject.component.AppComponent
import com.cww.sample.kotlin.inject.component.DaggerAppComponent
import com.cww.sample.kotlin.inject.module.AppModule
import com.cww.sample.kotlin.inject.module.RoomModule

class SampleApplication : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }

    private fun initializeDagger() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .roomModule(RoomModule())/*
                .remoteModule(RemoteModule())*/.build()
    }
}

