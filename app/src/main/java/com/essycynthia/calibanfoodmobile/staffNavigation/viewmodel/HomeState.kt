package com.essycynthia.calibanfoodmobile.staffNavigation.viewmodel

data class HomeState(
    val name: String = "",
    val freeLunch: Int = 0,
    val rewardList: List<Reward> = emptyList(),
)