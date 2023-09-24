package com.essycynthia.calibanfoodmobile.staffNavigation.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import com.essycynthia.calibanfoodmobile.Greeting
import com.essycynthia.calibanfoodmobile.R
import com.essycynthia.calibanfoodmobile.dummyData.ColleagueData
import com.essycynthia.calibanfoodmobile.dummyData.RewardHistory
import com.essycynthia.calibanfoodmobile.dummyData.colleaguesList

 @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun RewardsScreen() {
        Column {
            TopAppBar(
                title = { Text(text = "Rewards History") },
                modifier = Modifier.background(Color.White),
            )

            ReceivedRewardHistory(rewardHistories = colleaguesList)
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ReceivedRewardHistory(
        rewardHistories: List<RewardHistory>
    ) {
        Surface(
            color = Color(0xFFFAFAFA)
        ) {
            Column() {
                NavigationButtons()
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically)
                ) {
                    rewardHistories.forEach {
                        item {
                            ReceivedUserDay(it.day)
                        }
                        items(it.colleagueDataList) { colleagueData ->
                            ReceivedUserRow(colleagueData)
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun ReceivedUserDay(day: String) {
        Text(
            text = day,
            style = TextStyle(
                fontSize = 13.sp,
                fontFamily = FontFamily(Font(R.font.roboto)),
                fontWeight = FontWeight(500),
                color = Color(0xFF333333),
                letterSpacing = 0.03.sp,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//Composable for a specific row element
fun ReceivedUserRow(colleagueData: ColleagueData){
    Surface(
        onClick = { /*Navigate to reward screen */ },
        color = Color.White,
        modifier = Modifier.padding(horizontal = 16.dp),
        shape = RoundedCornerShape(5.dp)
    ) {
        
        Column(modifier = Modifier.padding(horizontal = 15.dp, vertical = 11.dp)) {
            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ){
                Image(painter = painterResource(id = R.drawable.female_avatar), contentDescription = null, contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.size(10.dp))
                Text(
                    text = "${colleagueData.name} ",
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 18.sp,
                        fontFamily = FontFamily(Font(R.font.roboto)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF333333),
                        letterSpacing = 0.03.sp,
                    ),
                    modifier = Modifier.weight(1f))

                Text(
                    text = colleagueData.numberOfMeals.toString(),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFFFF9405),
                        letterSpacing = 0.02.sp,
                    )
                )

                Image(
                    painter = painterResource(id = R.drawable.pot_of_food), contentDescription = null,contentScale = ContentScale.FillBounds,
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
//contains function used in implementing color change for received and given buttons
@Composable
fun NavigationButtons(){
    Row (
        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start)
    ){
        var selected by remember{ mutableStateOf(true) }
        val colorReceived = if(selected) Color(0xFFFF9405) else Color.White
        val colorSent = if(!selected) Color(0xFFFF9405) else Color.White
        Spacer(modifier = Modifier.size(6.dp))
        Button(onClick = { selected = true}, colors = ButtonDefaults.buttonColors(containerColor = colorReceived), shape = RoundedCornerShape(30.dp)) {
            Text(text = "Received")
        }
        Button(onClick = { selected = false }, colors = ButtonDefaults.buttonColors(containerColor = colorSent), shape = RoundedCornerShape(30.dp)) {
            Text(text = "Given")
        }
    }
}