package com.cww.sample.kotlin.data.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(MainListEntity::class), version = 1)
abstract class MainListDataSource : RoomDatabase() {

    abstract fun mainListDao(): MainListDao

    companion object {
        fun buildPersistentMainList(context: Context): MainListDataSource =
                Room.databaseBuilder(
                        context.applicationContext,
                        MainListDataSource::class.java,
                        RoomConstant.DATABASE_SAMPLE
                ).build()

        fun getAllMainList(index: Int): List<MainListEntity> {
            val mutableMainList = mutableListOf<MainListEntity>()
            mutableMainList.add(createMainListEntity(
                    "Awesome Icons " + index,
                    "Font Awesome delivers with 41 shiny new icons in version 4.7. Want to request new icons? Here's how.",
                    "https://assets.servedby-buysellads.com/p/manage/asset/id/28536"))
            return mutableMainList
        }

        private fun createMainListEntity(title: String, content: String?, iconUrl: String?) =
                MainListEntity(0, title, content, iconUrl)
    }
}

