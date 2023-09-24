package com.essycynthia.calibanfoodmobile.ui.navigation.user_authenticated_nav

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun UserAuthenticatedNavigation(){
    val navController = rememberNavController()
UserAuthenticationNavGraph(navController = navController)
}