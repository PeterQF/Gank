package com.qf.gank.ui.home

import android.graphics.Color
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.angcyo.tablayout.DslTabIndicator
import com.google.android.material.tabs.TabLayoutMediator
import com.qf.gank.R
import com.qf.gank.bean.banner.BannerBean
import com.qf.gank.bean.category.CategoryBean
import com.qf.gank.ui.base.BaseVmFragment
import com.qf.gank.ui.home.banner.BannerAdapter
import com.qf.gank.ui.home.banner.BannerViewHolder
import com.qf.gank.utils.LogUtils
import com.qf.gank.widget.ViewPager2Delegate
import com.zhpan.bannerview.BannerViewPager
import com.zhpan.indicator.enums.IndicatorSlideMode
import com.zhpan.indicator.enums.IndicatorStyle
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * 作者：PeterWu
 * 时间：2020/7/11
 * 描述：HomeFragment
 */
class HomeFragment : BaseVmFragment<HomeFgViewModel>() {

    private lateinit var mBannerViewPager: BannerViewPager<BannerBean, BannerViewHolder>
    private val mFragmentList by lazy { arrayListOf<Fragment>() }

    override fun viewModelClass() = HomeFgViewModel::class.java

    override fun initView() {
        setupBannerViewPager()
        initRefresh()
    }

    private fun initRefresh() {
        mSwipeRefreshLayout.apply {
            setEnableOverScrollBounce(false)
            setOnRefreshListener {
                refreshHomeData()
            }
        }
    }

    private fun initTab(beans: List<CategoryBean>) {
        mFragmentList.clear()
        for (i in beans.indices) {
            val fragment = HomePageFragment.newInstance(beans[i])
            mFragmentList.add(fragment)
            val view = LayoutInflater.from(requireContext()).inflate(R.layout.tab_category, null) as TextView
            view.text = beans[i].title
            mDslTabLayout.addView(view)
        }
        mViewPager.adapter = HomePageAdapter(requireActivity(), mFragmentList)
        mDslTabLayout.setupViewPager(ViewPager2Delegate(mViewPager, mDslTabLayout))
    }

    private fun setupBannerViewPager() {
        mBannerViewPager =
            requireView().findViewById<BannerViewPager<BannerBean, BannerViewHolder>>(R.id.mBannerViewPager)
                .apply {
                    adapter = BannerAdapter()
                    setIndicatorSliderGap(resources.getDimensionPixelOffset(R.dimen.dp_4))
                    setIndicatorMargin(0, 0, 15, 15)
                    setPageMargin(40)
                    setIndicatorSliderRadius(10, 20)
                    setIndicatorHeight(6)
                    setIndicatorSliderColor(
                        ContextCompat.getColor(requireContext(), R.color.banner_indicator),
                        ContextCompat.getColor(requireContext(), R.color.white)
                    )
                    setOnPageClickListener {
                        LogUtils.info("current banner is ---> $it")
                    }.create()
                }
    }

    override fun initData() {
        refreshHomeData()
    }

    private fun refreshHomeData() {
        mViewModel.getBanner()
        mViewModel.getCategory()
    }

    override fun observe() {
        super.observe()
        mViewModel.run {
            mBannerLiveData.observe(viewLifecycleOwner, Observer {
                mSwipeRefreshLayout.finishRefresh()
                mBannerViewPager.refreshData(it)
            })
            mCategoryLiveData.observe(viewLifecycleOwner, Observer {
                mSwipeRefreshLayout.finishRefresh()
                initTab(it)
                getShareViewModel()?.isGetCategory?.postEvent(true)
                LogUtils.info("get category ---> $it")
            })
        }
    }

    override fun getLayoutId() = R.layout.fragment_home
}