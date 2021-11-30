package ru.kinesis.covid_19.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ru.kinesis.covid_19.CovidViewModel
import com.example.covid_19.R

@Composable
fun WorldScreen(navController: NavController) {
    val viewModel = CovidViewModel()
    viewModel.getTotal()
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
            text = "Words Total",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        LazyColumn(modifier = Modifier.fillMaxSize()) {
//            items(viewModel.totalList) { c ->
//                Text(text = "${c.lastChange}")
//            }
            items(viewModel.totalList) { t ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, top = 10.dp, end = 10.dp),
                ) {
                    Card(
                        modifier = Modifier
                            .height(200.dp)
                            .weight(1f)
                            .padding(start = 10.dp, top = 10.dp, end = 10.dp),
                        elevation = 10.dp,
                        border = BorderStroke(1.dp, Color.White),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Column(
                            modifier = Modifier.background(Color(0xFF003c58)),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(100.dp)
//                                    .padding(5.dp)
                                    .clip(CircleShape)
                                    .background(Color.Yellow)
                            ){
                                Image(
                                    painter = painterResource(id = R.drawable.ic_confirmed_48),
                                    contentDescription = "check",
                                    modifier = Modifier.align(alignment = Alignment.Center))
                            }
                            Text(text = "Confirmed:", color = Color.White, fontWeight = FontWeight.Bold)
                            Text(text = "${t.confirmed}", color = Color.White, fontWeight = FontWeight.Bold)
                        }
                    }
                    Card(
                        modifier = Modifier
                            .height(200.dp)
                            .weight(1f)
                            .padding(start = 10.dp, top = 10.dp, end = 10.dp),
                        elevation = 10.dp,
                        border = BorderStroke(1.dp, Color.White),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Column(
                            modifier = Modifier.background(Color(0xFF003c58)),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(100.dp)
                                    .clip(CircleShape)
                                    .background(Color.Green)
                            ){
                                Image(
                                    painter = painterResource(id = R.drawable.ic_recovered_48),
                                    contentDescription = "check",
                                    modifier = Modifier.align(alignment = Alignment.Center))
                            }
                            Text(text = "Recovered:", color = Color.White, fontWeight = FontWeight.Bold)
                            Text(text = "${t.recovered}", color = Color.White, fontWeight = FontWeight.Bold)
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, top = 10.dp, end = 10.dp),

                    ) {
                    Card(
                        modifier = Modifier
                            .height(200.dp)
                            .weight(1f)
                            .padding(start = 10.dp, top = 10.dp, end = 10.dp),
                        elevation = 10.dp,
                        border = BorderStroke(1.dp, Color.White),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Column(
                            modifier = Modifier.background(Color(0xFF003c58)),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(100.dp)
                                    .clip(CircleShape)
                                    .background(Color.Red)
                            ){
                                Image(
                                    painter = painterResource(id = R.drawable.ic_critical_48),
                                    contentDescription = "check",
                                    modifier = Modifier.align(alignment = Alignment.Center))
                            }
                            Text(text = "Critical:", color = Color.White, fontWeight = FontWeight.Bold)
                            Text(text = "${t.critical}", color = Color.White, fontWeight = FontWeight.Bold)
                        }
                    }
                    Card(
                        modifier = Modifier
                            .height(200.dp)
                            .weight(1f)
                            .padding(start = 10.dp, top = 10.dp, end = 10.dp),
                        elevation = 10.dp,
                        border = BorderStroke(1.dp, Color.White),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Column(
                            modifier = Modifier.background(Color(0xFF003c58)),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(100.dp)
                                    .clip(CircleShape)
                                    .background(Color.Gray)
                            ){
                                Image(
                                    painter = painterResource(id = R.drawable.ic_deaths_48),
                                    contentDescription = "check",
                                    modifier = Modifier.align(alignment = Alignment.Center))
                            }
                            Text(text = "Deaths:", color = Color.White, fontWeight = FontWeight.Bold)
                            Text(text = "${t.deaths}", color = Color.White, fontWeight = FontWeight.Bold)
                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "Last Change: ${t.lastChange}",
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

