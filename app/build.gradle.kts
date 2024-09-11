plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")


}

android {
    namespace = "com.lazurs"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.lazurs"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(Dependencies.appcompat)
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.material)
    implementation(Dependencies.lifecycleRuntimeKtx)
    implementation(Dependencies.activityCompose)

    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeMaterial3)
    implementation(Dependencies.composeUiToolingPreview)
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltAndroidCompile)
    implementation(Dependencies.retrofit)
    implementation(Dependencies.lifecycleViewmodelKtx)
    implementation(Dependencies.coil)
    implementation(Dependencies.hiltNavigation)
    implementation(Dependencies.composeNavigation)
    implementation(Dependencies.okHttp)
    implementation(Dependencies.gsonConvert)
    implementation(Dependencies.coroutineCore)
    implementation(Dependencies.coroutineAndroid)
    implementation(Dependencies.hiltNavigation)
    implementation(Dependencies.logInterceptor)
    implementation(Dependencies.composeBom)
    implementation(Dependencies.lifeCycleCompose)
    implementation(Dependencies.composePagingRuntime)
    implementation(Dependencies.composePaging)
}
