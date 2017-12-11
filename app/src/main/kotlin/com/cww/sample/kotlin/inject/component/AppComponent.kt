package com.cww.sample.kotlin.inject.component

import com.cww.sample.kotlin.SampleApplication
import com.cww.sample.kotlin.inject.module.AppModule
import com.cww.sample.kotlin.inject.module.RoomModule
import com.cww.sample.kotlin.main.viewmodels.MainViewModel
import com.cww.sample.kotlin.main.views.MainActivity

import javax.inject.Singleton

import dagger.Component

@Component(modules = arrayOf(AppModule::class, RoomModule::class))
@Singleton
interface AppComponent {

    fun inject(application: SampleApplication)

    fun inject(activity: MainActivity)

    fun inject(model: MainViewModel)
}
