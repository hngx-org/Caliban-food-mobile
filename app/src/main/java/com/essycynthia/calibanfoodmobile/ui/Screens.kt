package com.essycynthia.calibanfoodmobile.ui

sealed class Screens (val route : String){
    object LoginScreen : Screens("login")
    object SignUpScreen : Screens("sign_up")
    object ReceivedRewardDetailScreen : Screens("reward_details")
    object SendLunchScreen : Screens("send_lunch")
    object StaffProfileScreen : Screens("staff_profile")
    object ColleagueProfileScreen : Screens("colleague_profile")

}