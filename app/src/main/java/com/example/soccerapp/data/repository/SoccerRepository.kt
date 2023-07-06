package com.example.soccerapp.data.repository

import com.example.soccerapp.data.api.SoccerApiService
import java.util.Date

class SoccerRepository(val api: SoccerApiService) {
    suspend fun getMatches(user: String, token: String, date: Date) = api.getMatches(user, token)

    suspend fun getAllLeagues(user: String, token: String) = api.getLeagues(user, token)
}