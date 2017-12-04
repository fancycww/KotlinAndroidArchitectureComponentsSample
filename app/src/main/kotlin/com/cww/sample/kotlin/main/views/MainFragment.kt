package com.cww.sample.kotlin.main.views

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.res.ColorStateList
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.cww.sample.kotlin.common.extensions.color
import com.cww.sample.kotlin.R
import com.cww.sample.kotlin.common.base.BaseDisposableFragment
import com.cww.sample.kotlin.common.extensions.floatingActionButton
import com.cww.sample.kotlin.main.models.MainListItem
import com.cww.sample.kotlin.main.viewmodels.MainViewModel
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.swipeRefreshLayout
import org.jetbrains.anko.support.v4.toast

class MainFragment : BaseDisposableFragment() {

    companion object {
        fun newInstance(): MainFragment {
            val arguments = Bundle()
            val fragment = MainFragment()
            fragment.arguments = arguments
            return fragment
        }
    }

    private var swipeRefreshLayout: SwipeRefreshLayout? = null
    private lateinit var listAdapter: MainListAdapter
    private lateinit var viewModel: MainViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        bindViewsToViewModel()
    }

    override fun setupLayout(): View? {
        listAdapter = MainListAdapter(emptyList())
        return UI {
            relativeLayout {
                lparams(width = matchParent, height = matchParent)

                swipeRefreshLayout = swipeRefreshLayout {
                    id = R.id.swipe_refresh_layout
                    setColorSchemeResources(
                            android.R.color.holo_blue_bright,
                            android.R.color.holo_green_light,
                            android.R.color.holo_orange_light,
                            android.R.color.holo_red_light)
                    setProgressBackgroundColorSchemeColor(0x7fffffff)
                    onRefresh {
                        refresh()
                    }
                    recyclerView {
                        id = R.id.menu_list
                        lparams(width = matchParent, height = matchParent)
                        layoutManager = LinearLayoutManager(ctx)
                        adapter = listAdapter
                        addItemDecoration(DividerItemDecoration(ctx, LinearLayoutManager.VERTICAL))
                    }
                }

                floatingActionButton {
                    id = R.id.floating_action_button_settings
                    imageResource = R.drawable.ic_add_24dp
                    backgroundTintList = ColorStateList.valueOf(ctx.color(android.R.color.white))
                }.lparams {
                    rightMargin = dip(16)
                    bottomMargin = dip(16)
                    alignParentRight()
                    alignParentBottom()
                }.onClick {
                    viewModel.addMainListItem()
                }
            }
        }.view
    }

    private fun bindViewsToViewModel() {
        swipeRefreshLayout?.isRefreshing = true
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        getMainList()
    }

    private fun getMainList() {
        viewModel.getMainList()?.observe(this, Observer { list ->
            updateList(list)
        })
    }

    private fun refresh() {
        swipeRefreshLayout?.isRefreshing = true
        getMainList()
    }

    private fun updateList(list: List<MainListItem>?) {
        listAdapter.mainList = list ?: emptyList()
        listAdapter.notifyDataSetChanged()
        swipeRefreshLayout?.isRefreshing = false
        toast(getString(R.string.refresh_success))
    }
}