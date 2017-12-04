package com.cww.sample.kotlin.main.views

import android.view.View
import android.widget.TextView
import com.cww.sample.kotlin.R
import com.cww.sample.kotlin.common.base.BaseViewHolder
import com.cww.sample.kotlin.main.models.MainListItem
import org.jetbrains.anko.find

class MainListHeaderItemViewHolder(itemView: View) : BaseViewHolder(itemView) {
    private val title: TextView = itemView.find(R.id.title)
    private val content: TextView = itemView.find(R.id.content)

    override fun bind(any: Any) {
        val item = any as MainListItem
        title.text = item.title
        content.text = item.content
    }
}