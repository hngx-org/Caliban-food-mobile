package com.essycynthia.calibanfoodmobile.data.remote.data_classes


data class GetALunchResponse(
    val `data`: GetALunchDto,
    val message: String,
    val statusCode: Int
)