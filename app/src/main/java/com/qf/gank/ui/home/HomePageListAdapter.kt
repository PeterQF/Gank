package com.qf.gank.ui.home

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.qf.gank.R

/**
 * 作者：PeterWu
 * 时间：2020/7/12
 * 描述：HomePageListAdapter
 */
class HomePageListAdapter(data: MutableList<String>) : BaseQuickAdapter<String, BaseViewHolder>(R.layout.rv_home_page_list_item, data) {
    override fun convert(helper: BaseViewHolder, item: String) {
        helper.setText(R.id.mTv, item)
    }
}