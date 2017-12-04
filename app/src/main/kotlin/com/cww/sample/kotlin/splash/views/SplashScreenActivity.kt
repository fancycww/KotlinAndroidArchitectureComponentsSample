package com.cww.sample.kotlin.splash.views

import android.os.Bundle
import com.cww.sample.kotlin.R
import com.cww.sample.kotlin.common.base.BaseDisposableActivity
import com.cww.sample.kotlin.main.views.MainActivity
import io.reactivex.Single
import org.jetbrains.anko.*
import java.util.concurrent.TimeUnit

class SplashScreenActivity : BaseDisposableActivity() {

    companion object {
        private val DELAY_MILLISECONDS = 2000L

        init {
            System.loadLibrary("native-lib")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        goToMainActivity()
    }

    override fun setupLayout() {
        relativeLayout {
            imageView(R.drawable.ic_splash_icon) {
                id = R.id.splash_screen_icon
            }.lparams(width = wrapContent) {
                centerInParent()
            }

            textView {
                text = stringFromJNI()
            }.lparams(width = wrapContent) {
                topMargin = dip(16)
                below(R.id.splash_screen_icon)
                centerHorizontally()
            }
        }
    }

    private fun goToMainActivity() {
        disposables.add(Single.timer(DELAY_MILLISECONDS, TimeUnit.MILLISECONDS)
                .subscribe { _, _ ->
                    startActivity<MainActivity>()
                    finish()
                }
        )
    }

    external fun stringFromJNI(): String
}
