package com.example.soccerapp.data.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder

object GsonInstance {
    val instance: Gson by lazy {
        GsonBuilder().create()
    }
}