package com.qf.gank.ui.home

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kunminx.event.EventObserver
import com.qf.gank.R
import com.qf.gank.bean.article.ArticleBean
import com.qf.gank.bean.category.CategoryBean
import com.qf.gank.ui.base.BaseVmFragment
import com.qf.gank.utils.LogUtils
import com.qf.gank.widget.RvItemDecoration
import kotlinx.android.synthetic.main.include_recyclerview_refresh.*

/**
 * 作者：PeterWu
 * 时间：2020/7/12
 * 描述：HomePageFragment
 */
class HomePageFragment : BaseVmFragment<HomePageViewModel>() {

    private val mItems by lazy { ArrayList<ArticleBean>() }
    private val mAdapter by lazy { HomePageListAdapter(mItems) }

    companion object {

        const val PARAM_BEAN = "PARAM_BEAN"

        fun newInstance(categoryBean: CategoryBean): HomePageFragment {
            val bundle = Bundle()
            bundle.putSerializable(PARAM_BEAN, categoryBean)
            val fragment = HomePageFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    private val mCategoryBean by lazy {
        arguments?.getSerializable(PARAM_BEAN) as CategoryBean
    }

    override fun viewModelClass() = HomePageViewModel::class.java

    override fun initView() {
        mRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        val rvItemDecoration = RvItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        ContextCompat.getDrawable(requireContext(), R.drawable.inset_rv_divider)?.let { rvItemDecoration.setDrawable(it) }
        mRecyclerView.addItemDecoration(rvItemDecoration)
        mRecyclerView.adapter = mAdapter

    }

    override fun initData() {
        requestArticle()
    }

    private fun requestArticle() {
//        getShareViewModel()?.isGetCategory?.observe(viewLifecycleOwner, EventObserver {
//            if (it) mCategoryBean.type?.let { mViewModel.getArticle(it) }
//        })
        mCategoryBean.type?.let { mViewModel.getArticle(it) }
    }

    override fun observe() {
        super.observe()
        mViewModel.run {
            mArticleLiveData.observe(viewLifecycleOwner, Observer {
                LogUtils.error("get article ---> ${it.size}")
                mItems.addAll(it)
                mAdapter.notifyDataSetChanged()
            })
        }
    }

    override fun getLayoutId() = R.layout.include_recyclerview_refresh
}