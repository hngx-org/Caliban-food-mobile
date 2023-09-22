package com.essycynthia.calibanfoodmobile.data.remote.dto

data class UserProfileDto(
    val email: String,
    val id: String,
    val isAdmin: Boolean,
    val name: String,
    val profile_picture: String
)