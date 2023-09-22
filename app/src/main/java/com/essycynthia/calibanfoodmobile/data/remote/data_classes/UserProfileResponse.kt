package com.essycynthia.calibanfoodmobile.data.remote.data_classes

import com.essycynthia.calibanfoodmobile.data.remote.dto.UserProfileDto

data class UserProfileResponse(
    val `data`: UserProfileDto,
    val message: String,
    val statusCode: Int
)