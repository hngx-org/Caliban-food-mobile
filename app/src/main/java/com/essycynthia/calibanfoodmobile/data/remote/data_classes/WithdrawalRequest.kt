package com.essycynthia.calibanfoodmobile.data.remote.data_classes

data class WithdrawalRequest(
    val bank_name: String,
    val bank_number: String,
    val bank_code: String,
    val amount: Int
)