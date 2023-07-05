package com.example.soccerapp.data.model

import com.google.gson.annotations.SerializedName

data class MetaData(
    @SerializedName("data") var dataList: List<Data>
)
