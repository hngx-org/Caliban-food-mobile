package com.essycynthia.calibanfoodmobile.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.essycynthia.calibanfoodmobile.R


class LoginScreen {

    @Composable
    fun Login(modifier: Modifier = Modifier) {
        Column(modifier = modifier
            .padding(20.dp)
            .padding(top = 50.dp)) {
            Text(text = "Login",
                style = CalibanFoodMobileTheme.typography.h1Bold,
                color = Neutral2,
                fontSize = 28.sp
            )
            Text(text = "Login to start receiving free launch from collegues",
                style = CalibanFoodMobileTheme.typography.bodyRegular,
                color = Neutral2,
                fontSize = 14.sp,
                modifier = modifier.padding(top = 8.dp)
            )

            OutlinedButton(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(
                    width = 1.dp,
                    color = Primary,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 25.dp,
                    )
            ) {
                Image(modifier = modifier.size(32.dp),
                    painter = painterResource(id = R.drawable.google_icon ),
                    contentDescription = "Google",
                    contentScale = ContentScale.Crop)

                Text(text = "Login with Google",
                    color = Neutral2,
                    style = CalibanFoodMobileTheme.typography.button,
                    fontSize = 14.sp)
            }
        }

    }


}