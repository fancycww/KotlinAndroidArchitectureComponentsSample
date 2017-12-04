package com.cww.sample.kotlin.data.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.cww.sample.kotlin.data.room.MainListDataSource
import com.cww.sample.kotlin.data.room.MainListEntity
import com.cww.sample.kotlin.main.models.MainListItem
import com.cww.sample.kotlin.main.models.MainListViewType
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainListRepository @Inject constructor(private val mainListDataSource: MainListDataSource) : IMainListRepository {

    override fun getMainListItemCount() = mainListDataSource.mainListDao().getMainListItemCount()

    override fun addMainListItems() {
        getMainListItemCount().take(1).subscribe { count ->
            val entityList = MainListDataSource.getAllMainList(count)
            mainListDataSource.mainListDao().insertAll(entityList)
        }
    }

    override fun getMainList(): LiveData<List<MainListItem>> {
        val mainListDao = mainListDataSource.mainListDao()
        val mutableLiveData = MutableLiveData<List<MainListItem>>()
        mainListDao.getAllMainList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { list ->
                    mutableLiveData.value = transform(list)
                }

        return mutableLiveData
    }

    private fun transform(listEntities: List<MainListEntity>): List<MainListItem> {
        val list = ArrayList<MainListItem>()
        listEntities.forEach {
            list.add(MainListItem(0, it.title, it.content, it.iconUrl, MainListViewType.ITEM))
        }
        return list
    }
}
