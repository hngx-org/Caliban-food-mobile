package com.essycynthia.calibanfoodmobile.staffNavigation.viewmodel

import com.essycynthia.calibanfoodmobile.data.remote.ResetPassword
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.ReceivedLunches
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.ResetPasswordEmail

data class ResetPasswordState (
    val isLoading : Boolean = false,
    val error : String? = "",
    val success : ResetPasswordEmail? =  null
)
