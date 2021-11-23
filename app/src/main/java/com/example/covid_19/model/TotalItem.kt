package com.example.covid_19.model

data class TotalItem(
    val confirmed: Int,
    val critical: Int,
    val deaths: Int,
    val lastChange: String,
    val lastUpdate: String,
    val recovered: Int
)