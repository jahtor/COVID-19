package com.example.covid_19

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.covid_19.screens.CountriesScreen
import com.example.covid_19.screens.WorldScreen
import com.example.covid_19.screens.SplashScreen
import com.example.covid_19.ui.theme.COVID19Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            COVID19Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    // get current Nav position
//                    val navBackStackEntry by navController.currentBackStackEntryAsState()
//                    println("navBackStack: " + navBackStackEntry?.destination?.route)
                    Scaffold(
                        bottomBar = {
//                            if (navBackStackEntry?.destination?.route != "splash_screen") {
                                BottomNavBar(navController = navController)
//                            }
                        }
                    ) {
                        Navigation(navController = navController)
                    }
                }
            }
        }
    }
}
// https://covid19-api.com/docs

@Composable
fun Navigation(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.WorldScreen.route) {
        //TODO как сделать SplashScreen без нижнего меню?
        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.WorldScreen.route) {
            WorldScreen(navController = navController)
        }
        composable(route = Screen.CountriesScreen.route) {
            CountriesScreen(navController = navController)
        }
    }
}