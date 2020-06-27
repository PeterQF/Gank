package com.qf.gank.ext

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.annotation.StringRes

/**
 * 作者：PeterWu
 * 时间：2020/6/27
 * 描述：ContextExt
 */

/**
 * 弹出Toast
 */
fun Context.showToast(message: CharSequence) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.showToast(@StringRes message: Int) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

/**
 * 启动一个Activity
 */
inline fun <reified T> Context.launch() {
    startActivity(Intent(this, T::class.java))
}