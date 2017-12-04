package com.cww.sample.kotlin.common.base

import android.os.Bundle
import io.reactivex.disposables.CompositeDisposable

abstract class BaseDisposableActivity : BaseActivity() {

    protected val disposables = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupLayout()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
}