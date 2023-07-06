package com.example.soccerapp.data.model

import com.google.gson.annotations.SerializedName

data class LeaguesData(
    @SerializedName("data") val data: Array<Leg> = arrayOf()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LeaguesData

        if (!data.contentEquals(other.data)) return false

        return true
    }

    override fun hashCode(): Int {
        return data.contentHashCode()
    }
}
