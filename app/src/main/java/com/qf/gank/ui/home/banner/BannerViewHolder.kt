package com.qf.gank.ui.home.banner

import android.view.View
import android.widget.TextView
import com.bumptech.glide.Glide
import com.qf.gank.R
import com.qf.gank.bean.banner.BannerBean
import com.qmuiteam.qmui.widget.QMUIRadiusImageView
import com.zhpan.bannerview.BaseViewHolder

/**
 * 作者：PeterWu
 * 时间：2020/7/11
 * 描述：BannerViewHolder
 */
class BannerViewHolder(itemView: View) : BaseViewHolder<BannerBean>(itemView) {

    override fun bindData(data: BannerBean?, position: Int, pageSize: Int) {
        val imageView = findView<QMUIRadiusImageView>(R.id.mBannerIv)
        val descTv = findView<TextView>(R.id.mBannerDescTv)
        descTv.text = data?.title
        Glide.with(imageView).load(data?.image).into(imageView)
    }
}