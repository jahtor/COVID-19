package com.example.covid_19

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object SplashScreen : Screen("slash_screen")
//    object CardScreen : Screen("card_screen")
//    object MovieInfo : Screen("movie_info")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}

