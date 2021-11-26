package com.example.covid_19

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.covid_19.model.CountriesTotal
import com.example.covid_19.model.WorldTotal
import com.example.covid_19.remote.NetworkModule
import kotlinx.coroutines.launch

class CovidViewModel: ViewModel() {
    var totalList: List<WorldTotal> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    fun getTotal(){
        viewModelScope.launch {
            val apiService = NetworkModule.getInstance()
            try {
                totalList = apiService.getTotal()
//                println("covidTotalList: $totalList")
            } catch (e: Exception){
                errorMessage = e.message.toString()
                println("getTotal error: $errorMessage")
            }
        }
    }

    var countriesList: List<CountriesTotal> by mutableStateOf(listOf())

    fun getCountries(){
        viewModelScope.launch {
            val apiService = NetworkModule.getInstance()
            try {
                countriesList = apiService.getCountries()
//                println("countriesList: $countriesList")
            } catch (e: Exception){
                errorMessage = e.message.toString()
                println("getTotal error: $errorMessage")
            }
        }
    }
}