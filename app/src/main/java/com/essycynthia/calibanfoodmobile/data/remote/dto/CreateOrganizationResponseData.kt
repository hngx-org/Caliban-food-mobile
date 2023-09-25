package com.essycynthia.calibanfoodmobile.data.remote.dto

data class CreateOrganizationResponseData(
    val id: Int,
    val lunch_price: Int,
    val organization_name: String,
    val user_id: Int
)