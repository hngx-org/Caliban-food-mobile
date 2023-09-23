package com.essycynthia.calibanfoodmobile.colleaguescreen


data class StaffProfile(
    val imageId:Int,
    val name: String,
    val userName: String,
    val jobRole: String,
    val department: String,
    val location: String,
    val freeLunchReceived: Int,
    val freeLunchGiven: Int
)