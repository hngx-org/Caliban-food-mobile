package com.essycynthia.calibanfoodmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.essycynthia.calibanfoodmobile.ui.theme.CalibanFoodMobileTheme
import com.essycynthia.calibanfoodmobile.ui.theme.LoginScreen
import com.essycynthia.calibanfoodmobile.ui.theme.Neutral1
import com.essycynthia.calibanfoodmobile.ui.theme.Neutral2
import com.essycynthia.calibanfoodmobile.ui.theme.Primary
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalibanFoodMobileTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  /*  val login = LoginScreen()
                    login.Login()*/
                    register()

                }
            }
        }
    }
}

@Composable
fun register(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .padding(20.dp)
        .padding(top = 50.dp)) {
        Text(
            text = "Create Accont",
            style = CalibanFoodMobileTheme.typography.h1Bold,
            color = Neutral2,
            fontSize = 28.sp
        )
        Text(
            text = "Sign up with your company email address",
            style = CalibanFoodMobileTheme.typography.bodyRegular,
            color = Neutral2,
            fontSize = 14.sp,
            modifier = modifier.padding(top = 8.dp)
        )

    }
}

/*
    fun FreeLunchSection(
        modifier: Modifier = Modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(all = 16.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(Primary)
        ) {
            Row(
                modifier = Modifier
                    .padding(
                        top = 14.dp,
                        start = 16.dp,
                        end = 16.dp,
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Free Lunch",
                    style = HngTheme.typography.h3Bold,
                    color = Neutral1,
                )
                Spacer(modifier = Modifier.weight(1.0f))
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(Color.Cyan)
                )
            }

            Text(
                text = "27",
                style = HngTheme.typography.h1Bold,
                color = Neutral1,
                modifier = Modifier.padding(top = 10.dp)
            )

            OutlinedButton(
                onClick = { */
/*TODO*//*
 },
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(
                    width = 1.dp,
                    color = Neutral1,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 20.dp,
                        end = 20.dp,
                        top = 20.dp,
                        bottom = 14.dp,
                    )
            ) {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "Search",
                    tint = Neutral1
                )
                Text(text = "Login with Google", color = Neutral1, style = HngTheme.typography.button)
            }

            Button(
                onClick = { */
/*TODO*//*
 },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Neutral1
                ),
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 20.dp,
                        end = 20.dp,
                        top = 20.dp,
                        bottom = 14.dp,
                    )
            ) {
                Text(text = "Withdraw Lunch", color = Primary, style = HngTheme.typography.button)
            }
        }
    }

*/





@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Greeting(){
    CalibanFoodMobileTheme {
    }
}

