package com.essycynthia.calibanfoodmobile.data.remote.data_classes

data class GetAllLunchesResponse(
    val data: List<GetALunchDto>,
    val message: String,
    val statusCode: Int
)


