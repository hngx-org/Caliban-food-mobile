package com.essycynthia.calibanfoodmobile.staffNavigation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class HomeViewModel {
    var homeState by mutableStateOf(HomeState())

    init {
        loadHomePage()
    }

    private fun loadHomePage() {

            homeState = homeState.copy(
                name = "Ufuoma",
                freeLunch = 27,
                rewardList = randomRewards
            )

    }
}