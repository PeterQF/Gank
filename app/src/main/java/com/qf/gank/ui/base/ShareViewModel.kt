package com.qf.gank.ui.base

import com.kunminx.architecture.ui.callback.UnPeekLiveData


/**
 * 作者：PeterWu
 * 时间：2020/7/6
 * 描述：ShareViewModel
 */
class ShareViewModel : BaseViewModel() {

    val openOrCloseDrawer: UnPeekLiveData<Boolean> = UnPeekLiveData()

    val isRefreshArticle by lazy { UnPeekLiveData<Boolean>() }
}