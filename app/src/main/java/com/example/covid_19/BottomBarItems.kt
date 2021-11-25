package com.example.covid_19

sealed class BottomBarItems(var route: String, var icon: Int, var title: String){
    object World : BottomBarItems("world_screen", R.drawable.ic_world_24, "World")
    object Countries : BottomBarItems("countries_screen", R.drawable.ic_counries_24, "Countries")
}
