package com.essycynthia.calibanfoodmobile.staffNavigation.Screens.withdrawal_screen


import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.essycynthia.calibanfoodmobile.R
import com.essycynthia.calibanfoodmobile.staffNavigation.viewmodel.WithdrawViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WithdrawScreen(modifier: Modifier = Modifier,
                   withdrawViewModel: WithdrawViewModel = WithdrawViewModel()
) {
    var title by remember { mutableStateOf("Withdraw") }
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val categories =
        mutableStateListOf<String>("First bank Nigeria", "Zenith Bank", "UBA", "Opay", "Palmpay")
    var category by remember { mutableStateOf("") }
    val heightTextFields by remember { mutableStateOf(55.dp) }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    var expanded by remember { mutableStateOf(false) }
    var acctNo by remember { mutableStateOf("23456702345678") }
    var acctName by remember { mutableStateOf("Owolabi Gbemisola") }
    var amount by remember { mutableStateOf("5000") }
    var withdrawDialog by remember { mutableStateOf(false) }
    var interactionSource = remember { MutableInteractionSource() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {

// H3 (Semi Bold)
                    Text(
                        text = title,
                        fontFamily = FontFamily(Font(R.font.poppinsemibold)),
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF333333),
                        letterSpacing = 0.02.sp,
                    )
                }, colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFFFAFAFA),
                    titleContentColor = Color(0xFF333333)
                ), scrollBehavior = scrollBehavior
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 60.dp, start = 20.dp, end = 20.dp, bottom = 24.dp)
        ) {
            item {
                Card(
                    modifier = Modifier
                        .width(343.dp)
                        .height(51.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0x1A5ECC62)
                    ),
                    shape = RoundedCornerShape(size = 10.dp)

                ) {

                    Row(
                        modifier = Modifier
                            .offset(x = 15.81599.dp, y = 14.dp)
                            .width(310.59097.dp)
                            .height(20.77857.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(138.dp, Alignment.Start)

                    ) {

                        Text(
                            text = "Available Free Lunch",

                            // Body Text (Regular)

                            fontSize = 14.sp,
                            lineHeight = 20.sp,
                            fontFamily = FontFamily(Font(R.font.robotoregular)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF5ECC62),
                            letterSpacing = 0.07.sp,
                        )



                        Text(
                            text = withdrawViewModel.withdrawState.availableFreeLunch.toString(),
                            Modifier

                                .width(40.dp)
                                .height(20.65871.dp),

                            // H3 (Semi Bold)

                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.poppinsemibold)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFF5ECC62),
                            letterSpacing = 0.02.sp,
                        )


                    }

                }

            }


            item {

                Text(
                    modifier = Modifier.padding(top = 30.dp),
                    text = "Input your bank details below",

                    // Body Text (Medium)

                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.robotomedium)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF333333),
                    letterSpacing = 0.07.sp,
                )

            }


            // acctNo TEXTfIED

            item {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 28.dp)
                ) {


//bank

                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null,
                            onClick = {
                                expanded = false
                            }
                        )


                    ) {
                        // Small Body (Regular)

                        Text(
                            modifier = Modifier.padding(start = 3.dp, bottom = 2.dp),
                            text = "Bank",
                            fontSize = 12.sp,
                            lineHeight = 18.sp,
                            fontFamily = FontFamily(Font(R.font.robotoregular)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF75818F),
                            letterSpacing = 0.03.sp
                        )


                        Row(modifier = Modifier.fillMaxWidth()) {
                            TextField(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(heightTextFields)
                                    .border(
                                        width = 0.5.dp,
                                        color = Color(0xFF75818F),
                                        shape = RoundedCornerShape(10.dp)
                                    )
                                    .onGloballyPositioned { coordinates ->
                                        textFieldSize = coordinates.size.toSize()
                                    },

                                value = category,
                                onValueChange = {
                                    category = it
                                    expanded = true
                                },
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
                                trailingIcon = {
                                    IconButton(onClick = {
                                        expanded = !expanded
                                    }) {
                                        Icon(
                                            imageVector = Icons.Rounded.ArrowDropDown,
                                            contentDescription = "dropdown icon"
                                        )

                                    }
                                }

                            )
                        }



                        AnimatedVisibility(visible = expanded) {
                            Card(


                                modifier = Modifier
                                    .padding(horizontal = 5.dp)
                                    .fillMaxWidth(),
                                //   .width(textFieldSize.width.dp),
                                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.White
                                )

                            ) {
                                LazyColumn(
                                    modifier = Modifier.heightIn(max = 150.dp),
                                ) {
                                    if (category.isNotEmpty()) {
                                        items(
                                            categories.filter {
                                                it.lowercase()
                                                    .contains(category.lowercase()) || it.lowercase()
                                                    .contains("others")
                                            }
                                                .sorted()
                                        ) {
                                            CategoryItems(title = it) { title ->
                                                category = title
                                                expanded = false
                                            }
                                        }
                                    } else {
                                        items(
                                            categories.sorted()
                                        ) {
                                            CategoryItems(title = it) { title ->
                                                category = title
                                                expanded = true

                                            }
                                        }
                                    }
                                }

                            }

                        }
                    }



                    Spacer(modifier = Modifier.height(20.dp))



                    Text(
                        modifier = Modifier.padding(start = 3.dp, bottom = 2.dp),
                        text = "Account Number",
                        fontSize = 12.sp,
                        lineHeight = 18.sp,
                        fontFamily = FontFamily(Font(R.font.robotoregular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF75818F),
                        letterSpacing = 0.03.sp
                    )

                    TextField(
                        value = acctNo,
                        onValueChange = {
                            acctNo = it
                        },
                        modifier = Modifier

                            .height(heightTextFields)
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





                    Spacer(modifier = Modifier.height(20.dp))


                    // acctName TextField


                    Text(
                        modifier = Modifier.padding(start = 3.dp, bottom = 2.dp),
                        text = "Account Name",
                        fontSize = 12.sp,
                        lineHeight = 18.sp,
                        fontFamily = FontFamily(Font(R.font.robotoregular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF75818F),
                        letterSpacing = 0.03.sp
                    )

                    TextField(
                        value = acctName,
                        onValueChange = {
                            acctName = it
                        },
                        modifier = Modifier

                            .height(heightTextFields)
                            .fillMaxWidth()

                            .border(
                                width = 0.5.dp,
                                color = Color(0xFF75818F),
                                shape = RoundedCornerShape(10.dp),

                                ), colors = TextFieldDefaults.textFieldColors(
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            cursorColor = Color.Black,
                            containerColor = Color.Transparent
                        ), textStyle = TextStyle(
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
                        singleLine = true

                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    // amount


                    Text(
                        modifier = Modifier.padding(start = 3.dp, bottom = 2.dp),
                        text = "Amount",
                        fontSize = 12.sp,
                        lineHeight = 18.sp,
                        fontFamily = FontFamily(Font(R.font.robotoregular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF75818F),
                        letterSpacing = 0.03.sp
                    )


                    TextField(


                        value = amount,
                        onValueChange = {
                            amount = it
                        },
                        modifier = Modifier

                            .height(heightTextFields)
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
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Done
                        ),
                        singleLine = true,
                        leadingIcon = {
                            Text(
                                text = "₦",

                                // Body Text (Medium)
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontFamily = FontFamily(Font(R.font.robotomedium)),
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF333333),
                                    letterSpacing = 0.07.sp,
                                )
                            )


                            /* Icon(
                                 painter = painterResource(id = R.drawable.naira),
                                 contentDescription = null,
                                 modifier = Modifier.size(16.dp)
                             )*/
                        }

                    )


                }

            }


////......
            //button
            item {
                Button(
                    onClick = {
                        // showDialog = true
                        withdrawDialog = true


                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp, bottom = 24.dp)
                        .width(343.dp)
                        .height(44.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFFFF9405)),

                    ) {
                    Text(
                        text = "Withdraw",
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

                    WithdrawDialog(
                        openDialog = withdrawDialog,
                        onDismissRequest = { withdrawDialog = false }
                    )
                }


            }
        }
    }
}
// button


@Composable
fun CategoryItems(
    title: String,
    onSelect: (String) -> Unit
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            onSelect(title)
        }
        .padding(10.dp)
    ) {
        Text(
            text = title,
            fontSize = 16.sp, fontFamily = FontFamily(Font(R.font.robotomedium))
        )
    }

}
