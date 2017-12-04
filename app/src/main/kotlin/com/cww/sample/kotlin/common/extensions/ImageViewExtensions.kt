package com.cww.sample.kotlin.common.extensions

import android.widget.ImageView
import com.squareup.picasso.RequestCreator

fun ImageView.load(path: String, request: (RequestCreator) -> RequestCreator) {
    request(context.picasso.load(path)).into(this)
}
