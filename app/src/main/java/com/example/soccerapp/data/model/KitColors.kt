package com.example.soccerapp.data.model

import com.google.gson.annotations.SerializedName

data class KitColors(
    @SerializedName("away_main_color") var awayMainColor: String? = null,
    @SerializedName("away_second_color") var awaySecondColor: String? = null,
    @SerializedName("away_number_color") var awayNumberColor: String? = null,
    @SerializedName("away_gk_main_color") var awayGkMainColor: String? = null,
    @SerializedName("away_gk_second_color") var awayGkSecondColor: String? = null,
    @SerializedName("away_gk_number_color") var awayGkNumberColor: String? = null

)