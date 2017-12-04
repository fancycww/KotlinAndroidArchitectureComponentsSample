package com.cww.sample.kotlin.main.views

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.cww.sample.kotlin.R
import com.cww.sample.kotlin.common.base.BaseViewHolder
import com.cww.sample.kotlin.common.extensions.load
import com.cww.sample.kotlin.main.models.MainListItem
import org.jetbrains.anko.find
import org.jetbrains.anko.imageResource


class MainListItemViewHolder(itemView: View) : BaseViewHolder(itemView) {
    private val icon: ImageView = itemView.find(R.id.icon)
    private val title: TextView = itemView.find(R.id.title)
    private val content: TextView = itemView.find(R.id.content)

    override fun bind(any: Any) {
        val item = any as MainListItem
        title.text = item.title
        content.text = item.content

        if (!item.iconUrl.isNullOrEmpty()) {
            icon.load(item.iconUrl!!) { requestCreator ->
                requestCreator.fit().centerCrop()
            }
        } else {
            icon.imageResource = R.drawable.ic_splash_icon
        }
    }
}