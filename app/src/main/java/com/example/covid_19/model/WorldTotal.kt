package com.example.covid_19.model

import com.google.gson.annotations.SerializedName

data class WorldTotal(
//    @SerializedName("confirmed")
    val confirmed: Int,
    val critical: Int,
    val deaths: Int,
    val lastChange: String,
    val lastUpdate: String,
    val recovered: Int
)
