package com.essycynthia.calibanfoodmobile


import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
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
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavController
import com.essycynthia.calibanfoodmobile.dummyData.RewardHistory
import com.essycynthia.calibanfoodmobile.ui.BottomScreens
import com.essycynthia.calibanfoodmobile.ui.Navigation

import com.essycynthia.calibanfoodmobile.ui.theme.CalibanFoodMobileTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
/*

        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = true
        window.statusBarColor = Color(0xFFFAFAFA).toArgb()
*/

        // for splash screen


        setContent {
            CalibanFoodMobileTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//check
                    actionBar?.hide()
                    installSplashScreen()
                    Navigation()
//                    HomeScreen()



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
            .height(160.dp)
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
                       // .height(36.dp)
                      //  .width(36.dp)
                       .clip(shape = ShapeDefaults.Small)
                        .size(50.dp),
                    alignment = Alignment.TopEnd

                )
            }
         //   Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "$freeLunchAmount",
                modifier = Modifier.fillMaxWidth(), // Add this modifier

                // H1 (Bold)
                style = TextStyle(
                    fontSize = 28.sp,
                    fontFamily = FontFamily(Font(R.font.poppins)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),
                    letterSpacing = 0.07.sp,
                    textAlign = TextAlign.Center,
                )
            )

            Spacer(modifier = Modifier.height(0.dp))

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
    Surface(
        color = MaterialTheme.colorScheme.onPrimary,
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp, top = 20.dp)
           // .fillMaxWidth()
            .width(343.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .border(
                width = 1.dp, // Adjust the border width as needed
                color = Color(0xFFE6E9F0), // Adjust the border color as needed
                shape = RoundedCornerShape(10.dp)
            )

            .height(160.dp)

    ) {
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
                    modifier = Modifier.padding(top = 10.dp, start = 7.dp),
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
                    modifier = modifier.padding(top = 22.dp),
                    onClick = { /*TODO*/ },
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
                    .width(154.00008.dp)
                    .height(160.81921.dp)
                    .fillMaxSize()
                  //  .padding(top = 2.45745.dp, end = 5.73405.dp, bottom = 3.27659.dp)
               /* Modifier
                    .height(250.dp)
                    .width(30.dp)*/
            )
        }


    }
}

@Composable
fun RewardHistoryList(
    rewardHistories: List<RewardHistory>,
    modifier: Modifier = Modifier
) {
    Row(modifier = Modifier.padding(start = 16.dp)) {
        Text(
            text = "Reward History",

            // Body Text (Medium)
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.roboto)),
                fontWeight = FontWeight(500),
                color = Color(0xFF75818F),
                letterSpacing = 0.07.sp,
            )
        )
       /* Text(text = "Reward History",modifier = Modifier.padding(horizontal = 12.dp))*/
        Spacer(Modifier.width(200.dp))
        Text(
            text = "See all",

            // Small Body (Medium)
            style = TextStyle(
                fontSize = 13.sp,
                fontFamily = FontFamily(Font(R.font.roboto)),
                fontWeight = FontWeight(500),
                color = Color(0xFFFF9405),
                letterSpacing = 0.03.sp,
            )
        )
      /*  Text(text = "See All", color = Color(0xFFFF9405), fontSize = 10.sp)*/
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

            Card (
                modifier =      Modifier
                    .padding(top = 40.dp)
                    .width(344.dp)
                    .height(69.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFFFFFFF)
                ),

                shape = RoundedCornerShape(size = 5.dp)
                //.padding(start = 15.dp, top = 11.dp, end = 15.dp, bottom = 11.dp)

            ){
                Row(
                    modifier = Modifier.padding(top = 11.dp, start = 15.dp, bottom = 11.dp, end = 15.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically,
                ){

                    Image(
                        painter = painterResource(R.drawable.orgbuyer),
                        contentDescription = "Image",
                        modifier = Modifier.size(30.dp)
                    )


                    Text(
                        text = "Essy Sent you a free lunch",
                        modifier = Modifier
                            .padding(end = 35.dp)
                            .width(144.dp)
                            .height(18.dp),
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 18.sp,
                            fontFamily = FontFamily(Font(R.font.robotomedium)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF333333),
                            letterSpacing = 0.03.sp,
                        )
                    )

                    Text(
                        text = "3",
                        Modifier
                            // .padding(end =5.dp)
                            .width(27.dp)
                            .height(24.dp),


                        // H3 (Semi Bold)
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.poppinsemibold)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFFFF9405),
                            letterSpacing = 0.02.sp,
                        ))


                    Image(
                        painter = painterResource(id = R.drawable.pot_of_food),
                        contentDescription = "image description",
                        contentScale = ContentScale.None,
                        modifier = Modifier
                            .padding(start = 1.dp)
                            .size(20.dp)
                        // .width(16.dp)
                        //  .height(16.dp)
                        // .size(20.dp)
                    )


                }

                Column(
                    modifier = Modifier
                        .width(314.dp)
                        .height(47.dp),
                    verticalArrangement = Arrangement.spacedBy(2.dp, Alignment.Bottom),
                    horizontalAlignment = Alignment.End,
                ) {

                    Text(
                        text = "3hrs",
                        modifier  = Modifier
                            .width(20.dp)
                            .height(15.dp),

                        // Caption
                        style = TextStyle(
                            fontSize = 10.sp,
                            lineHeight = 15.sp,
                            fontFamily = FontFamily(Font(R.font.robotoregular)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF75818F),
                            letterSpacing = 0.04.sp,
                        )
                    )
                    // Child views.
                }



            }

           /* Row(
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
                )*/


            }
        }



//    private fun sampleCardData(): List<CardData> {
//        return listOf(
//            CardData(R.drawable.orgbuyer, "UduakE", 100, 3),
//            // Add more CardData objects as needed
//        )
//    }
