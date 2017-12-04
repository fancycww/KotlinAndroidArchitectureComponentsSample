package com.cww.sample.kotlin.common.base

import io.reactivex.disposables.CompositeDisposable

abstract class BaseDisposableFragment : BaseFragment() {

    protected val disposables = CompositeDisposable()

    override fun onDestroyView() {
        super.onDestroyView()
        disposables.dispose()
    }
}