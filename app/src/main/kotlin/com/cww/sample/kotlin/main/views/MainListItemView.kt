package com.cww.sample.kotlin.main.views

import android.content.Context
import android.text.TextUtils
import com.cww.sample.kotlin.R
import com.cww.sample.kotlin.common.extensions.color
import com.cww.sample.kotlin.common.extensions.selectableItemBackgroundResource
import org.jetbrains.anko.*


class MainListItemView : AnkoComponent<Context> {

    override fun createView(ui: AnkoContext<Context>) = with(ui) {
        relativeLayout {
            lparams(width = matchParent, height = wrapContent)
            backgroundResource = context.selectableItemBackgroundResource
            isClickable = true

            val icon = imageView(R.drawable.ic_splash_icon) {
                id = R.id.icon
            }.lparams(width = dip(60), height = dip(60)) {
                margin = dip(16)
            }

            val name = textView {
                id = R.id.title
                maxLines = 1
                text = ""
                textSize = 16f
                textColor = ctx.color(android.R.color.black)
            }.lparams(width = matchParent, height = wrapContent) {
                rightOf(icon)
                topMargin = dip(16)
                leftMargin = dip(16)
                rightMargin = dip(16)
            }
            textView {
                id = R.id.content
                maxLines = 2
                ellipsize = TextUtils.TruncateAt.END
                text = ""
                textSize = 14f
                textColor = ctx.color(android.R.color.darker_gray)
            }.lparams(width = matchParent, height = wrapContent) {
                rightOf(icon)
                below(name)
                leftMargin = dip(16)
                rightMargin = dip(16)
            }
        }
    }
}