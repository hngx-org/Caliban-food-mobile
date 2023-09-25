package com.essycynthia.calibanfoodmobile.searchcolleague


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.essycynthia.calibanfoodmobile.R

/*
get colleague list

private  fun getColleagueList(): List<ColleagueList>{
    return  listOf(
        ColleagueList(R.drawable.uduake,"Uduake","@Uduake"),
        ColleagueList(R.drawable.fylin,"fyinoluwa","@fyin"),
        ColleagueList(R.drawable.uduake,"Uduake","@Uduake"),
        ColleagueList(R.drawable.uduake,"Uduake","@Uduake"),
        ColleagueList(R.drawable.uduake,"Uduake","@Uduake"),
        ColleagueList(R.drawable.uduake,"Uduake","@Uduake"),
        ColleagueList(R.drawable.uduake,"Uduake","@Uduake"),
    )
}*/



@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SearchingColleague(colleague: List<ColleagueList>) {
    var search by remember { mutableStateOf("") }
    Scaffold{
        // content

        LazyColumn(
            modifier = Modifier
                .padding(
                    top = 100.dp,
                    start = 20.dp,
                    end = 20.dp,
                    bottom = 24.dp
                )
                .fillMaxSize()


        ) {
            item {

                TextField(
                    value = search,
                    onValueChange = {
                        search = it
                    },
                    modifier = Modifier
                        .border(
                            width = 1.dp, color = Color(0xFFE6E9F0),
                            shape = RoundedCornerShape(15.dp)
                        )

                        .width(317.dp)
                        .height(47.dp)
                        .fillMaxWidth(),


                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent

                    ),
                    placeholder = {
                        Text(
                            text = "Search colleague",

                            // Small Body (Regular)
                            style = TextStyle(
                                fontSize = 12.sp,
                                lineHeight = 18.sp,
                                fontFamily = FontFamily(Font(R.font.robotoregular)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF75818F),
                                textAlign = TextAlign.Center,
                                letterSpacing = 0.03.sp,
                            )
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Search
                    ),
                    trailingIcon = {
                        IconButton(onClick = { }) {
                            Icon(imageVector = Icons.Default.Search, contentDescription = "search")

                        }
                    }

                )
            }

            items(colleague) { colleagueData ->
                Column(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.Top),
                    horizontalAlignment = Alignment.Start
                ) {

                    Surface(
                        onClick = { /*Navigate to reward screen */ },
                        color = Color.White,
                        modifier = Modifier
                            //.padding(bottom = 20.dp)
                            .width(317.dp)

                            .height(39.dp),
                        //  .padding(horizontal = 16.dp),
                        shape = RoundedCornerShape(5.dp)
                    ) {

                        Column(
                            //   modifier = Modifier.padding(horizontal = 15.dp,)
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Image(
                                    painter = painterResource(colleagueData.img),
                                    contentDescription = null,
                                    contentScale = ContentScale.FillBounds,
                                    modifier = Modifier
                                        .size(30.dp)
                                        .clip(CircleShape)
                                )
                                Spacer(modifier = Modifier.size(10.dp))
                                Text(
                                    text = "${colleagueData.name}",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        lineHeight = 18.sp,
                                        fontFamily = FontFamily(Font(R.font.robotoregular)),
                                        fontWeight = FontWeight(500),
                                        color = Color(0xFF333333),
                                        letterSpacing = 0.03.sp,
                                    )
                                )

                                Text(
                                    text = "${colleagueData.userName}",
                                    style = TextStyle(

                                        fontSize = 12.sp,
                                        lineHeight = 18.sp,
                                        fontFamily = FontFamily(Font(R.font.robotoregular)),
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black,
                                        letterSpacing = 0.03.sp,
                                    ),
                                    modifier = Modifier.weight(1f)
                                )


                            }
                        }


                    }

                }
            }
        }
    }
}