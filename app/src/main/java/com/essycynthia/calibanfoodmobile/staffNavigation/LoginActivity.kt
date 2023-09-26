package com.essycynthia.calibanfoodmobile.staffNavigation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.essycynthia.calibanfoodmobile.R
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.LoginRequest
import com.essycynthia.calibanfoodmobile.ui.login_screen.LoginViewModel
import com.essycynthia.calibanfoodmobile.ui.theme.CalibanFoodMobileTheme
import com.essycynthia.calibanfoodmobile.ui.theme.Grey
import com.essycynthia.calibanfoodmobile.ui.theme.Neutral2
import com.essycynthia.calibanfoodmobile.ui.theme.Primary
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val intent = intent
            val isToken = intent.getBooleanExtra("EntryMessage", true)

            CalibanFoodMobileTheme {
                val viewModel: LoginViewModel by viewModels()

                val viewModel: LoginViewModel = hiltViewModel()

                var loginEmail by remember {
                    mutableStateOf("")
                }

                var loginPassword by remember {
                    mutableStateOf("")
                }

                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .padding(top = 50.dp)
                ) {
                    val isDataValidated by remember {
                        derivedStateOf {
                            loginEmail != "" && loginPassword != ""
                        }
                    }




                    Column(

                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .padding(top = 50.dp)
                ) {
                    Text(
                        text = "Login",
                        style = CalibanFoodMobileTheme.typography.h1Bold,
                        color = Neutral2,
                        fontSize = 28.sp
                    )
                    Text(
                        text = "Login to start receiving free launch from collegues",
                        style = CalibanFoodMobileTheme.typography.bodyRegular,
                        color = Neutral2,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )

                    LoginFields(email = loginEmail, password = loginPassword,
                        onEmailChange = { loginEmail = it },
                        onPasswordChange = { loginPassword = it })


                    OutlinedButton(
                        onClick = {
                            viewModel.login(LoginRequest(loginEmail, loginPassword))

                        },
                        shape = RoundedCornerShape(5.dp),

                        border = BorderStroke(
                            width = 1.dp,
                            color = Primary,
                        ),
                        modifier = Modifier
                            .padding(20.dp)
                            .padding(top = 50.dp)
                    ) {
                        Text(
                            text = "Login",
                            style = CalibanFoodMobileTheme.typography.h1Bold,
                            color = Neutral2,
                            fontSize = 28.sp
                        )
                        Text(
                            text = "Login to start receiving free launch from collegues",
                            style = CalibanFoodMobileTheme.typography.bodyRegular,
                            color = Neutral2,
                            fontSize = 14.sp,
                            modifier = Modifier.padding(top = 8.dp)
                        )

                        LoginFields(email = loginEmail, password = loginPassword,
                            onEmailChange = { loginEmail = it },
                            onPasswordChange = { loginPassword = it })


                        OutlinedButton(
                            onClick = {
                                viewModel.login(LoginRequest(loginEmail, loginPassword))
                                Intent(this@LoginActivity, MainActivity::class.java).also {
                                    startActivity(it)
                                }
                            },
                            shape = RoundedCornerShape(5.dp),

                            border = BorderStroke(
                                width = 1.dp,
                                color = Primary,
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    top = 25.dp,
                                ),

                            enabled = isDataValidated
                        ) {
                            Image(
                                modifier = Modifier.size(32.dp),
                                painter = painterResource(id = R.drawable.google_icon),
                                contentDescription = "Google",
                                contentScale = ContentScale.Crop
                            )

                            Text(
                                text = "Login",
                                color = Neutral2,
                                fontSize = 28.sp
                            )
                            Text(
                                text = "Login to start receiving free launch from collegues",
                                style = CalibanFoodMobileTheme.typography.bodyRegular,
                                color = Neutral2,
                                fontSize = 14.sp,
                                modifier = Modifier.padding(top = 8.dp)
                            )

                            LoginFields(email = loginEmail, password = loginPassword,
                                onEmailChange = { loginEmail = it },
                                onPasswordChange = { loginPassword = it })


                            OutlinedButton(
                                onClick = {
                                    if (isToken) {
                                        Intent(
                                            this@LoginActivity,
                                            MainActivity::class.java
                                        ).also {
                                            startActivity(it)
                                        }
                                    } else {
                                        Intent(
                                            this@LoginActivity,
                                            MainActivityAdmin::class.java
                                        ).also {
                                            startActivity(it)
                                        }

                                    }
                                },
                                shape = RoundedCornerShape(5.dp),

                        enabled = isDataValidated
                    ) {
                        Image(
                            modifier = Modifier.size(32.dp),
                            painter = painterResource(id = R.drawable.google_icon),
                            contentDescription = "Google",
                            contentScale = ContentScale.Crop
                        )

                        Text(
                            text = "Login",
                            color = Neutral2,
                            style = CalibanFoodMobileTheme.typography.button,
                            fontSize = 14.sp
                        )
                    }
                }
                val state = viewModel.loginState.collectAsState()
                if (state.value.isLoading) {
                    CircularProgressIndicator()
                } else if (state.value.success != null) {
                    Intent(this@LoginActivity, MainActivity::class.java).also {
                        startActivity(it)

                    }

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
                                /* Image(modifier = Modifier.size(32.dp),
                                     painter = painterResource(id = R.drawable.google_icon),
                                     contentDescription = "Google",
                                     contentScale = ContentScale.Crop)*/

                                Text(
                                    text = "Login",
                                    color = Neutral2,
                                    style = CalibanFoodMobileTheme.typography.button,
                                    fontSize = 14.sp
                                )
                            }
                        }

                    }
                }

                }
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
        onValueChaged = onEmailChange // Correct callback for email field
    )



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
            onValueChaged = onEmailChange // Correct callback for email field
        )

        Spacer(modifier = Modifier.height(15.dp))

        LoginDetailsFields(
            value = password,
            label = "Password",
            placeholder = "Enter your password",
            onValueChaged = onPasswordChange // Correct callback for password field
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
}



/*
@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    CalibanFoodMobileTheme {
        Greeting2("Android")
    }
}*/
