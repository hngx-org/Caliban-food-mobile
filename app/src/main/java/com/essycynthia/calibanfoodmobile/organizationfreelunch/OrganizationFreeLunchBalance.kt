package com.essycynthia.calibanfoodmobile.organizationfreelunch


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.essycynthia.calibanfoodmobile.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrganizationFreeLunchReward(cards: List<CardData>) {

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
// var cardDataList = listOf(CardData(R.drawable.orgbuyer,"UduakE",100,3))

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Organization",

                        // H3 (Semi Bold)
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.poppinsemibold)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFF333333),
                            letterSpacing = 0.02.sp,
                        )
                    )

                }, colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFFFAFAFA),
                    titleContentColor = Color(0xFF333333)
                ),
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(id = R.drawable.leftarrowiconframe),
                            contentDescription = "arrow",
                            Modifier
                                .padding(1.dp)
                                .width(24.dp)
                                .height(24.dp)
                        )

                    }
                },
                scrollBehavior = scrollBehavior

            )
        }

    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = 100.dp,
                    start = 20.dp,
                    end = 20.dp,
                    bottom = 24.dp
                )
        ) {
            item {


                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(343.dp)
                        .height(160.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFFFFFFF)
                    ),
                    shape = RoundedCornerShape(size = 10.dp)


                ) {

                    Row(modifier = Modifier
                        .padding(start = 4.dp, top = 8.dp, end = 4.dp)
                        .width(301.dp)
                        .height(48.dp),
                        horizontalArrangement = Arrangement.spacedBy(109.dp, Alignment.Start),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        // Child views.






                        Text(text = "Organization\nFree lunch balance",
// H3 (Semi Bold)
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = FontFamily(Font(R.font.poppinsemibold)),
                                fontWeight = FontWeight(600),
                                color = Color(0xFF333333),
                                letterSpacing = 0.02.sp,
                            ),
                            modifier = Modifier
                                .width(156.dp)
                                .height(48.dp)


                        )

                        Image(painter = painterResource(id = R.drawable.avatar),
                            contentDescription = "avatar",
                            modifier = Modifier
                                .width(36.dp)
                                .height(36.dp)
                            //.clip(RoundedCornerShape())


                        )
                    }


                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = "10,000",
                            modifier = Modifier.padding(bottom = 4.dp),

                            // H1 (Bold)
                            style = TextStyle(
                                fontSize = 28.sp,
                                fontFamily = FontFamily(Font(R.font.poppinsemibold)),
                                fontWeight = FontWeight(700),
                                color = Color(0xFF333333),
                                letterSpacing = 0.07.sp,
                                textAlign = TextAlign.Center
                            )
                        )

                        Button(onClick = {

                        },modifier = Modifier
                            .padding(top = 18.dp)
                            .width(300.dp)
                            .height(34.dp),

                            shape = RoundedCornerShape(size = 5.dp),
                            colors = ButtonDefaults.buttonColors(Color(0xFFFF9405)),

                            ) {

                            Text(
                                text = "Buy free Lunch credit",
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(14.dp),

                                // Button
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontFamily = FontFamily(Font(R.font.robotomedium)),
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFFFFFFFF),
                                    letterSpacing = 0.15.sp,
                                )
                            )

                        }






                    }


                }








            }

            item {
                //make lazy list
                Row(
                    modifier = Modifier
                        .fillMaxWidth()//check
                        .padding(top = 38.dp),
                    horizontalArrangement = Arrangement.spacedBy(150.dp, Alignment.Start),
                    verticalAlignment = Alignment.Top,
                ) {

                    Text(
                        text = "Transaction history",
                        modifier = Modifier
                            .width(128.dp)
                            .height(16.dp),


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
            }



            items(cards){  cardData ->

                Card (
                    modifier =      Modifier
                        .padding(top = 28.dp)
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
                    ) {
                        // Child views.

                        Image(
                            painter = painterResource(id = cardData.userImageId),
                            contentDescription = "image description",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .padding(end = 10.dp)
                                .width(30.dp)
                                .height(30.dp)
                        )

                        Text(
                            text = "you sent${cardData.user} a reward",
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
                            text = "${cardData.lunchReward}",
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
                            )
                        )

                        Image(
                            painter = painterResource(id = R.drawable.emojionepotoffood),
                            contentDescription = "image description",
                            contentScale = ContentScale.None,
                            modifier = Modifier
                                .padding(start = 1.dp)
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
                            text = "${cardData.time}",
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



                    // Child views.

                }


            }

        }





    }

}

