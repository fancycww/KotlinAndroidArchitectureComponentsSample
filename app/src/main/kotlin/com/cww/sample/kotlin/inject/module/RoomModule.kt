package com.cww.sample.kotlin.inject.module

import android.content.Context
import com.cww.sample.kotlin.data.repository.MainListRepository
import com.cww.sample.kotlin.data.room.MainListDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideRoomMainListDataSource(context: Context) = MainListDataSource.buildPersistentMainList(context)

    @Provides
    @Singleton
    fun provideRoomMainListRepository(mainListDataSource: MainListDataSource) = MainListRepository(mainListDataSource)
}
