package com.essycynthia.calibanfoodmobile.staffNavigation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.essycynthia.calibanfoodmobile.ui.theme.CalibanFoodMobileTheme
import com.essycynthia.calibanfoodmobile.ui.theme.Neutral1
import com.essycynthia.calibanfoodmobile.ui.theme.Primary

class EntryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalibanFoodMobileTheme {

                var token = true
                Column(
                    modifier = Modifier.fillMaxSize()
                        .padding(16.dp)
                        .padding(top = 20.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Free Launch App",
                        modifier = Modifier,
                        style = CalibanFoodMobileTheme.typography.h1Bold
                    )

                    Spacer(modifier = Modifier.height(50.dp))

                    Button(
                        onClick = {
                            token = true
                            Intent(this@EntryActivity, SignUpActivity::class.java)
                                .also {
                                it .putExtra("EntryMessage", token)
                                    startActivity(it)}
                            },
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Primary),
                        modifier = Modifier
                            .fillMaxWidth()) {
                        Text(text = "Sign up as a staff", color = Neutral1)
                    }
                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = {
                            token = false
                            Intent(this@EntryActivity, SignUpActivity::class.java)
                                .also {
                                    it.putExtra("EntryMessage", token)
                                    startActivity(it)}
                        },
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Primary),
                        modifier = Modifier
                            .fillMaxWidth()) {
                        Text(text = "Sign up as an admin", color = Neutral1)
                    }
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalibanFoodMobileTheme {

    }
}

