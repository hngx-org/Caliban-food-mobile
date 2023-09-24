package com.essycynthia.calibanfoodmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier



import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import com.essycynthia.calibanfoodmobile.dummyData.RewardHistory
import com.essycynthia.calibanfoodmobile.organizationfreelunch.CardData
import com.essycynthia.calibanfoodmobile.searchcolleague.LunchRecognitionsScreen
import com.essycynthia.calibanfoodmobile.ui.BottomScreens



import com.essycynthia.calibanfoodmobile.ui.theme.CalibanFoodMobileTheme
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
                    LunchRecognitionsScreen()
                 //   Greeting()
                  //ProfilePage()
               //   OrganizationFreeLunchReward(cards = sampleCardData() )
                   // WithdrawPage()
                    //InviteUserOrg()
                 //StaffProfileScreen()
                }
            }
        }
    }
}
@Composable
fun Greeting(){
    Text(text = "Yay it's working!")
}


private fun sampleCardData(): List<CardData> {
    return listOf(
        CardData(R.drawable.orgbuyer, "UduakE", 100, 3),
        // Add more CardData objects as needed
    )
}
