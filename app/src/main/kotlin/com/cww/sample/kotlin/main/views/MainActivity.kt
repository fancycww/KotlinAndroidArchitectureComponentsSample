package com.cww.sample.kotlin.main.views

import android.support.v4.app.Fragment
import com.cww.sample.kotlin.common.base.BaseSingleFragmentActivity

class MainActivity : BaseSingleFragmentActivity() {

    override fun provideFragment(): Fragment {
        return MainFragment.newInstance()
    }
}