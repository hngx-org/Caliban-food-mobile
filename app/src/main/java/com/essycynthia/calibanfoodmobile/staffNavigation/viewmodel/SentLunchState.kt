package com.essycynthia.calibanfoodmobile.staffNavigation.viewmodel

import com.essycynthia.calibanfoodmobile.data.remote.data_classes.SentLunchResponse
import com.essycynthia.calibanfoodmobile.data.remote.dto.SignUpResponseDto

data class SentLunchState (
    val isLoading : Boolean = false,
    val error : String? = "",
    val success : SentLunchResponse? =  null

)
