package com.essycynthia.calibanfoodmobile.ui

//import androidx.constraintlayout.compose.Visibility
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.essycynthia.calibanfoodmobile.ui.theme.CalibanFoodMobileTheme
import com.essycynthia.calibanfoodmobile.ui.theme.Neutral1
import com.essycynthia.calibanfoodmobile.ui.theme.Neutral2
import com.essycynthia.calibanfoodmobile.ui.theme.Primary

@Composable
fun Register(modifier: Modifier = Modifier,navController: NavHostController) {
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
        Spacer(modifier = Modifier.height(55.dp))

        CreateAccountFields(
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

        Spacer(modifier = Modifier.height(55.dp))
        Button(onClick = { navController.navigate("reward_screen") },
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Primary),
            modifier = Modifier
                .fillMaxWidth()) {
            Text(text = "Continue", color = Neutral1)

        }
    }
}

@Composable
fun CreateAccountFields(modifier: Modifier = Modifier.fillMaxWidth(), email: String, password: String, confirmPassword: String,
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
        shape = RoundedCornerShape(5.dp),
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