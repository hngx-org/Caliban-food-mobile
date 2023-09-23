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
import androidx.compose.ui.tooling.preview.Preview
import com.essycynthia.calibanfoodmobile.searchcolleague.LunchRecognitionsScreen
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
                   //Greeting()
                 //   LunchRecognitionsScreen()
                }
            }
        }
    }
}
@Composable
fun Greeting(){
    Text(text = "Yay it's working!")
}

