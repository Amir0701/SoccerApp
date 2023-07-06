package com.example.soccerapp.data.api

import retrofit2.http.GET

interface SoccerApiService {
    @GET("v2.2/fixtures/?user=amirusmonov2002&token=0e7f1180be454cd23f502965cf909522&t=schedule&d=2023-08-12")
    suspend fun getMatches()
}