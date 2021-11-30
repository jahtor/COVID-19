package ru.kinesis.covid_19.remote

import ru.kinesis.covid_19.model.CountriesTotal
import ru.kinesis.covid_19.model.WorldTotal
import retrofit2.http.GET
import retrofit2.http.Headers

interface CovidApi {

    @GET("totals?format=json")
    @Headers("accept: application/json")
    suspend fun getTotal(
    ): List<WorldTotal>

    @GET("country/all?format=json")
    @Headers("accept: application/json")
    suspend fun getCountries(
    ): List<CountriesTotal>
}