package com.cww.sample.kotlin.inject.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
//import com.cww.sample.kotlin.inject.ApplicationContext

import dagger.Module
import dagger.Provides

@Module
class AppModule(private val mApplication: Application) {

    @Provides
    internal fun provideContext(): Context {
        return mApplication
    }

    @Provides
    internal fun provideApplication(): Application {
        return mApplication
    }

    //    @Provides
    //    @DatabaseInfo
    //    String provideDatabaseName() {
    //        return "demo-dagger.db";
    //    }
    //
    //    @Provides
    //    @DatabaseInfo
    //    Integer provideDatabaseVersion() {
    //        return 2;
    //    }

//    @Provides
//    internal fun provideSharedPrefs(): SharedPreferences {
//        return mApplication.getSharedPreferences("demo-prefs", Context.MODE_PRIVATE)
//    }
}
