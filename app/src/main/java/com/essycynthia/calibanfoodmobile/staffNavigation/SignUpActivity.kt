package com.essycynthia.calibanfoodmobile.staffNavigation

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.essycynthia.calibanfoodmobile.ui.theme.CalibanFoodMobileTheme
import com.essycynthia.calibanfoodmobile.ui.theme.Grey
import com.essycynthia.calibanfoodmobile.ui.theme.Neutral1
import com.essycynthia.calibanfoodmobile.ui.theme.Neutral2
import com.essycynthia.calibanfoodmobile.ui.theme.Primary

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalibanFoodMobileTheme {

                val intent = intent
                val isToken = intent.getBooleanExtra("EntryMessage", true)


                    var email by remember { mutableStateOf("") }
                    var password by remember { mutableStateOf("") }
                    var firstName by remember { mutableStateOf("") }
                    var lastName by remember { mutableStateOf("") }
                    var staffToken by remember { mutableStateOf("") }


                    //var showPassword by remember { mutableStateOf("false") }


                    Column(modifier = Modifier
                        .padding(20.dp)
                        .padding(top = 10.dp)
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
                            modifier = Modifier.padding(top = 8.dp)
                        )
                        Spacer(modifier = Modifier.height(30.dp))

                        CreateAccountFields(
                            modifier = Modifier.fillMaxWidth(),
                            email = email,
                            firstName = firstName,
                            lastName = lastName,
                            password = password,
                            staffToken = staffToken,
                            isToken = isToken,
                            onEmailChange = {email = it
                            },
                            onStaffTokenChanged = {staffToken = it},
                            onFirstNameChanged = { firstName= it },
                            onLastNameChanged = {lastName = it },
                            onPasswordChange = {password = it
                            }
                        )

                        Spacer(modifier = Modifier.height(20.dp))
                        Button(onClick = {
                            Intent(this@SignUpActivity, LoginActivity::class.java).also {
                                it.putExtra("EntryMessage", isToken)
                                startActivity(it)
                            }
                            Log.d("Debuggg", "Gooooooo")

                        },
                            shape = RoundedCornerShape(5.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Primary),
                            modifier = Modifier
                                .fillMaxWidth()) {
                            Text(text = "Continue", color = Neutral1)

                        }
                    }
              //  }


            }
        }
    }
}


@Composable
fun CreateAccountFields(modifier: Modifier = Modifier.fillMaxWidth(), email: String,
                        firstName : String, lastName: String, password: String,
                        isToken: Boolean,
                        staffToken : String,
                        onEmailChange: (String) -> Unit,
                        onFirstNameChanged: (String) -> Unit,
                        onLastNameChanged: (String) -> Unit,
                        onPasswordChange: (String) -> Unit,
                        onStaffTokenChanged: (String) -> Unit){

    var showPassword by remember {
        mutableStateOf(false)
    }

    DetailsFields(
        value = email ,
        label ="Email" ,
        placeholder ="Enter your email address",
        onValueChaged = onEmailChange)

    Spacer(modifier = Modifier.height(15.dp))

    DetailsFields(
        value = firstName ,
        label ="FirstName" ,
        placeholder ="Enter your first name",
        onValueChaged = onFirstNameChanged)

    Spacer(modifier = Modifier.height(15.dp))

    DetailsFields(
        value = lastName ,
        label ="LastName" ,
        placeholder ="Enter your last name",
        onValueChaged = onLastNameChanged)

    Spacer(modifier = Modifier.height(15.dp))


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
    Spacer(modifier = Modifier.height(15.dp))

    /* DetailsFields(value = confirmPassword,
         label = "Password",
         placeholder = "Confirm Password",
         onValueChaged = onConfirmPasswordChanged)*/

    if(isToken) {
        DetailsFields(
            value = staffToken,
            label = "Staff Token",
            placeholder = "Enter Token",
            onValueChaged = onStaffTokenChanged
        )

        Spacer(modifier = Modifier.height(15.dp))
    } else {

    }

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

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    CalibanFoodMobileTheme {

    }
}