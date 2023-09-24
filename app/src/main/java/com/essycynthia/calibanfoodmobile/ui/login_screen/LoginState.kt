package com.essycynthia.calibanfoodmobile.ui.login_screen

import com.essycynthia.calibanfoodmobile.data.remote.data_classes.LoginResponse

data class LoginState(
    val isLoading : Boolean = false,
    val error : String? = "",
    val success :LoginResponse? = null
)
