package com.qf.gank.bean.category

import java.io.Serializable

data class CategoryBean(
    val _id: String? = null,
    val coverImageUrl: String?= null,
    val desc: String?= null,
    val title: String? = null,
    val type: String? = null
): Serializable