package com.essycynthia.calibanfoodmobile.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.essycynthia.calibanfoodmobile.R


class LoginScreen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Login(modifier: Modifier = Modifier) {
        var loginEmail by remember {
            mutableStateOf("")
        }

        var loginPassword by remember {
            mutableStateOf("")
        }



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

            LoginFields(email = loginEmail, password = loginPassword,
                onEmailChange = { loginEmail = it},
                onPasswordChange = {loginPassword = it })


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

                Text(text = "Login",
                    color = Neutral2,
                    style = CalibanFoodMobileTheme.typography.button,
                    fontSize = 14.sp)
            }
        }

    }
}


@Composable
fun LoginFields(
    modifier: Modifier = Modifier.fillMaxWidth(),
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
) {
    LoginDetailsFields(
        value = email,
        label = "Email Address",
        placeholder = "Enter your email address",
        onValueChaged = onEmailChange
    )

    Spacer(modifier = Modifier.height(15.dp))

    LoginDetailsFields(
        value = password,
        label = "Password",
        placeholder = "Enter your password",
        onValueChaged = onEmailChange
    )
    Spacer(modifier = Modifier.height(15.dp))

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginDetailsFields(
    modifier: Modifier = Modifier.fillMaxWidth(), value: String,
    label: String,
    placeholder: String,
    onValueChaged: (String) -> Unit
) {
    OutlinedTextField(
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Grey
        ),
        modifier = Modifier
            .fillMaxWidth(),
        value = value,
        onValueChange = onValueChaged,

        label = {
            Text(text = label)
        },
        placeholder = {
            Text(text = placeholder)
        }
    )
}

