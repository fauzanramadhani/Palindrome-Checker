plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}

android {
    namespace = "com.fgr.palindromechecker"
    compileSdk = 31

    defaultConfig {
        applicationId = "com.fgr.palindromechecker"
        minSdk = 19
        //noinspection ExpiredTargetSdkVersion
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures {
        buildConfig = true
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    //Glide
    implementation("com.github.bumptech.glide:glide:4.12.0")
    // Maker-men Rounded Image View
    implementation("com.makeramen:roundedimageview:2.3.0")
    // Paging 3
    implementation("androidx.paging:paging-runtime-ktx:3.1.0")
    //Gson
    implementation("com.google.code.gson:gson:2.8.9")
    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    //Retrofit GSON Converter
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    //Recycle View swipe up refresh
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    // Activity Utility
    implementation("androidx.activity:activity-ktx:1.2.1")
}