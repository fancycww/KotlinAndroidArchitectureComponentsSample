package com.cww.sample.kotlin.main.views

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.cww.sample.kotlin.common.base.BaseViewHolder
import com.cww.sample.kotlin.main.models.MainListItem
import com.cww.sample.kotlin.main.models.MainListViewType
import org.jetbrains.anko.AnkoContext

class MainListAdapter(var mainList: List<MainListItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? =
            when (viewType) {
                MainListViewType.HEADER.ordinal -> {
                    MainListHeaderItemViewHolder(MainListHeaderItemView().createView(AnkoContext.create(parent!!.context)))
                }
                MainListViewType.ITEM.ordinal -> {
                    MainListItemViewHolder(MainListItemView().createView(AnkoContext.create(parent!!.context)))
                }
                else -> {
                    null
                }
            }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val viewHolder = holder as BaseViewHolder?
        viewHolder!!.bind(mainList[position])
    }

    override fun getItemCount(): Int = mainList.size

    override fun getItemViewType(position: Int): Int = mainList[position].viewType.ordinal
}