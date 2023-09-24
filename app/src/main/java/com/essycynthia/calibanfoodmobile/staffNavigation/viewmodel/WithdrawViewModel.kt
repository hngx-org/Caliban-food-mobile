package com.essycynthia.calibanfoodmobile.staffNavigation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class WithdrawViewModel {
    var withdrawState by mutableStateOf(WithdrawState())

    init {
        loadWithdrawalPage()
    }

    private fun loadWithdrawalPage() {

        withdrawState = withdrawState.copy(
            availableFreeLunch = 1000
        )

    }
}