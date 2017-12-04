package com.cww.sample.kotlin.data.room

object RoomConstant {

    const val DATABASE_SAMPLE = "sample.db"

    const val TABLE_MAIN_LIST = "MainList"
    private const val SELECT_COUNT = "SELECT COUNT(*) FROM "
    private const val SELECT_FROM = "SELECT * FROM "
    private const val SELECT_ORDER_BY = " ORDER BY id DESC"

    const val SELECT_MAIN_LIST_COUNT = SELECT_COUNT + TABLE_MAIN_LIST
    const val SELECT_MAIN_LIST = SELECT_FROM + TABLE_MAIN_LIST + SELECT_ORDER_BY
}
