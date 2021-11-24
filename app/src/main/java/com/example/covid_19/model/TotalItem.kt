package com.example.covid_19.model

import com.google.gson.annotations.SerializedName

data class TotalItem(
//    @SerializedName("confirmed")
    val confirmed: Int,
//    @SerializedName("critical")
    val critical: Int,
//    @SerializedName("deaths")
    val deaths: Int,
//    @SerializedName("lastChange")
    val lastChange: String,
//    @SerializedName("lastUpdate")
    val lastUpdate: String,
//    @SerializedName("recovered")
    val recovered: Int
)
