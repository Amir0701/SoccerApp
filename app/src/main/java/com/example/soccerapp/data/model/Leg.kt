package com.example.soccerapp.data.model

import com.google.gson.annotations.SerializedName

data class Leg (
    val id: String,
    val name: String,

    @SerializedName("is_cup")
    val isCup: String,

    @SerializedName("is_amateur")
    val isAmateur: String,

    @SerializedName("continent_id")
    val continentID: String,

    @SerializedName("country_id")
    val countryID: String,

    @SerializedName("current_season_id")
    val currentSeasonID: String,

    @SerializedName("current_round_id")
    val currentRoundID: String,

    @SerializedName("current_stage_id")
    val currentStageID: Any? = null
)