package com.essycynthia.calibanfoodmobile.data.remote.data_classes

import com.essycynthia.calibanfoodmobile.data.remote.dto.UserResponseDto

data class UsersResponse(
    val `data`: List<UserResponseDto>,
    val message: String,
    val statusCode: Int
)