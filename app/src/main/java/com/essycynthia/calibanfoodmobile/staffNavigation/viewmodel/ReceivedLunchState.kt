package com.essycynthia.calibanfoodmobile.staffNavigation.viewmodel

import com.essycynthia.calibanfoodmobile.data.remote.data_classes.ReceivedLunches
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.SentLunchResponse
import com.essycynthia.calibanfoodmobile.data.remote.dto.SignUpResponseDto

data class ReceivedLunchState (
    val isLoading : Boolean = false,
    val error : String? = "",
    val success : ReceivedLunches? =  null

)
