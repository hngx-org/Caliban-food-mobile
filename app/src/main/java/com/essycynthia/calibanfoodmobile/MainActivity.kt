package com.essycynthia.calibanfoodmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

import com.essycynthia.calibanfoodmobile.ui.theme.CalibanFoodMobileTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // for splash screen


        setContent {
            CalibanFoodMobileTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    actionBar?.hide()
                    installSplashScreen()
                    Navigation()
//                    HomeScreen()



                }
            }
        }
    }
}

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
            .height(200.dp)
            .padding(start = 16.dp, end = 16.dp)

    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier.padding(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(200.dp)
            ) {

                Text(
                    text = "Free Lunch",

                    // H3 (Semi Bold)
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppinsemibold)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFFFFFFFF),
                        letterSpacing = 0.02.sp,
                    )
                )
                /*
                                Text(
                                    text = "Free Lunch",
                                    style = MaterialTheme.typography.headlineSmall,
                                    color = MaterialTheme.colorScheme.onPrimary
                                )*/

                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = "User Image",
                    modifier
                        .height(36.dp)
                        .width(36.dp)
                        .clip(shape = ShapeDefaults.Small)
                        .size(36.dp),
                    alignment = Alignment.TopEnd

                )
            }
            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "$freeLunchAmount",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth() // Add this modifier

            )
            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = { navController.navigate(BottomScreens.WithdrawalScreen.route)},
                enabled = true,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary
                ),
                shape = ShapeDefaults.Small,
                modifier = modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Withdraw Lunch",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
fun SendLunchReward(modifier: Modifier = Modifier) {
    Surface(
        color = MaterialTheme.colorScheme.onPrimary,
        modifier = modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .border(
                width = 2.dp, // Adjust the border width as needed
                color = Color.Black, // Adjust the border color as needed
                shape = RoundedCornerShape(10.dp)
            )
            .fillMaxWidth()
            .height(160.dp)
            .padding(start = 16.dp, end = 16.dp, top = 20.dp)
    ) {
        Row(

            horizontalArrangement = Arrangement.spacedBy(38.dp)


        ) {
            Column {
                Text(
                    text = "Recognize your colleague for their \n " +
                            "outstanding work by sending them \n" +
                            "Free Lunch rewards. \uD83D\uDC4F \uD83C\uDF1F"
                )

                Button(
                    modifier = modifier.padding(top = 10.dp),
                    onClick = { /*TODO*/ },
                    enabled = true,
                    colors = ButtonDefaults.buttonColors(Color(0xFFFF9405)),
                    shape = ShapeDefaults.Small
                ) {
                    Text(
                        text = "Send Lunch Reward",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }

            Image(
                painter = painterResource(id = R.drawable.interracial),
                contentDescription = "An Interracial couple",
                Modifier
                    .height(250.dp)
                    .width(30.dp)
            )
        }


    }
}

@Composable
fun RewardHistoryList(
    rewardHistories: List<RewardHistory>,
    modifier: Modifier = Modifier
) {
    Row() {
        Text(text = "Reward History",modifier = Modifier.padding(horizontal = 12.dp))
        Spacer(Modifier.width(200.dp))
        Text(text = "See All", color = Color(0xFFFF9405), fontSize = 10.sp)
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


    @Composable
    fun RewardHistoryElement(
        rewardHistory: RewardHistory
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.orgbuyer),
                    contentDescription = "Image",
                    modifier = Modifier.size(30.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Essy sent you a free lunch")
                Spacer(modifier = Modifier.weight(1f))
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.pot_of_food),
                    contentDescription = "Pot of Food",
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    }



//    private fun sampleCardData(): List<CardData> {
//        return listOf(
//            CardData(R.drawable.orgbuyer, "UduakE", 100, 3),
//            // Add more CardData objects as needed
//        )
//    }
