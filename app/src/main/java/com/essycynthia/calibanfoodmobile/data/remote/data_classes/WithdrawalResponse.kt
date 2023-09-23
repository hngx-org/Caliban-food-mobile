package com.essycynthia.calibanfoodmobile.data.remote.data_classes

data class WithdrawalResponse(
    val message: String,
    val statusCode: Int,
    val data: WithdrawalData
)