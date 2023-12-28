package com.fgr.palindromechecker.data.config

import com.fgr.palindromechecker.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun apiConfig(
    baseUrl: String = BuildConfig.BASE_URL,
): Retrofit {
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}