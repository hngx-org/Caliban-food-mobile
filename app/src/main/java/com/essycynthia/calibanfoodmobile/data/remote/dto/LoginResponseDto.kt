package com.essycynthia.calibanfoodmobile.data.remote.dto

data class LoginResponseDto(
    val access_token: String,
    val email: String,
    val id: String,
    val isAdmin: Boolean,
    val available_lunch: Any?
)