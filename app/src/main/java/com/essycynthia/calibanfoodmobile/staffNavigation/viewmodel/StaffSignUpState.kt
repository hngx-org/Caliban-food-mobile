package com.essycynthia.calibanfoodmobile.staffNavigation.viewmodel

import com.essycynthia.calibanfoodmobile.data.remote.data_classes.LoginResponse
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.StaffSignUpResponse

data class StaffSignUpState(
    val isLoading : Boolean = false,
    val error : String? = "",
    val success :StaffSignUpResponse? = null
)
