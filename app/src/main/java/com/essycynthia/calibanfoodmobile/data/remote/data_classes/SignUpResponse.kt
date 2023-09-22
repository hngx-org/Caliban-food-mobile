package com.essycynthia.calibanfoodmobile.data.remote.data_classes

import com.essycynthia.calibanfoodmobile.data.remote.dto.LoginResponseDto

data class SignUpResponse(
    val message: String = "User Created Successfully",
    val statusCode: Int = 201
)