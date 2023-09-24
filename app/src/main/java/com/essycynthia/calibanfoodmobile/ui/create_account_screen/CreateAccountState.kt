package com.essycynthia.calibanfoodmobile.ui.create_account_screen

import com.essycynthia.calibanfoodmobile.data.remote.dto.SignUpResponseDto

data class CreateAccountState(
    val isLoading : Boolean = false,
    val error : String? = "",
    val success : SignUpResponseDto? =  null
)
