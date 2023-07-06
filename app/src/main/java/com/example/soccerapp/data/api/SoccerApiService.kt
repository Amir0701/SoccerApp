package com.example.soccerapp.data.api

import com.example.soccerapp.data.model.SoccerMetaData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SoccerApiService {
    @GET("v2.2/fixtures/?t=schedule&d=2023-08-12")
    suspend fun getMatches(
        @Query("user") user: String,
        @Query("token") token: String,
    ): Response<SoccerMetaData>
}