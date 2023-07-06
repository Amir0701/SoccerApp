package com.example.soccerapp.data.repository

import com.example.soccerapp.data.api.SoccerApiService

class SoccerRepository(val api: SoccerApiService) {
    suspend fun getMatches(user: String, token: String) = api.getMatches(user, token)

    suspend fun getAllLeagues(user: String, token: String) = api.getLeagues(user, token)
}