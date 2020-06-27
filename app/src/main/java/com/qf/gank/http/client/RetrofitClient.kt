package com.qf.gank.http.client

import com.qf.gank.config.Configs
import com.qf.gank.http.api.APIS
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * 作者：PeterWu
 * 时间：2020/6/27
 * 描述：RetrofitClient
 */
object RetrofitClient {

    private val okHttpClient by lazy {
        OkHttpClient
            .Builder()
            .callTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    val getService = Retrofit
        .Builder()
        .client(okHttpClient)
        .baseUrl(Configs.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(APIS::class.java)
}