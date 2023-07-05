package com.example.soccerapp.data.model

import com.google.gson.annotations.SerializedName

data class Time(
    @SerializedName("datetime") var datetime: String? = null,
    @SerializedName("date") var date: String? = null,
    @SerializedName("time") var time : String? = null,
    @SerializedName("minute") var minute: String? = null,
    @SerializedName("timestamp") var timestamp: Int? = null,
    @SerializedName("timezone") var timezone: String? = null
)
