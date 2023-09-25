package com.essycynthia.calibanfoodmobile.inviteuser


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.essycynthia.calibanfoodmobile.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InviteUserOrg(
    inviteUserViewModel: InviteUserViewModel = hiltViewModel()
) {

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    var inviteDialog by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Invite Users",

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
                ), navigationIcon = {
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
                Text(
                    text = "Recipient",
                    modifier = Modifier
                        .width(208.dp)
                        .height(17.56177.dp)
                        .padding(bottom = 4.dp),


                    // modifier = Modifier.padding(top)

                    // Small Body (Regular)
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 18.sp,
                        fontFamily = FontFamily(Font(R.font.robotoregular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF75818F),
                        letterSpacing = 0.03.sp,
                    )
                )


                /*item {


                    */



                TextField(
                    value = inviteUserViewModel.recipient,
                    onValueChange = {
                        inviteUserViewModel.recipient = it
                    },
                    modifier = Modifier

                        .height(55.dp)
                        .fillMaxWidth()

                        .border(
                            width = 0.5.dp,
                            color = Color(0xFF75818F),
                            shape = RoundedCornerShape(10.dp),
                        ),
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = Color.Black,
                        containerColor = Color.Transparent
                    ),
                    textStyle = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.robotomedium)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF333333),
                        letterSpacing = 0.07.sp
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    singleLine = true,


                    )


                Text(
                    text = "Invite multiple users by using a comma to seperate emails.",

                    modifier = Modifier
                        .width(343.dp)
                        .height(18.dp)
                        .padding(top = 4.dp),
                    // Small Body (Regular)
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 18.sp,
                        fontFamily = FontFamily(Font(R.font.robotoregular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF75818F),
                        letterSpacing = 0.03.sp,
                    )
                )




                Text(
                    text = "Include Message",
                    modifier = Modifier
                        .width(208.dp)
                        // .height(17.56177.dp)

                        .padding(top = 45.dp, bottom = 4.dp),

                    // Small Body (Regular)
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 18.sp,
                        fontFamily = FontFamily(Font(R.font.robotoregular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF75818F),
                        letterSpacing = 0.03.sp,
                    )
                )




                TextField(
                    value = inviteUserViewModel.message,
                    onValueChange = {
                        inviteUserViewModel.message = it
                    },
                    modifier = Modifier

                        .height(95.dp)
                        .fillMaxWidth()

                        .border(
                            width = 0.5.dp,
                            color = Color(0xFF75818F),
                            shape = RoundedCornerShape(10.dp),
                        ),
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = Color.Black,
                        containerColor = Color.Transparent
                    ),
                    textStyle = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.robotomedium)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF333333),
                        letterSpacing = 0.07.sp
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    // singleLine = true,
                    //maxLines = 5


                )


            }


            //button
            item {
                Button(
                    onClick = {
                        // showDialog = true
                        inviteDialog = true
                        inviteUserViewModel.createOrganisationInvite(inviteUserViewModel.recipient)

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 200.dp, bottom = 24.dp)
                        .width(343.dp)
                        .height(44.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFFFF9405)),

                    ) {
                    Text(
                        text = "Send Invitation",
                        // Body Text (Medium)
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.robotomedium)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFFFFFFFF),
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.07.sp,
                        )
                    )

                    InviteAlertDialog(
                        openDialog = inviteDialog,
                        onDismissRequest = { inviteDialog = false }
                    )
                }


            }


        }

    }
}

