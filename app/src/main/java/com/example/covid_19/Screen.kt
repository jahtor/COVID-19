package com.example.covid_19

sealed class Screen(val route: String) {
    object WorldScreen : Screen("world_screen")
    object CountriesScreen : Screen("countries_screen")
    object SplashScreen : Screen("slash_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}

