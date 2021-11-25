package com.example.covid_19.model

data class CountriesTotal(
    val country: String,
    val code: String,
    val confirmed: Int,
    val recovered: Int,
    val critical: Int,
    val deaths: Int,
//    val latitude: Double,
//    val longitude: Double,
    val lastChange: String,
    val lastUpdate: String
)
