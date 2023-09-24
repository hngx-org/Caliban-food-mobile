package com.essycynthia.calibanfoodmobile.ui.home_screen

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PersonAdd
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController

import com.essycynthia.calibanfoodmobile.dummyData.colleaguesList
import com.essycynthia.calibanfoodmobile.homeuiscreen.FreeLunchDashBoard
import com.essycynthia.calibanfoodmobile.homeuiscreen.RewardHistoryList
import com.essycynthia.calibanfoodmobile.homeuiscreen.SendLunchReward

@RequiresApi(Build.VERSION_CODES.Q)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(32.dp), // Reduce the height to 32.dp
                title = {
                    Text(text = "Welcome Essy  \uD83D\uDC4B,")
                },
                actions = {
                    IconButton(
                        onClick = {
                            // Handle the action when the first icon is clicked
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Search,
                            contentDescription = "Icon 1"
                        )
                    }
                    IconButton(
                        onClick = {
                            // Handle the action when the second icon is clicked
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.PersonAdd,
                            contentDescription = "Icon 2"
                        )
                    }
                    IconButton(
                        onClick = {
                            // Handle the action when the third icon is clicked
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Settings,
                            contentDescription = "Icon 3"
                        )
                    }
                }
            )
        },
        content = {
            Column {
                Spacer(modifier = Modifier.height(40.dp)) // Add spacing between content
                FreeLunchDashBoard(freeLunchAmount = 10)
                Spacer(modifier = Modifier.height(16.dp)) // Add spacing between content
                SendLunchReward()
                Spacer(modifier = Modifier.height(16.dp)) // Add spacing between content
                RewardHistoryList(colleaguesList)
            }
        }
    )
}

