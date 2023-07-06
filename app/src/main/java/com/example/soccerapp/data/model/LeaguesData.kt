package com.example.soccerapp.data.model

import com.google.gson.annotations.SerializedName

data class LeaguesData(
    @SerializedName("data") val data: List<League>
)
