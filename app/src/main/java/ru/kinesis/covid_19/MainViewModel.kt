package ru.kinesis.covid_19

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import ru.kinesis.covid_19.model.WorldTotal

class MainViewModel(mainRepository: MainRepository) : ViewModel() {
    val worldList: Flow<List<WorldTotal>> = mainRepository.getTotal(
        onStart = {},
        onCompletion = {},
        onError = {}
    )
}