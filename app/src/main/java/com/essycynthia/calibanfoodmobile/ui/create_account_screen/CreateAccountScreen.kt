package com.essycynthia.calibanfoodmobile.ui.create_account_screen

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
import androidx.navigation.compose.rememberNavController
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.SignUpRequest
import com.essycynthia.calibanfoodmobile.ui.Screens
import com.essycynthia.calibanfoodmobile.ui.login_screen.LoginScreen
import com.essycynthia.calibanfoodmobile.ui.navigation.user_authenticated_nav.UserAuthenticationNavGraph
import com.essycynthia.calibanfoodmobile.ui.theme.CalibanFoodMobileTheme
import com.essycynthia.calibanfoodmobile.ui.theme.Grey
import com.essycynthia.calibanfoodmobile.ui.theme.Neutral1
import com.essycynthia.calibanfoodmobile.ui.theme.Neutral2
import com.essycynthia.calibanfoodmobile.ui.theme.Primary


@Composable
    fun CreateAccountScreen(modifier: Modifier = Modifier) {
//    val viewModel: CreateAccountViewModel = hiltViewModel()
    val navController = rememberNavController()
    UserAuthenticationNavGraph(navController = navController)

        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var firstName by remember {mutableStateOf("")}
        var lastName by remember { mutableStateOf("") }
        var phoneNumber by remember { mutableStateOf("") }
        var confirmPassword by remember { mutableStateOf("") }

    val isDataValidated by remember {
        derivedStateOf {
            email != "" && firstName != "" && lastName != "" && password != "" && confirmPassword != "" && phoneNumber != ""
        }
    }

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
                firstName = firstName,
                lastName = lastName,
                password = password,
                confirmPassword = confirmPassword,
                phoneNumber = phoneNumber, // Pass phone number
                onEmailChange = { email = it },
                onFirstNameChanged = { firstName = it },
                onLastNameChanged = { lastName = it },
                onPasswordChange = { password = it },
                onConfirmPasswordChanged = { confirmPassword = it },
                onPhoneNumberChanged = { phoneNumber = it } // Handle phone number change
            )

            Spacer(modifier = Modifier.height(55.dp))
            // Observe the state
//            val createAccountState by viewModel.createAccountState.collectAsState()

//            // Handle navigation and error display
//            if (createAccountState.isLoading) {
//                CircularProgressIndicator()
//            } else {
//                if (createAccountState.success != null) {
//                    // Signup was successful, navigate to another screen
//                    navController.navigate(Screens.LoginScreen.route)
//                } else if (createAccountState.error != null) {
//                    // Display error message
//                    Text(text = createAccountState.error!!, color = Color.Red)
//                }
//            }
            Button(onClick = {
//                             viewModel.signup(SignUpRequest(email,firstName,lastName,password,phoneNumber))
                navController.navigate(Screens.LoginScreen.route)

            },
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Primary),
                modifier = Modifier
                    .fillMaxWidth(),
                enabled = isDataValidated) {
                Text(text = "Continue", color = Neutral1)

            }
        }
    }

    @Composable
    fun CreateAccountFields(
        modifier: Modifier = Modifier.fillMaxWidth(),
        email: String,
        firstName: String,
        lastName: String,
        password: String,
        confirmPassword: String,
        phoneNumber: String, // Keep phone number as String
        onEmailChange: (String) -> Unit,
        onFirstNameChanged: (String) -> Unit,
        onLastNameChanged: (String) -> Unit,
        onPasswordChange: (String) -> Unit,
        onConfirmPasswordChanged: (String) -> Unit,
        onPhoneNumberChanged: (String) -> Unit // Update to handle string phone number
    ) {
        var showPassword by remember {
            mutableStateOf(false)
        }

        DetailsFields(
            value = email,
            label = "Email",
            placeholder = "Enter your email address",
            onValueChaged = onEmailChange
        )

        Spacer(modifier = Modifier.height(15.dp))

        DetailsFields(
            value = firstName,
            label = "FirstName",
            placeholder = "Enter your first name",
            onValueChaged = onFirstNameChanged
        )

        Spacer(modifier = Modifier.height(15.dp))

        DetailsFields(
            value = lastName,
            label = "LastName",
            placeholder = "Enter your last name",
            onValueChaged = onLastNameChanged
        )

        Spacer(modifier = Modifier.height(15.dp))

        DetailsFields(
            modifier = modifier.fillMaxWidth(),
            value = phoneNumber, // Keep phone number as String
            label = "Phone Number", // Update label
            placeholder = "Enter your phone number", // Update placeholder
            visualTransformation = VisualTransformation.None,
            onValueChaged = onPhoneNumberChanged // Updated to handle string phone number
        )

        Spacer(modifier = Modifier.height(15.dp))

        DetailsFields(
            modifier = modifier.fillMaxWidth(),
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

        DetailsFields(
            modifier = modifier.fillMaxWidth(),
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
