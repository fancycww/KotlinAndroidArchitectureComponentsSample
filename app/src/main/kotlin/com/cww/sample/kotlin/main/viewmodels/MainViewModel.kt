package com.cww.sample.kotlin.main.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.cww.sample.kotlin.SampleApplication
import com.cww.sample.kotlin.data.repository.MainListRepository
import com.cww.sample.kotlin.main.models.MainListItem
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import javax.inject.Inject

class MainViewModel : ViewModel(), AnkoLogger {

    @Inject lateinit var repository: MainListRepository
    private var liveMainData: LiveData<List<MainListItem>>? = null

    init {
        initializeDagger()
        loadMainList()
    }

    private fun initializeDagger() = SampleApplication.appComponent.inject(this)

    private fun loadMainList() {
        liveMainData = repository.getMainList()
    }

    fun addMainListItem() {
        populate()
    }

    fun getMainList(): LiveData<List<MainListItem>>? = liveMainData

    private fun populate() {
        Completable.fromAction { repository.addMainListItems() }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : CompletableObserver {
                    override fun onSubscribe(@NonNull d: Disposable) {
                    }

                    override fun onComplete() {
                        info("DataSource has been Populated")
                    }

                    override fun onError(@NonNull e: Throwable) {
                        e.printStackTrace()
                        info("DataSource hasn't been Populated")
                    }
                })
    }
}
