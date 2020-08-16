/**
 * 默认配置版本
 */
object ConfigVersions {
    const val sdkVersion = 29
    const val buildToolsVersion = "29.0.3"
    const val applicationId = "com.qf.gank"
    const val minSdkVersion = 21
    const val targetSdkVersion = 29
    const val versionCode = 1
    const val versionName = "1.0"
}

/**
 * 依赖项版本
 */
object DepVersions {
    const val coreKtx = "1.3.0"
    const val appcompat = "1.1.0"
    const val constraintLayout = "1.1.3"
    const val junit = "4.13"
    const val textExt = "1.1.1"
    const val textEspressoCore = "3.2.0"
    const val kotlinVersion = "1.3.72"

    const val material = "1.1.0"
    const val recyclerView = "1.1.0"
    const val lifecycleExt = "2.2.0"
    const val lifecycleViewModel = "2.2.0"
    const val navigation = "2.3.0"
    const val retrofit2 = "2.9.0"
    const val retrofit2Converter = "2.9.0"
    const val brvah = "3.0.1"
    const val qmui = "2.0.0-alpha10"
    const val unPeekLiveData = "3.2.3-beta10"
    const val immersionBar = "3.0.0"
    const val bannerViewPager = "3.1.3"
    const val glide = "4.11.0"
    const val dslTabLayout = "1.5.5"
    const val smartRefresh = "2.0.1"
}

/**
 * 依赖项
 */
object Deps {
    const val kotlinVersion = "org.jetbrains.kotlin:kotlin-stdlib:${DepVersions.kotlinVersion}"
    const val coreKtx = "androidx.core:core-ktx:${DepVersions.coreKtx}"
    const val appcompat =  "androidx.appcompat:appcompat:${DepVersions.appcompat}"
    const val constraintLayout =  "androidx.constraintlayout:constraintlayout:${DepVersions.constraintLayout}"
    const val junit =  "junit:junit:${DepVersions.junit}"
    const val textExt =  "androidx.test.ext:junit:${DepVersions.textExt}"
    const val textEspressoCore =  "androidx.test.espresso:espresso-core:${DepVersions.textEspressoCore}"

    const val material = "com.google.android.material:material:${DepVersions.material}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${DepVersions.recyclerView}"
    const val lifecycleExt = "androidx.lifecycle:lifecycle-extensions:${DepVersions.lifecycleExt}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${DepVersions.lifecycleViewModel}"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${DepVersions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${DepVersions.navigation}"
    const val retrofit2 = "com.squareup.retrofit2:retrofit:${DepVersions.retrofit2}"
    const val retrofit2Converter = "com.squareup.retrofit2:converter-gson:${DepVersions.retrofit2Converter}"
    const val brvah = "com.github.CymChad:BaseRecyclerViewAdapterHelper:${DepVersions.brvah}"
    const val qmui = "com.qmuiteam:qmui:${DepVersions.qmui}"
    const val unPeekLiveData = "com.kunminx.archi:unpeek-livedata:${DepVersions.unPeekLiveData}"
    const val immersionBar = "com.gyf.immersionbar:immersionbar:${DepVersions.immersionBar}"
    const val bannerViewPager = "com.github.zhpanvip:BannerViewPager:${DepVersions.bannerViewPager}"
    const val glide = "com.github.bumptech.glide:glide:${DepVersions.glide}"
    const val dslTabLayout = "com.github.angcyo.DslTablayout:TabLayout:${DepVersions.dslTabLayout}"
    const val smartRefresh = "com.scwang.smart:refresh-layout-kernel:${DepVersions.smartRefresh}"
    const val smartRefreshMaterial = "com.scwang.smart:refresh-header-material:${DepVersions.smartRefresh}"
}
