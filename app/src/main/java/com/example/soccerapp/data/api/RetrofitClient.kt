package com.example.soccerapp.data.api

import com.example.soccerapp.util.Util
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val instance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Util.BASE_URL)
            .client(OkHttpClientInstance.client)
            .addConverterFactory(GsonConverterFactory.create(GsonInstance.instance))
            .build()
    }
}