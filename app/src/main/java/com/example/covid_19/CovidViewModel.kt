package com.example.covid_19

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.covid_19.model.TotalItem
import com.example.covid_19.remote.NetworkModule
import kotlinx.coroutines.launch

class CovidViewModel: ViewModel() {
    var totalList: List<TotalItem> by mutableStateOf(listOf())
//    var totalList: MutableState<List<TotalItem>> = mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    fun getTotal(){
        viewModelScope.launch {
            val apiService = NetworkModule.getInstance()
            try {
                totalList = apiService.getTotal()
//                println("covidTotalList: $totalList")
//                println("covidTotalList.value: ${totalList}")
            } catch (e: Exception){
                errorMessage = e.message.toString()
                println("getTotal error: $errorMessage")
            }
        }
    }
}