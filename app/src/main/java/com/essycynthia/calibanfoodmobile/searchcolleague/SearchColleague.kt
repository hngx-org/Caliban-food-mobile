package com.essycynthia.calibanfoodmobile.searchcolleague


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement



import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
//import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.SemanticsProperties.ImeAction
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.essycynthia.calibanfoodmobile.R


@Composable
fun LunchRecognitionsScreen() {
    SearchStaff()
    SearchList()
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun SearchStaff(modifier: Modifier = Modifier) {
    var search by rememberSaveable { mutableStateOf("") }
  val keyboardController = LocalSoftwareKeyboardController.current
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(title = {
                TextField(value = search, onValueChange = {
                    search = it
                }, modifier = Modifier
                    .height(90.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFE6E9F0),
                        shape = RoundedCornerShape(15.dp)
                    ),

                    placeholder = { Text("Search colleague") },
                    enabled = true,
                    singleLine = true,
                    trailingIcon = {
                        IconButton(onClick = {  }) {
                            Icon(imageVector = Icons.Default.Search, contentDescription = "search")

                        }

                    },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    ),
                    keyboardOptions = KeyboardOptions(
                        imeAction = androidx.compose.ui.text.input.ImeAction.Search
                    ),


                    )


            },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(id = R.drawable.leftarrowiconframe),
                            contentDescription = "arrow",
                            Modifier
                                .size(40.dp)
                        )

                    }




                }



                )
        }

    ){

    }

}



@Composable
fun SearchList(modifier: Modifier = Modifier) {
    var scrollState = rememberScrollState()

    Card(

        modifier = modifier
            .verticalScroll(scrollState)

            .fillMaxHeight()

            .padding(start = 25.dp, top = 120.dp, end = 25.dp)
            .width(315.dp),


        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(size = (15.dp)),



        ) {

        Row(
            modifier.padding(top = 18.dp, start = 15.dp),

            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.avatar),
                //user_img),
                contentDescription = "User Image"
            )
            Text(
                text = "UduakE @uduakE",
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                    fontFamily = FontFamily(Font(R.font.robotomedium)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF333333),
                    letterSpacing = 0.03.sp,
                )
            )


        }
    }

}

//@Preview
//@Composable
//fun LunchRecognitionsPreview() {
//    SearchStaff()
//   // SearchList()
//}
