package com.essycynthia.calibanfoodmobile.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.essycynthia.calibanfoodmobile.colleaguescreen.StaffProfileScreen
import com.essycynthia.calibanfoodmobile.ui.home_screen.HomeScreen
import com.essycynthia.calibanfoodmobile.ui.profile_screen.ProfilePage
import com.essycynthia.calibanfoodmobile.ui.reward_screen.ReceivedRewardHistoryScreen
import com.essycynthia.calibanfoodmobile.ui.reward_screen.RewardHistoryDetailedScreen
import com.essycynthia.calibanfoodmobile.ui.withdrawal_screen.WithdrawPage

@Composable
fun BottomNavGraph(navContoller: NavHostController) {

    NavHost(navController = navContoller, startDestination = BottomScreens.HomeScreen.route){
        composable(BottomScreens.HomeScreen.route) {
            HomeScreen()
        }
        composable(BottomScreens.ProfileScreen.route) {
            ProfilePage()
        }
        composable(BottomScreens.WithdrawalScreen.route) {
            WithdrawPage()
        }
        composable (BottomScreens.RewardScreen.route) {
            ReceivedRewardHistoryScreen()
        }
    }



}