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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.essycynthia.calibanfoodmobile.R
import com.essycynthia.calibanfoodmobile.dummyData.colleague
import com.essycynthia.calibanfoodmobile.ui.theme.CalibanFoodMobileTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SendLunchRewardScreen(){
    Column {
        TopAppBar(
            title = { Text(text = "Send Lunch Reward") },
            modifier = Modifier.background(Color.White),
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(painter = painterResource(id = R.drawable.back_icon), contentDescription = null)
                }
            },
            actions = {
                Button(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9405))
                ) {
                    Text(text = "Send")
                }
            }
        )
        SendLunchReward()
    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SendLunchReward(){
    var text by rememberSaveable{ mutableStateOf("") }
    var complimentText by rememberSaveable{ mutableStateOf("") }
    Surface(modifier= Modifier
        .fillMaxSize()
        .padding(15.dp)) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
        ) {
            Spacer(modifier = Modifier.size(30.dp))
            Text(text = stringResource(R.string.recipient), modifier = Modifier.padding(bottom = 10.dp))
            OutlinedTextField(
                value = text,
                onValueChange = {text = it},
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = { Icon(Icons.Default.Search, contentDescription = null)},
                shape = RoundedCornerShape(10.dp)
            )
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
                value = complimentText,
                onValueChange = {complimentText = it},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CalibanFoodMobileTheme {
        SendLunchRewardScreen()
    }
}