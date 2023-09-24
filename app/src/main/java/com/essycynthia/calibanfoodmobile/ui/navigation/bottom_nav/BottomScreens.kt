package com.essycynthia.calibanfoodmobile.ui.navigation.bottom_nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CardGiftcard
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoneyOff
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomScreens(val route: String, val icon: ImageVector, val title: String) {
    object HomeScreen : BottomScreens("main_screen", Icons.Default.Home, "Home")
    object ProfileScreen : BottomScreens("profile_screen", Icons.Default.Person, "Profile")
    //check
    object WithdrawalScreen : BottomScreens("withdraw_screen", Icons.Default.MoneyOff, "Withdraw")
    object RewardScreen :  BottomScreens("reward_screen", Icons.Default.CardGiftcard, "Reward")
}
