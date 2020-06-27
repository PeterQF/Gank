package com.qf.gank.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * 作者：PeterWu
 * 时间：2020/6/27
 * 描述：BaseActivity
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initView()
    }

    abstract fun initView()

    abstract fun getLayoutId(): Int
}