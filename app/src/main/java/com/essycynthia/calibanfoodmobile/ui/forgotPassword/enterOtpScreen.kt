package com.essycynthia.calibanfoodmobile.ui.forgotPassword

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.essycynthia.calibanfoodmobile.staffNavigation.LoginActivity
import com.essycynthia.calibanfoodmobile.ui.theme.CalibanFoodMobileTheme
import com.essycynthia.calibanfoodmobile.ui.theme.Grey
import com.essycynthia.calibanfoodmobile.ui.theme.Neutral1
import com.essycynthia.calibanfoodmobile.ui.theme.Neutral2
import com.essycynthia.calibanfoodmobile.ui.theme.Primary

class enterOtpScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalibanFoodMobileTheme {

                var otp by remember { mutableStateOf("") }
                var password by remember { mutableStateOf("") }
                var confirmPassword by remember { mutableStateOf("") }

                val isDataValidated by remember {
                    derivedStateOf {
                        otp != "" && password != "" && confirmPassword != ""
                    }
                }

                Column(modifier = Modifier
                    .padding(20.dp)
                    .padding(top = 50.dp)
                    .fillMaxWidth()) {
                    Text(
                        text = "Reset Password",
                        style = CalibanFoodMobileTheme.typography.h1Bold,
                        color = Neutral2,
                        fontSize = 28.sp
                    )
                    Text(
                        text = "Enter Otp",
                        style = CalibanFoodMobileTheme.typography.bodyRegular,
                        color = Neutral2,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Spacer(modifier = Modifier.height(55.dp))

                    CreateAccountFields(
                        modifier = Modifier.fillMaxWidth(),
                        otp = otp,
                        password = password,
                        confirmPassword = confirmPassword,
                        onOtpChange = {otp = it},
                        onPasswordChange = {password = it
                        },
                        onConfirmPasswordChanged = {confirmPassword = it
                        }
                    )

                    Spacer(modifier = Modifier.height(55.dp))

                    Button(onClick = {

                        Intent(this@enterOtpScreen, LoginActivity::class.java).also {
                            startActivity(it)
                        }
                        Log.d("Debuggg", "Gooooooo")

                    },
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Primary),
                        modifier = Modifier
                            .fillMaxWidth(),
                        enabled = isDataValidated
                    ) {
                        Text(text = "Reset Password", color = Neutral1)

                    }
                }
            }
        }
    }
}


@Composable
fun CreateAccountFields(modifier: Modifier = Modifier.fillMaxWidth(),
                        otp: String,
                        password: String,
                        confirmPassword: String,
                        onOtpChange: (String) -> Unit,
                        onPasswordChange: (String) -> Unit,
                        onConfirmPasswordChanged: (String) -> Unit) {

    var showPassword by remember {
        mutableStateOf(false)
    }

    com.essycynthia.calibanfoodmobile.staffNavigation.DetailsFields(
        value = otp,
        label = "Otp",
        placeholder = "Enter Otp",
        onValueChaged = onOtpChange
    )

    Spacer(modifier = Modifier.height(15.dp))

    com.essycynthia.calibanfoodmobile.staffNavigation.DetailsFields(modifier = modifier.fillMaxWidth(),
        value = password,
        label = "Password",
        placeholder = "Enter Password",
        onValueChaged = onPasswordChange,
        trailingIcon = {
            if (showPassword) {
                IconButton(onClick = { showPassword = false }) {
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
    Spacer(modifier = Modifier.height(15.dp))

    com.essycynthia.calibanfoodmobile.staffNavigation.DetailsFields(modifier = modifier.fillMaxWidth(),
        value = confirmPassword,
        label = "Confirm Password",
        placeholder = "Confirm Password",
        onValueChaged = onConfirmPasswordChanged,
        trailingIcon = {
            if (showPassword) {
                IconButton(onClick = { showPassword = false }) {
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

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun DetailsFields(
        modifier: Modifier = Modifier.fillMaxWidth(), value: String,
        label: String,
        placeholder: String,
        visualTransformation: VisualTransformation = VisualTransformation.None,
        keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
        trailingIcon: @Composable (() -> Unit)? = null,
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
            },
            visualTransformation = visualTransformation,
            trailingIcon = trailingIcon
        )

    }
}