package com.essycynthia.calibanfoodmobile.data.remote.data_classes

import com.essycynthia.calibanfoodmobile.data.remote.dto.GetALunchDto

data class GetALunchResponse(
    val `data`: GetALunchDto,
    val message: String,
    val statusCode: Int
)