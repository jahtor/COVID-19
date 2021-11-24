package com.example.covid_19.remote

import com.example.covid_19.model.TotalItem
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface CovidApi {

    @GET("totals?format=json")
    @Headers("accept: application/json")
    suspend fun getTotal(
    ): List<TotalItem>
}