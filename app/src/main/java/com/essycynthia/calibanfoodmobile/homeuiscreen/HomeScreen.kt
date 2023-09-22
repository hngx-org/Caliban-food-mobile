package com.essycynthia.calibanfoodmobile.homeuiscreen


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import com.essycynthia.calibanfoodmobile.R



@Composable
fun HomeScreen() {
    Home()


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    modifier: Modifier = Modifier
) {
    var username by remember { mutableStateOf("Gbemiglad") }

    Scaffold(
        topBar = {
            HomeTopAppBar(username = username, onUsernameChanged = {
                username = it
            })
        },
        bottomBar = {
            HomeButtomAppBar()
        }
    ) { innerPadding ->
        Column(
            modifier = modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            FreeLunchDashBoard(
                freeLunchAmount = 27
            )
            SendLunchReward()
//            RewardHistoryList(
//                rewardHistories = RewardHistory(
//                    userImageId = R.drawable.img2,
//                    user = "UduakE",
//                    lunchReward = 3,
//                    time = 3
//
//                ),
//                RewardHistory(
//                    userImageId = R.drawable.img2,
//                    user = "Fisayo",
//                    lunchReward = 2,
//                    time = 3
//
//                )
//
//            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopAppBar(
    username: String, onUsernameChanged: (String) -> Unit, modifier: Modifier = Modifier
) {
    TopAppBar(title = {
        Row {

            BasicTextField(
                value = "Welcome, $username \uD83D\uDC4B",
                onValueChange = { onUsernameChanged(it) },
                singleLine = true,
                textStyle = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 14.sp, lineHeight = 16.41.sp, letterSpacing = 0.5.sp
                )
            )

        }
    }, modifier = modifier.fillMaxWidth(), actions = {

        IconButton(enabled = true, modifier = modifier, onClick = {}) {
            Icon(
                painterResource(id = R.drawable.search),
                contentDescription = "Search",
                modifier = modifier.size(24.dp)
            )
        }
    })
}

@Composable
fun HomeButtomAppBar(modifier: Modifier = Modifier) {
    BottomAppBar(
        containerColor = Color.White,
        // contentColor = MaterialTheme.colorScheme.primary,
        content = {
            //check
            Row(horizontalArrangement = Arrangement.spacedBy(50.dp, Alignment.Start),
            ) {
                Column {
                    IconButton(enabled = true, modifier = modifier, onClick = {}) {
                        Icon(
                            painterResource(id = R.drawable.home),
                            contentDescription = "Home",
                            modifier = modifier
                                .size(24.dp),
                            tint = Color(0xFFFF9405)

                        )
                    }
                    //    Text(text = "Home")
                    Text(
                        text = "Home",
                        modifier = modifier.padding(start = 5.dp),

                        // Button
                        style = TextStyle(
                            fontSize = 12.sp,
                            //   fontFamily = FontFamily(Font(R.font.roboto)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFFFF9405),
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.15.sp,
                        )
                    )
                }

                Column {
                    IconButton(enabled = true, modifier = modifier, onClick = {}) {
                        Icon(
                            painterResource(id = R.drawable.reward),
                            contentDescription = "Home",
                            modifier = modifier.size(24.dp)
                        )
                    }
                    // Text(text = "Reward")
                    Text(
                        text = "Reward",

                        // Button
                        style = TextStyle(
                            fontSize = 12.sp,
                            //  fontFamily = FontFamily(Font(R.font.roboto)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF75818F),
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.15.sp,
                        )
                    )
                }

                Column {
                    IconButton(enabled = true, modifier = modifier, onClick = {}) {
                        Icon(
                            painterResource(id = R.drawable.redeem),
                            contentDescription = "Home",
                            modifier = modifier.size(24.dp)
                        )
                    }
                    // Text(text = "Withdraw")
                    Text(
                        text = "Withdraw",

                        // Button
                        style = TextStyle(
                            fontSize = 12.sp,
                            //  fontFamily = FontFamily(Font(R.font.roboto)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF75818F),
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.15.sp,
                        )
                    )
                }

                Column {
                    IconButton(enabled = true, modifier = modifier, onClick = {}) {
                        Icon(
                            painterResource(id = R.drawable.settings),
                            contentDescription = "Home",
                            modifier = modifier.size(24.dp)
                        )
                    }
                    // Text(text = "Profile")
                    Text(
                        text = "Profile",

                        // Button
                        style = TextStyle(
                            fontSize = 12.sp,
                            //  fontFamily = FontFamily(Font(R.font.roboto)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF75818F),
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.15.sp,
                        )
                    )
                }

            }
        }
    )
}

@Composable
fun FreeLunchDashBoard(
    freeLunchAmount: Int,
    modifier: Modifier = Modifier
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
                horizontalArrangement = Arrangement.spacedBy(150.dp)
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

            Text(
                text = "$freeLunchAmount",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Center
            )


            Button(
                onClick = { /*TODO*/ },
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
            .fillMaxWidth()
            .height(160.dp)
            .padding(start = 16.dp, end = 16.dp, top = 20.dp)
    ) {
        Row (

            horizontalArrangement = Arrangement.spacedBy(38.dp)


        ){
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
                painter = painterResource(id = R.drawable.couple),
                contentDescription = "An Interracial couple",
                alignment = Alignment.CenterEnd
            )
        }


    }
}

@Composable
fun RewardHistoryList(
    rewardHistories: List<RewardHistory>,
    modifier: Modifier = Modifier
) {
    Row {
        Text(text = "Reward History")
        Text(text = "See All")
    }

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
    ) {
        /*items(
            rewardHistories
        ) { rewardHistory ->
           RewardHistoryElement(
                rewardHistory = rewardHistories, modifier = Modifier.fillMaxSize()
            )
         }*/
    }

}

@Composable
fun RewardHistoryElement(
    rewardHistory: RewardHistory
) {
    Column {
        Row {
            Image(
                painter = painterResource(id = rewardHistory.userImageId),
                contentDescription = "Image"
            )
            Text(text = "${rewardHistory.user} sent you a free lunch")
            Text(text = "${rewardHistory.lunchReward}")
            Image(
                painter = painterResource(id = R.drawable.food),
                contentDescription = "Pot of Food"
            )
        }
        Text(text = "${rewardHistory.time}")
    }


}

//@Composable
//@Preview
//fun HomeScreenPreview() {
//    Home()
//
//}
