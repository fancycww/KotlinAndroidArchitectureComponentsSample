package com.cww.sample.kotlin.main.models

enum class MainListViewType {
    HEADER, ITEM
}

data class MainListItem(
        var id: Long?,
        var title: String,
        var content: String?,
        var iconUrl: String?,
        var viewType: MainListViewType)
