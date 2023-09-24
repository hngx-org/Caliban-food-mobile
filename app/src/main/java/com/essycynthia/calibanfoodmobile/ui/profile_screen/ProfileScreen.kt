package com.essycynthia.calibanfoodmobile.ui.profile_screen


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.essycynthia.calibanfoodmobile.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ProfilePage() {
    var image by remember {
        mutableStateOf(R.drawable.profileimage)
    }
    var name by remember { mutableStateOf("Gbemisola Owolabi") }
    var userName by remember { mutableStateOf("@gbemiglad") }
    var role by remember { mutableStateOf("Product Designer") }
    var membership by remember { mutableStateOf("Member of HNG Team") }
    var location by remember { mutableStateOf("Lagos, Nigeria") }
    var lunchRecieved by remember { mutableStateOf("14") }
    var lunchGiven by remember { mutableStateOf("10") }
    var title by remember { mutableStateOf("Profile") }
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())



    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    // H3 (Semi Bold)
                    Text(
                        text = title,
                        fontSize = 16.sp,

                        fontFamily = FontFamily(Font(R.font.poppinsemibold)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFF333333),
                        letterSpacing = 0.02.sp
                    )
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Default.ExitToApp,
                            contentDescription = "Logout"
                        )


                    }
                },

                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color(0xFF333333)
                ),



                scrollBehavior = scrollBehavior
            )
        }

    ) {
        LazyColumn(
            modifier = Modifier
                // .background(Color.Green)
                .fillMaxSize()
                .padding(top = 60.dp, start = 20.dp, end = 20.dp)
        ) {
            item {

                Image(
                    painter = painterResource(image),
                    contentDescription = "profile image",
                    modifier = Modifier
                        .width(343.dp)
                        .height(270.dp),

                    )


            }

            item {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 20.dp)
                ) {
                    // Small Body (Medium)

                    Text(
                        text = name,
                        fontSize = 13.sp,
                        fontWeight = FontWeight(600),
                        fontFamily = FontFamily(Font(R.font.robotomedium)),
                        color = Color(0xFF333333),
                        letterSpacing = 0.03.sp
                    )

                    // Small Body (Regular)
                    Text(
                        text = userName,
                        modifier = Modifier
                            .padding(top = 10.dp),
                        fontSize = 12.sp,
                        lineHeight = 18.sp,
                        fontFamily = FontFamily(Font(R.font.robotoregular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF333333),
                        letterSpacing = 0.03.sp
                    )

                    Row(
                        modifier = Modifier.padding(top = 10.dp)


                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.role),
                            contentDescription = "role",
                            modifier = Modifier
                                .size(14.dp)
                        )

                        Spacer(modifier = Modifier.width(6.dp))

                        Text(
                            text = role,
                            // Small Body (Regular)
                            fontSize = 12.sp,
                            lineHeight = 18.sp,
                            fontFamily = FontFamily(Font(R.font.robotoregular)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF333333),
                            letterSpacing = 0.03.sp,
                        )
                    }

                    Row(
                        modifier = Modifier.padding(top = 10.dp)


                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.membership),
                            contentDescription = "membership",
                            modifier = Modifier
                                .size(14.dp)
                        )

                        Spacer(modifier = Modifier.width(6.dp))

                        Text(
                            text = membership,
                            // Small Body (Regular)
                            fontSize = 12.sp,
                            lineHeight = 18.sp,
                            fontFamily = FontFamily(Font(R.font.robotoregular)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF333333),
                            letterSpacing = 0.03.sp,
                        )
                    }





                    Row(
                        modifier = Modifier.padding(top = 10.dp)


                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.location),
                            contentDescription = "location",
                            modifier = Modifier
                                .size(14.dp)
                        )

                        Spacer(modifier = Modifier.width(6.dp))

                        Text(
                            text = location,
                            // Small Body (Regular)
                            fontSize = 12.sp,
                            lineHeight = 18.sp,
                            fontFamily = FontFamily(Font(R.font.robotoregular)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF333333),
                            letterSpacing = 0.03.sp,
                        )
                    }

                    Column(
                        modifier = Modifier.padding(top = 20.dp),
                        //verticalArrangement = Arrangement.spacedBy(30.dp)


                    ) {

                        // H3 (Semi Bold)
                        Text(
                            text = "Overview",
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.poppinsemibold)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFF333333),
                            letterSpacing = 0.02.sp,
                        )

                    }

                    //card composable for lunch received and given

                    Row(modifier = Modifier.padding(top = 20.dp))
                    {
                        Card(
                            elevation = CardDefaults.cardElevation(defaultElevation = 15.dp),
                            modifier = Modifier
                                .weight(1F)
                                .width(165.dp)
                                .height(120.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFF3F61DB)
                            ),
                            shape = RoundedCornerShape(size = (5.dp))
                            // .weight(1F)

                        ) {
                            Column(
                                modifier = Modifier
                                    .offset(x = 18.dp, y = 9.5.dp)
                                    .width(130.dp)
                                    .height(101.dp),
                                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                                horizontalAlignment = Alignment.CenterHorizontally


                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.rewardrecieved),
                                    contentDescription = "reward received",
                                    modifier = Modifier
                                        .size(20.dp)
                                )

                                Text(
                                    text = "Free Lunch Received",
                                    modifier = Modifier.padding(top = 6.dp),

                                    // Small Body (Medium)

                                    fontSize = 13.sp,
                                    fontFamily = FontFamily(Font(R.font.robotomedium)),
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFFFFFFFF),
                                    textAlign = TextAlign.Center,
                                    letterSpacing = 0.03.sp,
                                )
                                Text(
                                    text = lunchRecieved,

                                    // H1 (Bold)

                                    fontSize = 28.sp,
                                    fontFamily = FontFamily(Font(R.font.poppinsbold)),
                                    fontWeight = FontWeight(700),
                                    color = Color(0xFFFFFFFF),
                                    textAlign = TextAlign.Center,
                                    letterSpacing = 0.07.sp,
                                )


                            }


                        }


                        Spacer(modifier = Modifier.width(5.dp))

                        Card(
                            elevation = CardDefaults.cardElevation(defaultElevation = 15.dp),
                            modifier = Modifier
                                .weight(1F)
                                .width(165.dp)
                                .height(120.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFF5ECC62)
                            ),
                            shape = RoundedCornerShape(size = (5.dp))


                        ) {
                            Column(
                                modifier = Modifier
                                    .offset(x = 18.dp, y = 9.5.dp)
                                    .width(130.dp)
                                    .height(101.dp),
                                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                                horizontalAlignment = Alignment.CenterHorizontally


                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.givenreward),
                                    contentDescription = "reward received",
                                    modifier = Modifier
                                        .size(20.dp)
                                )

                                Text(
                                    text = "Free Lunch Given",
                                    modifier = Modifier.padding(top = 6.dp),

                                    // Small Body (Medium)

                                    fontSize = 13.sp,
                                    fontFamily = FontFamily(Font(R.font.robotomedium)),
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFFFFFFFF),
                                    textAlign = TextAlign.Center,
                                    letterSpacing = 0.03.sp,
                                )
                                Text(
                                    text = lunchGiven,

                                    // H1 (Bold)

                                    fontSize = 28.sp,
                                    fontFamily = FontFamily(Font(R.font.poppinsbold)),
                                    fontWeight = FontWeight(700),
                                    color = Color(0xFFFFFFFF),
                                    textAlign = TextAlign.Center,
                                    letterSpacing = 0.07.sp,
                                )


                            }

                        }


                    }
                }

            }


        }
    }
}
