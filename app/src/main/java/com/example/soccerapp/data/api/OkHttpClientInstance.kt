package com.example.soccerapp.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object OkHttpClientInstance {
    val client by lazy {
        OkHttpClient().newBuilder()
            .addInterceptor(
                HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .build()
    }
}