package com.essycynthia.calibanfoodmobile.ui.navigation.user_authenticated_nav

import CreateAccountViewModel
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.essycynthia.calibanfoodmobile.ui.Screens
import com.essycynthia.calibanfoodmobile.ui.navigation.bottom_nav.BottomScreens
import com.essycynthia.calibanfoodmobile.ui.create_account_screen.CreateAccountScreen
import com.essycynthia.calibanfoodmobile.ui.home_screen.HomeScreen
import com.essycynthia.calibanfoodmobile.ui.login_screen.LoginScreen

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun UserAuthenticationNavGraph(navController: NavHostController) {
val viewModel : CreateAccountViewModel = hiltViewModel()
    NavHost(navController = navController, startDestination =Screens.SignUpScreen.route) {
        composable(Screens.SignUpScreen.route) {
            CreateAccountScreen(Modifier.padding(2.dp),navController)
        }
        composable(Screens.LoginScreen.route) {
            LoginScreen()
        }
        composable(BottomScreens.HomeScreen.route) {
            HomeScreen()
        }
    }
}