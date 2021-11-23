package com.example.covid_19

import com.example.covid_19.model.Total
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

private const val BASE_URL ="https://covid19-api.com/"

interface CovidApi {
    @Headers("accept: application/json")
    @GET("totals?format=json")
    suspend fun getTotal(
//        @Query("query") query: String
    ): Total

    companion object {
        fun getInstance(): CovidApi {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(CovidApi::class.java)
        }
    }
}