package com.example.covid_19.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.covid_19.CovidViewModel

@Composable
fun MainScreen(navController: NavController) {
    val vm = CovidViewModel()
    vm.getTotal()
    var total = vm.covidTotalList
    println("main total: $total")
/*
    LazyColumn(
        modifier = Modifier
            .fillMaxSize())
    {
        items(arrayListOf(vm.covidTotalList)) { total ->
            Text(text = "TOTAL")
            println("main total: $total")
//            Text(text = "Confirmed: ${total.confirmed}", fontSize = 16.sp)
//            Text(text = "Recovered: ${total.recovered}", fontSize = 16.sp)
//            Text(text = "Critical: ${total.critical}", fontSize = 16.sp)
//            Text(text = "Deaths: ${total.deaths}", fontSize = 16.sp)
        }
    }
*/
}
