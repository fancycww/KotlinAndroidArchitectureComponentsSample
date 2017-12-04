package com.cww.sample.kotlin.common.base

import android.os.Bundle
import android.support.v4.app.Fragment
import com.cww.sample.kotlin.R
import org.jetbrains.anko.frameLayout
import org.jetbrains.anko.matchParent

abstract class BaseSingleFragmentActivity : BaseActivity() {

    companion object {
        private val ID_CONTAINER = R.id.fragment_container
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupFragmentContainer()
    }

    override fun setupLayout() {
        frameLayout {
            id = ID_CONTAINER
            lparams(width = matchParent, height = matchParent)
        }
    }

    private fun setupFragmentContainer() {
        supportFragmentManager.beginTransaction().replace(ID_CONTAINER, provideFragment()).commit()
    }

    abstract fun provideFragment(): Fragment
}