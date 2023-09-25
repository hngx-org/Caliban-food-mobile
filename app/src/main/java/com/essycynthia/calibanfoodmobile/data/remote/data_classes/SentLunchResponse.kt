package com.essycynthia.calibanfoodmobile.data.remote.data_classes

data class SentLunchResponse(
    val `data`: List<SentLunchData>,
    val message: String,
    val status: Int
)