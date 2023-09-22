package com.essycynthia.calibanfoodmobile.ui.withdrawal_screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.essycynthia.calibanfoodmobile.R



@Composable
fun WithdrawDialog(
    openDialog: Boolean,
    onDismissRequest: () -> Unit
) {
    if (openDialog) {
        Dialog(
            onDismissRequest = { onDismissRequest() },
            properties = DialogProperties(
                dismissOnClickOutside = false,
                dismissOnBackPress = false
            )
        ) {
            Column(
                modifier = Modifier
                    .height(300.dp)
                    .width(300.dp)
                    .background(
                        MaterialTheme.colorScheme.background,
                        shape = RoundedCornerShape(size = 20.dp)
                    ),
                verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top)
            ) {


                Image(
                    painter = painterResource(id = R.drawable.congrats),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .width(100.dp)
                        .height(100.dp)


                )


                Text(
                    // H3 (Semi Bold)
                    text = "Successful",
                    modifier = Modifier
                        .width(88.dp)
                        .height(24.dp)
                        .align(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppinsemibold)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF5ECC62),
                    letterSpacing = 0.02.sp,
                    textAlign = TextAlign.Center
                )

                // Small Body (Medium)
                Text(
                    text = "Reward has been withdrawn successfully 😊",
                    modifier = Modifier
                        .width(173.dp)
                        .height(50.dp)
                        .align(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 13.sp,
                    fontFamily = FontFamily(Font(R.font.robotomedium)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF333333),
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.03.sp,
                )


                Button(
                    onClick = {
                        // Handle button click action
                        onDismissRequest()
                    },
                    modifier = Modifier

                        .width(133.dp)
                        .height(33.dp)
                        .align(Alignment.CenterHorizontally),
                    colors = ButtonDefaults.buttonColors(Color(0xFF5ECC62)),
                    shape = RoundedCornerShape(10.dp)
                ) {

                    // Small Body (Medium)
                    Text(
                        text = "Go Back",
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.robotomedium)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                        letterSpacing = 0.03.sp,
                    )
                }
            }
        }
    }
}
