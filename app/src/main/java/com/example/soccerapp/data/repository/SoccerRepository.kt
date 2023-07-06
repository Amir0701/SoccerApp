package com.example.soccerapp.data.repository

import com.example.soccerapp.data.api.SoccerApiService

class SoccerRepository(val api: SoccerApiService) {
    suspend fun getMatches() = api.getMatches()
}