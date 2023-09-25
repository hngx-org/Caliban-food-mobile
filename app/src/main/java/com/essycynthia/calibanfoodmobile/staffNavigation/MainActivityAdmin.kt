package com.essycynthia.calibanfoodmobile.staffNavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.essycynthia.calibanfoodmobile.HomeDestination
import com.essycynthia.calibanfoodmobile.HomeScreenAdmin
import com.essycynthia.calibanfoodmobile.ProfileDestination
import com.essycynthia.calibanfoodmobile.ProfileScreenAdmin
import com.essycynthia.calibanfoodmobile.RewardDestination
import com.essycynthia.calibanfoodmobile.RewardsScreenAdmin
import com.essycynthia.calibanfoodmobile.WithdrawDestination
import com.essycynthia.calibanfoodmobile.WithdrawScreenAdmin
import com.essycynthia.calibanfoodmobile.allDestinations
import com.essycynthia.calibanfoodmobile.staffNavigation.Screens.HomeScreen
import com.essycynthia.calibanfoodmobile.staffNavigation.Screens.ProfileScreen
import com.essycynthia.calibanfoodmobile.staffNavigation.Screens.RewardsScreen
import com.essycynthia.calibanfoodmobile.staffNavigation.Screens.withdrawal_screen.WithdrawScreen
import com.essycynthia.calibanfoodmobile.ui.theme.CalibanFoodMobileTheme

class MainActivityAdmin : ComponentActivity() {

    private var selectedItem by mutableStateOf(0)
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalibanFoodMobileTheme {
                val navController = rememberNavController()

                Scaffold(
                    bottomBar = {
                        NavigationBar {
                            allDestinations.forEachIndexed { index, item ->
                                NavigationBarItem(
                                    icon = { Icon(imageVector = item.icon, contentDescription = item.route) },
                                    label = { Text(text = item.label) },
                                    selected = selectedItem == index,
                                    onClick = {
                                        selectedItem = index
                                        navController.navigate(item.route)  {
//                                            popUpTo(navController.graph.findStartDestination().id) { saveState = true }
//                                            launchSingleTop = true
//                                            restoreState = true
                                        }
                                    }
                                )
                            }
                        }
                    }
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = HomeDestination.route,
                        modifier = Modifier.padding(it)
                    ) {
                        composable(HomeDestination.route) {
                            HomeScreenAdmin(
                                this@MainActivityAdmin,
                                navController = navController,
                                onNavigateToReward = {
                                    selectedItem = 1
                                }
                            )
                        }
                        composable(RewardDestination.route) { RewardsScreenAdmin() }
                        composable(WithdrawDestination.route) { WithdrawScreenAdmin() }
                        composable(ProfileDestination.route) { ProfileScreenAdmin() }
                    }
                }
            }
        }
    }
}

