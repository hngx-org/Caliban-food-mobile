package com.essycynthia.calibanfoodmobile.data.remote.data_classes

import com.essycynthia.calibanfoodmobile.data.remote.dto.GetALunchDto

data class GetAllLunchesResponse(
    val data: List<GetALunchDto>,
    val message: String,
    val statusCode: Int
)