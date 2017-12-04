package com.cww.sample.kotlin.data.room

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = RoomConstant.TABLE_MAIN_LIST)
data class MainListEntity(
        @PrimaryKey(autoGenerate = true) val id: Long,
        var title: String,
        var content: String?,
        var iconUrl: String?
)
