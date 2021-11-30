package ru.kinesis.covid_19

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import ru.kinesis.covid_19.model.WorldTotal
import ru.kinesis.covid_19.remote.NetworkModule

class MainRepository {
    var totalList: List<WorldTotal> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    fun getTotal(
        onStart: () -> Unit,
        onCompletion: () -> Unit,
        onError: (String) -> Unit
    ) = flow {
            val apiService = NetworkModule.getInstance()
            try {
                totalList = apiService.getTotal()
//                println("covidTotalList: $totalList")
            } catch (e: Exception){
                errorMessage = e.message.toString()
                println("getTotal error: $errorMessage")
            }
    }.onStart { onStart() }.onCompletion { onCompletion() }.flowOn(Dispatchers.IO)
}