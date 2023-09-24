package com.essycynthia.calibanfoodmobile.staffNavigation.viewmodel

data class Reward(
    val name: String,
    val foodCount: Int,
    val time: String,
)

val randomRewards = listOf(
    Reward(
        name = "UdukaE",
        foodCount = 3,
        time = "3hrs"
    ),
    Reward(
        name = "Isaac",
        foodCount = 4,
        time = "5hrs"
    ),
    Reward(
        name = "Fisayo",
        foodCount = 2,
        time = "3hrs"
    ),
)
