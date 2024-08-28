/**
 * Author: lazurs
 * Date: 2024-08-13
 */
object Dependencies {
    val appcompat by lazy {
        "androidx.appcompat:appcompat:${Versions.appcompat}"
    }
    val material by lazy {
        "com.google.android.material:material:${Versions.material}"
    }
    val coreKtx by lazy {
        "androidx.core:core-ktx:${Versions.coreKtx}"
    }

    //lifecycle-viewmodel
    val lifecycleRuntimeKtx by lazy {
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKtx}"
    }

    val lifecycleViewmodelKtx by lazy {
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleViewModelKtx}"
    }

    //compose
    val activityCompose by lazy {
        "androidx.activity:activity-compose:${Versions.activitCompose}"
    }
    val composeUi by lazy {
        "androidx.compose.ui:ui:${Versions.composeUi}"
    }
    val composeUiGraphic by lazy {
        "androidx.compose.ui:ui-graphics:${Versions.composeUi}"
    }
    val lifeCycleCompose by lazy {
        "androidx.lifecycle:lifecycle-runtime-compose-android:${Versions.composeLifecycle}"
    }
    val composeUiToolingPreview by lazy {
        "androidx.compose.ui:ui-tooling-preview:${Versions.composeUi}"
    }
    val composeMaterial3 by lazy {
        "androidx.compose.material3:material3:${Versions.composeMaterial3}"
    }
    val composeBom by lazy {
        "androidx.compose:compose-bom:${Versions.composeBom}"
    }
    val composeNavigation by lazy {
        "androidx.navigation:navigation-compose:${Versions.composeNavigation}"
    }

    //hilt
    val hiltNavigation by lazy {
        "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigation}"
    }
    val hiltAndroid by lazy {
        "com.google.dagger:hilt-android:${Versions.hiltAndroid}"
    }

    val hiltAndroidCompile by lazy {
        "com.google.dagger:hilt-android-compiler:${Versions.hiltCompiler}"
    }

    //coroutine
    val coroutineAndroid by lazy {
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"
    }
    val coroutineCore by lazy {
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
    }


    val retrofit by lazy {
        "com.squareup.retrofit2:retrofit:${Versions.retfofit}"
    }

    val logInterceptor by lazy {
        "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    }

    val okHttp by lazy {
        "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    }
    val gsonConvert by lazy {
        "com.squareup.retrofit2:converter-gson:${Versions.retfofit}"
    }
    val coil by lazy {
        "io.coil-kt:coil-compose:${Versions.coil}"
    }

}