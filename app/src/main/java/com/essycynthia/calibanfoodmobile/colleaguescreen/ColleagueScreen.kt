package com.essycynthia.calibanfoodmobile.colleaguescreen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.essycynthia.calibanfoodmobile.R




@Composable
fun StaffProfileScreen(navController: NavHostController){
    StaffProfileDetails(
        staffProfile = StaffProfile(
            imageId = R.drawable.people,
            //profile_img
            name = "Fiyinfoluwa Isreal",
            userName = "@fiyin",
            jobRole = "Product Designer",
            department = "Member of HNG Team",
            location = "Lagos, Nigeria",
            freeLunchGiven = 10 ,
            freeLunchReceived = 5,


        ),
        navController = navController
    )
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StaffProfileDetails(
    staffProfile: StaffProfile,
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var title by remember { mutableStateOf("Profile") }
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        topBar = {
            TopAppBar(title = {


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
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFFFAFAFA),
                    titleContentColor = Color(0xFF333333)
                ),navigationIcon = {
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
            modifier
                //check
                .padding(top = 60.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
                //.padding(16.dp)
                .fillMaxSize(),

            ){
            item {

                Column(

                    verticalArrangement = Arrangement.spacedBy(8.dp),

                    ) {
                    Image(
                        painter = painterResource(id = staffProfile.imageId), modifier = Modifier
                            .clip(ShapeDefaults.Small)
                            .size(width = 343.dp, height = 270.dp)
                            .fillMaxWidth(),
                        contentDescription = "Profile Picture"
                    )

                    Text(
                        text = staffProfile.name,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )

                    Text(
                        text = staffProfile.userName,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onBackground
                    )

                    Row {
                        Icon(
                            painterResource(id = R.drawable.role),
                            contentDescription = "Place Icon",
                            modifier = modifier.size(14.dp)
                        )

                        Spacer(modifier = modifier.padding(start = 8.dp))

                        Text(
                            text = staffProfile.jobRole,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }

                    Row {
                        Icon(
                            //check
                            painterResource(id = R.drawable.membership),
                            contentDescription = "Place Icon",
                            modifier = modifier.size(14.dp)
                        )

                        Spacer(modifier = modifier.padding(start = 8.dp))

                        Text(
                            text = staffProfile.department,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }

                    Row {
                        Icon(
                            painterResource(id = R.drawable.location),
                            contentDescription = "Place Icon",
                            modifier = modifier.size(14.dp)
                        )

                        Spacer(modifier = modifier.padding(start = 8.dp))

                        Text(
                            text = staffProfile.location,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }


                    Button(
                        onClick = {navController.navigate("send_lunch")}, modifier = Modifier
                            .padding(top = 20.dp)
                            .fillMaxWidth()
                            .width(343.dp)
                            .height(44.dp),
                        enabled = true,
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFFFF9405)),

                        ) {
                        Text(
                            text = "Send Free Lunch",
                            // Body Text (Medium)
                            style = MaterialTheme.typography.bodyMedium,
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.robotomedium)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFFFFFFFF),
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.07.sp,

                            )


                    }


                    Text(
                        text = "Overview",
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = modifier.padding( top = 20.dp,)
                    )

                    Row(modifier = Modifier.padding(top= 18.dp)) {
                        Surface(
                            color = Color(0xFF3F61DB),
                            modifier = modifier

                                .clip(shape = ShapeDefaults.Small)
                                .size(width = 165.dp, height = 120.dp)
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Spacer(modifier = modifier.padding(top = 8.dp))

                                Image(
                                    painter = painterResource(id = R.drawable.rewardrecieved),
                                    contentDescription = "reward received",
                                    modifier = Modifier
                                        .size(20.dp)
                                )

                                /* Icon(
                                     painterResource(id = R.drawable.rewardrecieved),
                                     contentDescription = "Ribbon Icon",

                                 )*/

                                Spacer(modifier = modifier.padding(top = 8.dp))

                                Text(
                                    text = "Free Lunch Received",
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyMedium
                                )

                                Spacer(modifier = modifier.padding(top = 8.dp))

                                Text(
                                    text = "${staffProfile.freeLunchReceived}",
                                    color = Color.White,
                                    style = MaterialTheme.typography.headlineLarge,
                                    modifier = modifier.padding(bottom = 8.dp)
                                )
                            }
                        }

                        Spacer(modifier = modifier.padding(8.dp))

                        Surface(
                            //check
                            color = Color(0xFF5ECC62),
                            modifier = modifier
                                .clip(shape = ShapeDefaults.Small)
                                .size(width = 165.dp, height = 120.dp)
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Spacer(modifier = modifier.padding(top = 8.dp))

                                Image(
                                    painter = painterResource(id = R.drawable.givenreward),
                                    contentDescription = "reward received",
                                    modifier = Modifier
                                        .size(20.dp)
                                )

                                /*   Icon(
                                       painterResource(id = R.drawable.givenreward),
                                       contentDescription = "Ribbon Icon"
                                   )*/

                                Spacer(modifier = modifier.padding(top = 8.dp))

                                Text(
                                    text = "Free Lunch Given",
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyMedium
                                )

                                Spacer(modifier = modifier.padding(top = 8.dp))

                                Text(
                                    text = "${staffProfile.freeLunchGiven}",
                                    color = Color.White,
                                    style = MaterialTheme.typography.headlineLarge
                                )
                            }


                        }






                    }


                }








            }

        }



    }


}

//@Preview
//@Composable
//fun StaffProfilePreview() {
//    StaffProfile()
//}

