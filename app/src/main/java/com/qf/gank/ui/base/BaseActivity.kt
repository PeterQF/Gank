package com.qf.gank.ui.base

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gyf.immersionbar.ImmersionBar
import com.qf.gank.R
import com.qf.gank.utils.BarUtils
import com.qmuiteam.qmui.util.QMUIStatusBarHelper

/**
 * 作者：PeterWu
 * 时间：2020/6/27
 * 描述：BaseActivity
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        BarUtils.setStatusBarColor(this, Color.TRANSPARENT)
//        BarUtils.setStatusBarLightMode(this, true)
//        QMUIStatusBarHelper.translucent(this)
//        QMUIStatusBarHelper.setStatusBarLightMode(this)
        initStatusBar()
        setContentView(getLayoutId())
        initView()
    }

    abstract fun initView()

    abstract fun getLayoutId(): Int

    open fun initStatusBar() {
        ImmersionBar.with(this).transparentNavigationBar().statusBarDarkFont(true).init()
    }
}