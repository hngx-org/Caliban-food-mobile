package com.essycynthia.calibanfoodmobile.ui.navigation.user_authenticated_nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@Composable
fun UserAuthenticatedNavigation(){
    val navController = rememberNavController()
UserAuthenticationNavGraph(navController = navController)
}