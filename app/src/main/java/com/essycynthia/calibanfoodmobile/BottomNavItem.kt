package com.essycynthia.calibanfoodmobile

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector

interface BottomNavItem {
    val route: String
    val icon: ImageVector
    val label: String
}

object HomeDestination: BottomNavItem {
    override val route: String = "home"
    override val icon: ImageVector = Icons.Outlined.Home
    override val label: String = "Home"
}

object RewardDestination: BottomNavItem {
    override val route: String = "reward"
    override val icon: ImageVector = Icons.Outlined.List
    override val label: String = "Reward"
}

object WithdrawDestination: BottomNavItem {
    override val route: String = "withdraw"
    override val icon: ImageVector = Icons.Outlined.DateRange
    override val label: String = "Withdraw"
}

object ProfileDestination: BottomNavItem {
    override val route: String = "profile"
    override val icon: ImageVector = Icons.Outlined.Person
    override val label: String = "Profile"
}

val allDestinations = listOf(
    HomeDestination,
    RewardDestination,
    WithdrawDestination,
    ProfileDestination,
)