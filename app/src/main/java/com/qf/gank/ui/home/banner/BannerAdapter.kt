package com.qf.gank.ui.home.banner

import android.view.View
import com.qf.gank.R
import com.qf.gank.bean.banner.BannerBean
import com.zhpan.bannerview.BaseBannerAdapter

/**
 * 作者：PeterWu
 * 时间：2020/7/11
 * 描述：BannerAdapter
 */
class BannerAdapter : BaseBannerAdapter<BannerBean, BannerViewHolder>() {

    override fun getLayoutId(viewType: Int) = R.layout.banner_item

    override fun createViewHolder(itemView: View, viewType: Int) = BannerViewHolder(itemView)

    override fun onBind(
        holder: BannerViewHolder?,
        data: BannerBean?,
        position: Int,
        pageSize: Int
    ) {
        holder?.bindData(data, position, pageSize)
    }
}