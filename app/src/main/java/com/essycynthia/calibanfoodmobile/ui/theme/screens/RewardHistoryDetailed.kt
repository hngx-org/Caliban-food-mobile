package com.essycynthia.calibanfoodmobile.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.essycynthia.calibanfoodmobile.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RewardHistoryDetailedScreen(){
    Column (){
        TopAppBar(
            title = {Text(text = "Reward")},
            modifier = Modifier.background(Color.White),
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painter = painterResource(id = R.drawable.back_icon), contentDescription = null)
                }
            }
        )
        RewardHistoryDetailed()
    }
}
@Composable
fun RewardHistoryDetailed(){
    Surface(color = Color(0xFFFAFAFA), modifier = Modifier.fillMaxSize()) {
        Column(
        ) {
            Surface(
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 15.dp, start = 17.dp, end = 17.dp)
                    .fillMaxWidth()
                    .height(151.4277.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.one_meal_img),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                )
            }

            Surface(modifier = Modifier.padding(15.dp)) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier.padding(10.dp)
                ) {
                    Image(painter = painterResource(id = R.drawable.wink_avatar ) , contentDescription = null, modifier = Modifier.size(30.dp))
                    Column(
                        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically)
                    ) {
                        Text(
                            text = stringResource(R.string.fiyinfoluwa),
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight(500),
                                color = Color(0xFF333333),
                                letterSpacing = 0.07.sp,
                            )
                        )

                        Text(
                            text = stringResource(R.string.appreciation_message),
                            style = TextStyle(
                                fontSize = 12.sp,
                                lineHeight = 18.sp,
                                fontFamily = FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF333333),
                                letterSpacing = 0.03.sp,
                            ),
                            modifier = Modifier.height(54.dp)
                        )
                        Text(
                            text = "2 mins",
                            modifier = Modifier.align(Alignment.End),
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
    }
}

