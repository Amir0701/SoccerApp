package com.example.soccerapp.data.model

import com.google.gson.annotations.SerializedName

data class Teams(
    @SerializedName("home") var home : Home?,
    @SerializedName("away") var away : Away?
)
