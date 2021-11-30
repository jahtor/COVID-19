package ru.kinesis.covid_19.model

data class WorldTotal(
//    @SerializedName("confirmed")
    val confirmed: Int,
    val critical: Int,
    val deaths: Int,
    val lastChange: String,
    val lastUpdate: String,
    val recovered: Int
)
