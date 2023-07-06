package com.example.soccerapp.data.model

import com.google.gson.annotations.SerializedName

data class SoccerMetaData(
    @SerializedName("data") var dataList: List<Data>
)
