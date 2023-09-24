package com.essycynthia.calibanfoodmobile.ui.navigation.user_authenticated_nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.essycynthia.calibanfoodmobile.ui.Screens
import com.essycynthia.calibanfoodmobile.ui.navigation.bottom_nav.BottomScreens
import com.essycynthia.calibanfoodmobile.ui.create_account_screen.CreateAccountScreen
import com.essycynthia.calibanfoodmobile.ui.home_screen.HomeScreen
import com.essycynthia.calibanfoodmobile.ui.login_screen.LoginScreen

@Composable
fun UserAuthenticationNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination =Screens.SignUpScreen.route) {
        composable(Screens.SignUpScreen.route) {
            CreateAccountScreen()
        }
        composable(Screens.LoginScreen.route) {
            LoginScreen()
        }
        composable(BottomScreens.HomeScreen.route) {
            HomeScreen()
        }
    }
}