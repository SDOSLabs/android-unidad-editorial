object Classpaths {
    const val gradlePlugin = "com.android.tools.build:gradle:${Versions.gradlePlugin}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Kotlin.kotlin}"

    const val navigationSafeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.Androidx.navigationSafeArgs}"
}

object Plugins {
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinApt = "kotlin-kapt"
    const val kotlinExtensions = "kotlin-android-extensions"
    const val navigationSafeArgsKotlin = "androidx.navigation.safeargs.kotlin"
}

object AndroidTest {
    const val archCoreTest = "androidx.arch.core:core-testing:${Versions.Test.archCore}"
    const val core = "androidx.test:core:${Versions.Test.core}"
    const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.Kotlin.coroutines}"
    const val databinding = "androidx.databinding:databinding-compiler:${Versions.Test.databinding}"
    const val espressoContrib = "androidx.test.espresso:espresso-contrib:${Versions.Test.espressoCore}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.Test.espressoCore}"
    const val fragmentNav = "androidx.fragment:fragment-testing:${Versions.Test.fragment}"
    const val junit = "androidx.test.ext:junit:${Versions.Test.junit}"
    const val koin = "org.koin:koin-test:${Versions.koin}"
    const val mockk = "io.mockk:mockk:${Versions.Test.mockk}"
    const val mockkAndroid = "io.mockk:mockk-android:${Versions.Test.mockk}"
    const val mockWebServer = "com.squareup.okhttp:mockwebserver:${Versions.Test.mockWebServer}"
    const val runner = "androidx.test:runner:${Versions.Test.runner}"
}

object Androidx {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.Androidx.appcompat}"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.Androidx.constraintlayout}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.Androidx.lifecycle}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Androidx.lifecycle}"
    const val material = "com.google.android.material:material:${Versions.Androidx.material}"
    const val navigation = "androidx.navigation:navigation-ui-ktx:${Versions.Androidx.navigation}"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.Androidx.navigation}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.Androidx.recyclerview}"
    const val roomAnnotations = "androidx.room:room-compiler:${Versions.Androidx.room}"
    const val room = "androidx.room:room-runtime:${Versions.Androidx.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.Androidx.room}"
}

object Dagger {
    const val core = "com.google.dagger:dagger:${Versions.dagger}"
    const val coreAnnotations = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val androidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    const val androidAnnotations = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
}

object Koin {
    const val core = "org.koin:koin-android:${Versions.koin}"
    const val viewmodel = "org.koin:koin-android-viewmodel:${Versions.koin}"
}

object Kotlin {
    const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Kotlin.coroutines}"
    const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlin.coroutines}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.Kotlin.ktx}"
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.Kotlin.kotlin}"
    const val stdlibJdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.Kotlin.kotlin}"
}

object Retrofit {
    const val core = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val httpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
}
