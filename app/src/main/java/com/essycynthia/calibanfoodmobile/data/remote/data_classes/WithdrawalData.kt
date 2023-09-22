package com.essycynthia.calibanfoodmobile.data.remote.data_classes

data class WithdrawalData(
    val id: String,
    val user_id: String,
    val status: String,
    val amount: Int,
    val created_at: String
)