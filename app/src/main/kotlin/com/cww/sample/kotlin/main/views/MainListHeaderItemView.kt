package com.cww.sample.kotlin.main.views

import android.content.Context
import com.cww.sample.kotlin.R
import com.cww.sample.kotlin.common.extensions.color
import org.jetbrains.anko.*


class MainListHeaderItemView : AnkoComponent<Context> {

    override fun createView(ui: AnkoContext<Context>) = with(ui) {
        linearLayout {
            lparams(width = matchParent, height = dimen(160))
            backgroundResource = ctx.color(R.color.colorPrimary)

            textView {
                id = R.id.title
                maxLines = 1
                text = ""
                textSize = 16f
                textColor = ctx.color(android.R.color.white)
                setShadowLayer(4f, 4f, 4f, ctx.color(android.R.color.black))
            }.lparams(width = matchParent, height = wrapContent) {
                topMargin = dip(24)
                leftMargin = dip(16)
                rightMargin = dip(16)
            }
            textView {
                id = R.id.content
                maxLines = 1
                text = ""
                textSize = 14f
                textColor = ctx.color(android.R.color.white)
                setShadowLayer(4f, 4f, 4f, ctx.color(android.R.color.black))
            }.lparams(width = matchParent, height = wrapContent) {
                leftMargin = dip(16)
                rightMargin = dip(16)
            }
        }
    }
}
