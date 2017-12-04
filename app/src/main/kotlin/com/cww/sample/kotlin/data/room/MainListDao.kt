package com.cww.sample.kotlin.data.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Flowable

@Dao
interface MainListDao {

    @Query(RoomConstant.SELECT_MAIN_LIST_COUNT)
    fun getMainListItemCount(): Flowable<Int>

    @Insert
    fun insertAll(list: List<MainListEntity>)

    @Query(RoomConstant.SELECT_MAIN_LIST)
    fun getAllMainList(): Flowable<List<MainListEntity>>
}

