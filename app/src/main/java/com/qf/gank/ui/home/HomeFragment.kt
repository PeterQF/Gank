package com.qf.gank.ui.home

import android.view.LayoutInflater
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.qf.gank.R
import com.qf.gank.bean.banner.BannerBean
import com.qf.gank.bean.category.CategoryBean
import com.qf.gank.ui.base.BaseVmFragment
import com.qf.gank.ui.home.banner.BannerAdapter
import com.qf.gank.ui.home.banner.BannerViewHolder
import com.qf.gank.utils.LogUtils
import com.qf.gank.widget.ViewPager2Delegate
import com.zhpan.bannerview.BannerViewPager
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
        mRefreshHeader.setColorSchemeColors(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
        mSwipeRefreshLayout.apply {
            setEnableOverScrollBounce(false)
            setOnRefreshListener {
                getShareViewModel()?.isRefreshArticle?.postValue(true)
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
        // 加了下面这句，会一次走完fragment的onViewCreated，而如果使用initData的话，就相当于没有了懒加载
        // 会走完所有fragment的initData，所以加了下面这句就使用lazyLoadData来实现懒加载。
        // 如果不加下面这句，默认就是懒加载，使用initData或者lazyLoadData都可以。
        // 之所以我要加下面这句，是因为我要实现下拉刷新，当我从第一个fragment依次滑到最后一个fragment，再从最后一个依次滑到
        // 第一个的时候开启刷新，此时mIsCanRefresh为false，但确实走了onResume方法，而加了下面这句就解决了， 暂不知为嘛。
        // 有待考究！！！
        mViewPager.offscreenPageLimit = mFragmentList.count()
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
        getShareViewModel()?.isRefreshArticle?.observe(viewLifecycleOwner, Observer {
            if (it.not()) mSwipeRefreshLayout.finishRefresh()
        })
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
                LogUtils.info("get category ---> $it")
            })
        }
    }

    override fun getLayoutId() = R.layout.fragment_home
}