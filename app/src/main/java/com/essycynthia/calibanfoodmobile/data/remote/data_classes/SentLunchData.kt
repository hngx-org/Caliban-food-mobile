package com.essycynthia.calibanfoodmobile.data.remote.data_classes

data class SentLunchData(
    val created_at: String,
    val id: Int,
    val is_deleted: Boolean,
    val note: String,
    val org_id: Int,
    val quantity: Int,
    val receiver_id: Int,
    val redeemed: Boolean,
    val sender_id: Int,
    val updated_at: String
)