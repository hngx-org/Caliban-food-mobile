package com.essycynthia.calibanfoodmobile

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.input.VisualTransformation
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
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    //var showPassword by remember { mutableStateOf("false") }


    Column(modifier = modifier
        .padding(20.dp)
        .padding(top = 50.dp)
        .fillMaxWidth()) {
        Text(
            text = "Create Account",
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

        RegistrationFields(
            modifier = modifier.fillMaxWidth(),
            email = email,
            password = password,
            confirmPassword = confirmPassword,
            onEmailChange = {email = it
            },
            onPasswordChange = {password = it
            },
            onConfirmPasswordChanged = {confirmPassword = it
            }
        )
    }
}

@Composable
fun RegistrationFields(modifier: Modifier = Modifier.fillMaxWidth(), email: String, password: String, confirmPassword: String,
                       onEmailChange: (String) -> Unit, onPasswordChange: (String) -> Unit,
                       onConfirmPasswordChanged: (String) -> Unit){

    var showPassword by remember {
        mutableStateOf(false)
    }

    DetailsFields(
        value = email ,
        label ="Email" ,
        placeholder ="Enter your email address",
        onValueChaged = onEmailChange)


    DetailsFields(modifier = modifier.fillMaxWidth(),
        value = password,
        label = "Password",
        placeholder = "Enter Password",
        onValueChaged = onPasswordChange,
        trailingIcon = {
            if(showPassword) {
                IconButton(onClick = { showPassword = false}) {
                    Icon(

                        imageVector = Icons.Filled.Visibility,
                        contentDescription = "hide_password"
                    )
                }
                } else {
                    IconButton(onClick = { showPassword = true }) {
                        Icon(
                            imageVector = Icons.Filled.VisibilityOff,
                            contentDescription = "hide_password"
                        )
                    }
                }
            }
    )

    DetailsFields(modifier = modifier.fillMaxWidth(),
        value = password,
        label = "Password",
        placeholder = "Confirm Password",
        onValueChaged = onPasswordChange,
        trailingIcon = {
            if(showPassword) {
                IconButton(onClick = { showPassword = false}) {
                    Icon(

                        imageVector = Icons.Filled.Visibility,
                        contentDescription = "hide_password"
                    )
                }
            } else {
                IconButton(onClick = { showPassword = true }) {
                    Icon(
                        imageVector = Icons.Filled.VisibilityOff,
                        contentDescription = "hide_password"
                    )
                }
            }
        }
    )
   /* DetailsFields(value = confirmPassword,
        label = "Password",
        placeholder = "Confirm Password",
        onValueChaged = onConfirmPasswordChanged)*/
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsFields(modifier: Modifier = Modifier.fillMaxWidth(), value : String,
                  label : String,
                  placeholder: String,
                  visualTransformation: VisualTransformation = VisualTransformation.None,
                  keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
                  trailingIcon: @Composable (() -> Unit)? = null,
                  onValueChaged : (String) -> Unit){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChaged,
        label = {
            Text(text = label)
        },
        placeholder = {
            Text(text = placeholder)
        },
        visualTransformation = visualTransformation,
        trailingIcon = trailingIcon
    )


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

