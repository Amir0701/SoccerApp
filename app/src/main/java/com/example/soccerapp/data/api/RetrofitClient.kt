package com.example.soccerapp.data.api

import com.example.soccerapp.util.Util
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val instance: Retrofit by lazy {
        Retrofit.Builder()
            .client(OkHttpClientInstance.client)
            .baseUrl(Util.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonInstance.instance))
            .build()
    }
}