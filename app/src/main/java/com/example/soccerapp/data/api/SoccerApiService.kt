package com.example.soccerapp.data.api

import com.example.soccerapp.data.model.LeaguesData
import com.example.soccerapp.data.model.SoccerMetaData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.Date

interface SoccerApiService {
    @GET("v2.2/fixtures/?t=schedule")
    suspend fun getMatches(
        @Query("user") user: String,
        @Query("token") token: String,
        @Query("d") date: Date
    ): Response<SoccerMetaData>

    @GET("v2.2/leagues/?t=list")
    suspend fun getLeagues(
        @Query("user") user: String,
        @Query("token") token: String,
    ): Response<LeaguesData>
}