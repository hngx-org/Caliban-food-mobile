package com.essycynthia.calibanfoodmobile.data.remote

import com.essycynthia.calibanfoodmobile.data.remote.data_classes.SignUpResponseData

data class StaffSignUpResponse(
    val `data`: SignUpResponseData,
    val message: String,
    val status: Int
)

