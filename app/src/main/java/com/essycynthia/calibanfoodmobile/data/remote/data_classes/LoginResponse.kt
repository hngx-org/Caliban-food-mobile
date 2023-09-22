package com.essycynthia.calibanfoodmobile.data.remote.data_classes

import com.essycynthia.calibanfoodmobile.data.remote.dto.LoginResponseDto

data class LoginResponse(
    val `data`: LoginResponseDto,
    val message: String,
    val statusCode: Int
)