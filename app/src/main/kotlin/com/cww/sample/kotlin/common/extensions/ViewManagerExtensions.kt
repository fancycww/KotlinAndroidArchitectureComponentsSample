package com.cww.sample.kotlin.common.extensions

import android.support.annotation.StyleRes
import android.support.design.widget.FloatingActionButton
import android.view.ViewManager
import org.jetbrains.anko.custom.ankoView

inline fun ViewManager.floatingActionButton(@StyleRes theme: Int = 0, init: FloatingActionButton.() -> Unit)
        = ankoView({ FloatingActionButton(it) }, theme, init)
