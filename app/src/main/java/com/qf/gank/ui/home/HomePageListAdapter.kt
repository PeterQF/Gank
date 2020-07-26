package com.qf.gank.ui.home

import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.qf.gank.R
import com.qf.gank.bean.article.ArticleBean
import com.qmuiteam.qmui.widget.QMUIRadiusImageView

/**
 * 作者：PeterWu
 * 时间：2020/7/12
 * 描述：HomePageListAdapter
 */
class HomePageListAdapter(data: MutableList<ArticleBean>) : BaseMultiItemQuickAdapter<ArticleBean, BaseViewHolder>(data) {

    companion object {
        const val TYPE_GIRL = 0x1
        const val TYPE_ARTICLE = 0x2
    }

    init {
        addItemType(TYPE_GIRL, R.layout.rv_girl_item)
        addItemType(TYPE_ARTICLE, R.layout.rv_article_item)
    }

    override fun convert(helper: BaseViewHolder, item: ArticleBean) {
        when(helper.itemViewType) {
            TYPE_GIRL -> {
                helper.setText(R.id.mTitleTv, item.title)
                    .setText(R.id.mAuthorTv, item.author)
                    .setText(R.id.mPublishTimeTv, item.publishedAt)
                val iconView = helper.getView<QMUIRadiusImageView>(R.id.mIconIv)
                val coverView = helper.getView<QMUIRadiusImageView>(R.id.mCoverIv)
                val images = item.images
                if (images != null && images.isNotEmpty()) {
                    Glide.with(iconView).load(images.get(0)).into(iconView)
                    Glide.with(coverView).load(images.get(0)).into(coverView)
                }
            }
            TYPE_ARTICLE -> {
                helper.setText(R.id.mTitleTv, item.title)
                    .setText(R.id.mDescTv, item.desc)
                    .setText(R.id.mAuthorTv, item.author)
                    .setText(R.id.mPublishTimeTv, item.publishedAt)
                    .setText(R.id.mTagTv, item.type)
                val coverView = helper.getView<QMUIRadiusImageView>(R.id.mCoverIv)
                val images = item.images
                if (images != null && images.isNotEmpty()) {
                    Glide.with(coverView).load(images.get(0)).into(coverView)
                }
            }
        }
    }
}