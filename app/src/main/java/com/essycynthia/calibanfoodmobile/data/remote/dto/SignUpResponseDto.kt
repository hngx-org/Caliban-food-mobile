package com.essycynthia.calibanfoodmobile.data.remote.dto

data class SignUpResponseDto(
    val `data`: SignUpData,
    val message: String,
    val status: Int
)