package com.cww.sample.kotlin.common.extensions

import android.content.Context
import android.support.annotation.AttrRes
import android.support.v4.content.ContextCompat
import android.util.TypedValue
import com.cww.sample.kotlin.R
import com.squareup.picasso.Picasso


fun Context.color(res: Int): Int = ContextCompat.getColor(this, res)

val Context.picasso: Picasso
    get() = Picasso.with(this)

val Context.selectableItemBackgroundResource: Int
    get() = getResourceIdAttribute(R.attr.selectableItemBackground)

fun Context.getResourceIdAttribute(@AttrRes attribute: Int): Int {
    val typedValue = TypedValue()
    theme.resolveAttribute(attribute, typedValue, true)
    return typedValue.resourceId
}