package com.essycynthia.calibanfoodmobile.data.remote.data_classes

data class SignUpResponseData(
    val bank_code: Any,
    val bank_name: Any,
    val bank_number: Any,
    val bank_region: Any,
    val created_at: String,
    val currency: Any,
    val currency_code: Any,
    val email: String,
    val first_name: String,
    val id: Int,
    val is_admin: Boolean,
    val is_deleted: Boolean,
    val last_name: String,
    val lunch_credit_balance: Any,
    val org_id: Any,
    val password_hash: String,
    val phone: String,
    val profile_pic: Any,
    val refresh_token: Any,
    val updated_at: String
)