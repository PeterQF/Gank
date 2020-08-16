package com.qf.gank.ui.base

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.qf.gank.application.App
import com.qf.gank.utils.LogUtils

/**
 * 作者：PeterWu
 * 时间：2020/6/27
 * 描述：BaseVmFragment
 */
abstract class BaseVmFragment<VM: BaseViewModel> : BaseFragment() {

    protected lateinit var mViewModel: VM
    private var mShareViewModel: ShareViewModel? = null
    private var lazyLoaded = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initViewModel()
        observe()
        // 因为Fragment恢复后savedInstanceState不为null，
        // 重新恢复后会自动从ViewModel中的LiveData恢复数据，
        // 不需要重新初始化数据。
        if (savedInstanceState == null) {
            initData()
        }
    }

    private fun initViewModel() {
        mShareViewModel = App.instance.getAppViewModelProvider(requireActivity())?.get(ShareViewModel::class.java)
        mViewModel = ViewModelProvider(this).get(viewModelClass())
    }

    fun getShareViewModel(): ShareViewModel? {
        return mShareViewModel
    }

    override fun onResume() {
        super.onResume()
        if (lazyLoaded.not()) {
            lazyLoadData()
            lazyLoaded = true
        }
    }

    open fun observe() {}

    open fun initData() {}

    open fun lazyLoadData() {}

    abstract fun viewModelClass(): Class<VM>

    abstract fun initView()
}