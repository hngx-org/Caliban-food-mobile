package com.essycynthia.calibanfoodmobile.staffNavigation

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.essycynthia.calibanfoodmobile.HomeDestination
import com.essycynthia.calibanfoodmobile.ProfileDestination
import com.essycynthia.calibanfoodmobile.R
import com.essycynthia.calibanfoodmobile.RewardDestination
import com.essycynthia.calibanfoodmobile.WithdrawDestination
import com.essycynthia.calibanfoodmobile.allDestinations
import com.essycynthia.calibanfoodmobile.dummyData.RewardHistory
import com.essycynthia.calibanfoodmobile.staffNavigation.Screens.HomeScreen
import com.essycynthia.calibanfoodmobile.staffNavigation.Screens.ProfileScreen
import com.essycynthia.calibanfoodmobile.staffNavigation.Screens.RewardsScreen
import com.essycynthia.calibanfoodmobile.staffNavigation.Screens.withdrawal_screen.WithdrawScreen
import com.essycynthia.calibanfoodmobile.ui.theme.CalibanFoodMobileTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

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
                            HomeScreen(
                                navController = navController,
                                onNavigateToReward = {
                                    selectedItem = 1
                                }
                            )
                        }
                        composable(RewardDestination.route) { RewardsScreen() }
                        composable(WithdrawDestination.route) { WithdrawScreen() }
                        composable(ProfileDestination.route) { ProfileScreen() }
                    }
                }
            }
        }
    }
}



@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun FreeLunchDashBoard(
    freeLunchAmount: Int,
    modifier: Modifier = Modifier,
   navController: NavController
) {



    Card(
        //  color = Color(0xFFFF9405),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFF9405)
        ),
        shape = RoundedCornerShape(size = (5.dp)),
        modifier = modifier
            //.clip(shape = ShapeDefaults.Small)
            .fillMaxWidth()
            .height(170.dp)
            .padding(start = 16.dp, end = 16.dp,)

    ) {
        Column(

            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
           // modifier = modifier.padding(16.dp)
        ) {
            Row(

                horizontalArrangement = Arrangement.spacedBy(200.dp)
            ) {

                Text(
                    text = "Free Lunch",
                    modifier = Modifier.padding(top = 14.dp, start = 8.dp),

                    // H3 (Semi Bold)
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppinsemibold)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFFFFFFFF),
                        letterSpacing = 0.02.sp,
                    )
                )


                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = "User Image",
                    modifier
                        .padding(top = 14.dp, end = 8.dp)
                        .height(36.dp)
                        .width(36.dp)
                        .clip(shape = ShapeDefaults.Small)
                        .size(36.dp),

                    alignment = Alignment.TopEnd

                )
            }
          //  Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "$freeLunchAmount",

                // H1 (Bold)
                style = TextStyle(
                    fontSize = 28.sp,
                    fontFamily = FontFamily(Font(R.font.poppins)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),
                    letterSpacing = 0.07.sp,
                    textAlign = TextAlign.Center
                )
            )


            Button(


                        onClick = {
                         ///   navController.navigate(BottomScreens.WithdrawalScreen.route)
                                 // navController.navigate("withdraw_screen")

                          },
              //  onClick = { navController.navigate(BottomScreens.WithdrawalScreen.route)},
                enabled = true,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary
                ),
                shape = ShapeDefaults.Small,
                modifier = modifier

                    .width(300.dp)
            ) {
                Text(
                    text = "Withdraw Lunch",

                    // Button
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.roboto)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFFFF9405),
                        letterSpacing = 0.15.sp,
                    )
                )

            }
        }
    }
}

@Composable
fun SendLunchReward(modifier: Modifier = Modifier) {

    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 20.dp)
            .fillMaxWidth()
            .width(343.dp)
            .height(140.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFFFFF)
        ),
        shape = RoundedCornerShape(size = 10.dp)


    )
  {
        Row(

            horizontalArrangement = Arrangement.spacedBy(38.dp)


        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Recognize your colleague for their \n " +
                            "outstanding work by sending them \n" +
                            "Free Lunch rewards. \uD83D\uDC4F \uD83C\uDF1F",
                    modifier = Modifier
                        .width(198.dp)
                        .height(54.dp),

// Small Body (Regular)
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 18.sp,
                        fontFamily = FontFamily(Font(R.font.roboto)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF333333),
                        letterSpacing = 0.03.sp,
                    )

                )

                Button(
                    modifier = modifier.padding(top = 10.dp),
                    onClick = { },
                    enabled = true,
                    colors = ButtonDefaults.buttonColors(Color(0xFFFF9405)),
                    shape = ShapeDefaults.Small
                ) {

                    Text(
                        text = "Send Lunch Reward",

                        // Button
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.roboto)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFFFFFFFF),
                            letterSpacing = 0.15.sp,
                        )
                    )

                }
            }

            Image(
                painter = painterResource(id = R.drawable.interracial),
                contentDescription = "An Interracial couple",
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()

            )
        }


    }
}

@Composable
fun RewardHistoryList(
    rewardHistories: List<RewardHistory>,
    modifier: Modifier = Modifier
) {
    //make lazy list
    Row(
        modifier = Modifier
            .fillMaxWidth()//check
            .padding(top = 20.dp, bottom = 15.dp),
        horizontalArrangement = Arrangement.spacedBy(160.dp, Alignment.Start),
        verticalAlignment = Alignment.Top,
    ) {

        Text(
            text = "Reward history",
            modifier = Modifier
                .padding(start = 15.dp)
                .width(128.dp),



            // Body Text (Medium)
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.robotomedium)),
                fontWeight = FontWeight(500),
                color = Color(0xFF75818F),
                letterSpacing = 0.07.sp,
            )
        )
        // Child views.

        Text(
            text = "See all",
            modifier = Modifier
                .padding()
                .width(39.dp)
                .height(15.dp),

            // Small Body (Medium)
            style = TextStyle(
                fontSize = 13.sp,
                fontFamily = FontFamily(Font(R.font.robotomedium)),
                fontWeight = FontWeight(500),
                color = Color(0xFFFF9405),
                letterSpacing = 0.03.sp,
            )
        )
    }


    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
    ) {
        items(rewardHistories) { rewardHistory ->
            RewardHistoryElement(
                rewardHistory = rewardHistory
            )
        }
    }
}


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun RewardHistoryElement(
        rewardHistory: RewardHistory
    ) {
        Surface(
            onClick = {  },
            color = Color.White,
            modifier = Modifier

                //.fillMaxWidth()
                .padding(horizontal = 5.dp),
            shape = RoundedCornerShape(5.dp)
        ) {


            Column(modifier = Modifier.padding(horizontal = 15.dp, vertical = 11.dp)) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.orgbuyer),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.size(10.dp))
                    Text(
                        text = "Essy Sent you free lunch ",
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 18.sp,
                            fontFamily = FontFamily(Font(R.font.roboto)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF333333),
                            letterSpacing = 0.03.sp,
                        ),
                        modifier = Modifier.weight(1f)
                    )

                    Text(
                        text = "3",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.poppins)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFFFF9405),
                            letterSpacing = 0.02.sp,
                        )
                    )

                    Image(
                        painter = painterResource(id = R.drawable.pot_of_food),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .size(16.dp)
                            .padding(1.dp)
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "3hrs",
                        style = TextStyle(
                            fontSize = 10.sp,
                            lineHeight = 15.sp,
                            fontFamily = FontFamily(Font(R.font.roboto)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF75818F),
                            letterSpacing = 0.04.sp,
                        )
                    )
                }
            }
        }
    }





