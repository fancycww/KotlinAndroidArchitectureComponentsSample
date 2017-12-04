package com.cww.sample.kotlin.data.repository

import android.arch.lifecycle.LiveData
import com.cww.sample.kotlin.main.models.MainListItem
import io.reactivex.Flowable


interface IMainListRepository {

    fun getMainListItemCount(): Flowable<Int>

    fun addMainListItems()

    fun getMainList(): LiveData<List<MainListItem>>
}
