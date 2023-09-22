package com.essycynthia.calibanfoodmobile.data.remote.dto

data class GetALunchDto(
    val created_at: String,
    val id: String,
    val note: String,
    val quantity: Int,
    val receiverId: String,
    val redeemed: Boolean,
    val senderId: String
)