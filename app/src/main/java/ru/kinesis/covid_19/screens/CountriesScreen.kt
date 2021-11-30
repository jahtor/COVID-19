package ru.kinesis.covid_19.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ru.kinesis.covid_19.CovidViewModel
import com.example.covid_19.R

@Composable
fun CountriesScreen(navController: NavController){
    val viewModel = CovidViewModel()
    viewModel.getCountries()
    Column(
        modifier = Modifier
            .background(Color(0xFF003c58))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.covid19),
                contentDescription = "Logo",
                modifier = Modifier.size(50.dp),
                alignment = Alignment.Center
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                text = "LiveCovid19",
                textAlign = TextAlign.Center,
                fontSize = 36.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
        Text(
            text = "Coutries Total",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
/*
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp)){
            Text(text = "Country", color = Color.White, fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f))
            Text(text = "Confirmed", color = Color.White, fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f))
            Text(text = "Recovered", color = Color.White, fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f))
            Text(text = "Critical", color = Color.White, fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f))
            Text(text = "Deaths", color = Color.White, fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f))
        }
*/
//        SearchView()
        //TODO настроить нормальную таблицу с сортировкой и поиском
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)) {
            items(viewModel.countriesList) { c ->
//                Column() {
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 2.dp),
//                    elevation = 10.dp,
                    border = BorderStroke(1.dp, Color.LightGray),
                    backgroundColor = Color(0xFF003c58)
                ) {
                    Column(modifier = Modifier.padding(5.dp)) {
                        Text(
                            text = "${c.country}",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(text = "Confirmed", color = Color.White)
                                Text(text = "${c.confirmed}", color = Color.White)
                            }
                            Column(modifier = Modifier.weight(1f)) {
                                Text(text = "Recovered", color = Color.White)
                                Text(text = "${c.recovered}", color = Color.White)
                            }
                            Column(modifier = Modifier.weight(1f)) {
                                Text(text = "Critical", color = Color.White)
                                Text(text = "${c.critical}", color = Color.White)
                            }
                            Column(modifier = Modifier.weight(1f)) {
                                Text(text = "Deaths", color = Color.White)
                                Text(text = "${c.deaths}", color = Color.White)
                            }
                        }
                    }
                }
//                Divider(color = Color.White, thickness = 1.dp)
            }
        }
    }
}

@Composable
fun SearchView(state: MutableState<TextFieldValue>) {
//    val state = remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
        },
        modifier = Modifier
            .fillMaxWidth(),
        textStyle = TextStyle(color = Color.White, fontSize = 18.sp),
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "",
                modifier = Modifier
                    .padding(15.dp)
                    .size(24.dp)
            )
        },
        trailingIcon = {
            if (state.value != TextFieldValue("")) {
                IconButton(
                    onClick = {
                        state.value =
                            TextFieldValue("") // Remove text from TextField when you press the 'X' icon
                    }
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(15.dp)
                            .size(24.dp)
                    )
                }
            }
        },
        singleLine = true,
        shape = RectangleShape, // The TextFiled has rounded corners top left and right by default
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            cursorColor = Color.White,
            leadingIconColor = Color.White,
            trailingIconColor = Color.White,
            backgroundColor = colorResource(id = R.color.teal_700),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}