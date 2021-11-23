package com.example.covid_19

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.covid_19.model.Total
import com.example.covid_19.model.TotalItem
import kotlinx.coroutines.launch

class CovidViewModel: ViewModel() {
//    var covidTotalList: List<Total> by mutableStateOf(listOf())
    var covidTotalList: ArrayList<Total> by mutableStateOf(arrayListOf())
    var covidItem: List<TotalItem> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    fun getTotal(){
        viewModelScope.launch {
            val apiService = CovidApi.getInstance()
            try {
//                covidTotalList = listOf(apiService.getTotal())
                covidTotalList = arrayListOf(apiService.getTotal())
                println("covidTotalList: $covidTotalList")
                covidItem = covidTotalList
//                println("arrayOf TotalList:" + arrayOf(covidTotalList).toString())
            } catch (e: Exception){
                errorMessage = e.message.toString()
                println("getTotal error: $errorMessage")
            }
        }
    }
}