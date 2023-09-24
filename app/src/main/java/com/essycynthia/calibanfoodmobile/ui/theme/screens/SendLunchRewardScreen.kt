package com.essycynthia.calibanfoodmobile.ui.theme.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.essycynthia.calibanfoodmobile.R
import com.essycynthia.calibanfoodmobile.data.remote.dto.UserResponseDto
import com.essycynthia.calibanfoodmobile.dummyData.colleague
import com.essycynthia.calibanfoodmobile.ui.theme.CalibanFoodMobileTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SendLunchRewardScreen(
    sendLunchRewardViewModel: SendLunchRewardViewModel = hiltViewModel()
){
    Column {
        var openDialog by remember { mutableStateOf(false) }
        TopAppBar(
            title = { Text(text = "Send Lunch Reward") },
            modifier = Modifier.background(Color.White),
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(painter = painterResource(id = R.drawable.back_icon), contentDescription = null)
                }
            },
            actions = {
                Button(
                    onClick = {
                        sendLunchRewardViewModel.resetState()
                        openDialog = true
                              },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9405)),
                    enabled = sendLunchRewardViewModel.getEnabledValue()
                ) {
                    Text(text = "Send")
                }
            }
        )
        SendLunchReward(sendLunchRewardViewModel)

        if (openDialog){
            AlertDialog(
                onDismissRequest = {openDialog = false},
                confirmButton = {
                    Button(onClick = { openDialog = false }, colors = ButtonDefaults.buttonColors(containerColor = Color.Green)) {
                        Text(text = "View Reward")
                    }
                },
                title = {
                    Text(text = "Free Lunch Sent", color = Color.Green)
                },
                text = {
                    Text(text = "You just made your colleague's day. Keep it up!")
                }
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SendLunchReward(
    sendLunchRewardViewModel: SendLunchRewardViewModel
){

    Surface(modifier= Modifier
        .fillMaxSize()
        .padding(15.dp)) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
        ) {
            Spacer(modifier = Modifier.size(30.dp))
            Text(text = stringResource(R.string.recipient), modifier = Modifier.padding(bottom = 10.dp))
            Surface(){
                Column(){
                    OutlinedTextField(
                        value = sendLunchRewardViewModel.recipientText,
                        onValueChange = {sendLunchRewardViewModel.recipientText = it},
                        modifier = Modifier.fillMaxWidth(),
                        trailingIcon = { Icon(Icons.Default.Search, contentDescription = null)},
                        shape = RoundedCornerShape(10.dp)
                    )
                    if (sendLunchRewardViewModel.recipientText.isNotBlank()){
                        sendLunchRewardViewModel.usersSearchList.forEach {
                            UserRow(it)
                        }
                    }

                }
            }
            Spacer(modifier = Modifier.size(30.dp))
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                Image(painter = painterResource(id = R.drawable.one_meal_img), contentDescription = null, contentScale = ContentScale.FillBounds ,modifier = Modifier
                    .width(173.dp)
                    .height(71.dp)
                    .clickable { }
                )
                Spacer(modifier = Modifier.size(15.dp))
                Image(painter = painterResource(id = R.drawable.two_meal_img) , contentDescription = null, contentScale = ContentScale.FillBounds ,modifier = Modifier
                    .width(173.dp)
                    .height(71.dp)
                    .clickable { }
                )
            }
            Spacer(modifier = Modifier.size(20.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(15.dp, Alignment.CenterHorizontally), modifier = Modifier.fillMaxWidth()
            ) {
                Image(painter = painterResource(id = R.drawable.three_meal_img) , contentDescription = null, contentScale = ContentScale.FillBounds ,modifier = Modifier
                    .width(173.dp)
                    .height(71.dp)
                    .clickable { }
                )
                Image(painter = painterResource(id = R.drawable.four_meal_img) , contentDescription = null, contentScale = ContentScale.FillBounds ,modifier = Modifier
                    .width(173.dp)
                    .height(71.dp)
                    .clickable {}
                )
            }
            Spacer(modifier = Modifier.size(30.dp))
            Text(text = stringResource(R.string.compliment), modifier = Modifier.padding(bottom = 10.dp))
            OutlinedTextField(
                value = sendLunchRewardViewModel.complimentText,
                onValueChange = {sendLunchRewardViewModel.complimentText = it},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            )
        }
    }
}

@Composable
fun UserRow(
    userResponseDto: UserResponseDto
) {
    Surface (
        modifier = Modifier.clickable { /* Send User Response*/ }
    ){
        Row (
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ){
            Image(painter = painterResource(id = R.drawable.female_avatar), contentDescription = null, contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                text = userResponseDto.name,
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                    fontFamily = FontFamily(Font(R.font.roboto)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF333333),
                    letterSpacing = 0.03.sp
                )
            )
        }
    }

}