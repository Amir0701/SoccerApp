package com.example.soccerapp.data.model

import com.google.gson.annotations.SerializedName

data class Away (
    @SerializedName("id") var id: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("short_code") var shortCode: String? = null,
    @SerializedName("img") var img: String? = null,
    @SerializedName("form") var form: String? = null,
    @SerializedName("coach_id") var coachId: String? = null,
    @SerializedName("kit_colors") var kitColors: KitColors? = KitColors()

)
