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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.essycynthia.calibanfoodmobile.inviteuser.InviteUserOrg
import com.essycynthia.calibanfoodmobile.organizationfreelunch.CardData
import com.essycynthia.calibanfoodmobile.organizationfreelunch.OrganizationFreeLunchReward
import com.essycynthia.calibanfoodmobile.profilescreen.ProfilePage
import com.essycynthia.calibanfoodmobile.ui.theme.CalibanFoodMobileTheme
import com.essycynthia.calibanfoodmobile.withdraw.WithdrawPage

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
                 //   Greeting()
                  //  ProfilePage()
                    OrganizationFreeLunchReward(cards = sampleCardData() )
                   // WithdrawPage()
                    //InviteUserOrg()
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
