package com.lazurs

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext

/**
 * Author: lazurs
 * Date: 2024-08-14
 */
@HiltAndroidApp
class MyApplication:Application() {
    override fun onCreate() {

        super.onCreate()
    }
}