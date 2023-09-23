package com.essycynthia.calibanfoodmobile.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation() {
    val navController = rememberNavController()
    val screens = listOf(
        BottomScreens.HomeScreen,
        BottomScreens.ProfileScreen,
        BottomScreens.WithdrawalScreen,
        BottomScreens.RewardScreen
    )
    androidx.compose.material.Scaffold(bottomBar = {
        BottomNavigation(modifier = Modifier.padding(16.dp)) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            screens.forEach {
                BottomNavigationItem(
                    selected = currentRoute == it.route,
                    label = {
                        Text(
                            text = it.title,
                            color = if (currentRoute == it.route) Color(0xFFFF9405) else Color.LightGray,
                            fontSize = 10.sp
                        )
                    },
                    onClick = {
                        if (currentRoute != it.route) {
                            navController.graph?.startDestinationRoute?.let {
                                navController.popBackStack(it, true)
                            }
                            navController.navigate(it.route) {
                                launchSingleTop = true
                            }

                        }
                    },
                    icon = {
                        Icon(
                            imageVector = it.icon,
                            contentDescription = null,
                            tint = if (currentRoute == it.route) Color.Red else Color.LightGray
                        )
                    })

            }
        }
    }
        ) {
        BottomNavGraph(navContoller = navController)

    }


}

