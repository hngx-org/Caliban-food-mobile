package com.essycynthia.calibanfoodmobile.data.remote.data_classes

data class SignUpRequest(
    val email: String,
    val first_name: String,
    val last_name: String,
    val password: String,
    val phone_number: String
)