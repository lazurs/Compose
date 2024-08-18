/**
 * Author: lazurs
 * Date: 2024-08-13
 */
object Dependencies {
    val appcompat by lazy {
        "androidx.appcompat:appcompat:${Versions.appcompat}"
    }
    val material by lazy {
        "com.google.android.material:material:1.12.0"
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
        "androidx.compose.ui:ui:1.6.8"
    }
    val composeUiGraphic by lazy {
        "androidx.compose.ui:ui-graphics:1.6.8"
    }
    val composeUiToolingPreview by lazy {
        "androidx.compose.ui:ui-tooling-preview:1.6.8"
    }
    val composeMaterial3 by lazy {
        "androidx.compose.material3:material3:1.2.1"
    }
    val navigationCompose by lazy {
        "androidx.navigation:navigation-compose:${Versions.navigationCompose}"
    }
    val composeNavigation by lazy {
        "androidx.navigation:navigation-compose:2.7.7"
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
//    val composeBom by lazy {
//        "androidx.compose:compose-bom:2024.06.00"
//    }


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