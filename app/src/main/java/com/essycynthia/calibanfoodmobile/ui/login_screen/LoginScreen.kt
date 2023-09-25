//package com.essycynthia.calibanfoodmobile.ui.login_screen
//
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.OutlinedButton
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextFieldDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.hilt.navigation.compose.hiltViewModel
//import androidx.navigation.NavController
//import com.essycynthia.calibanfoodmobile.R
//import com.essycynthia.calibanfoodmobile.data.remote.data_classes.LoginRequest
//import com.essycynthia.calibanfoodmobile.ui.theme.CalibanFoodMobileTheme
//import com.essycynthia.calibanfoodmobile.ui.theme.Grey
//import com.essycynthia.calibanfoodmobile.ui.theme.Neutral2
//import com.essycynthia.calibanfoodmobile.ui.theme.Primary
//
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun LoginScreen(modifier: Modifier = Modifier,navController: NavController) {
//    val viewModel: LoginViewModel = hiltViewModel()
//    val state = viewModel.loginState.collectAsState()
//    var loginEmail by remember {
//        mutableStateOf("")
//    }
//
//    var loginPassword by remember {
//        mutableStateOf("")
//    }
//
//
//
//    Column(
//        modifier = modifier
//            .padding(20.dp)
//            .padding(top = 50.dp)
//    ) {
//        Text(
//            text = "Login",
//            style = CalibanFoodMobileTheme.typography.h1Bold,
//            color = Neutral2,
//            fontSize = 28.sp
//        )
//        Text(
//            text = "Login to start receiving free launch from collegues",
//            style = CalibanFoodMobileTheme.typography.bodyRegular,
//            color = Neutral2,
//            fontSize = 14.sp,
//            modifier = modifier.padding(top = 8.dp)
//        )
//
//        LoginFields(email = loginEmail, password = loginPassword,
//            onEmailChange = { loginEmail = it },
//            onPasswordChange = { loginPassword = it })
//
//
//        OutlinedButton(
//            onClick = { /*TODO*/
//                viewModel.login(LoginRequest(loginEmail, loginPassword))
//                navController.navigate(BottomScreens.HomeScreen.route)
//
//            },
//            shape = RoundedCornerShape(5.dp),
//
//            border = BorderStroke(
//                width = 1.dp,
//                color = Primary,
//            ),
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(
//                    top = 25.dp,
//                )
//        ) {
//            Image(
//                modifier = modifier.size(32.dp),
//                painter = painterResource(id = R.drawable.google_icon),
//                contentDescription = "Google",
//                contentScale = ContentScale.Crop
//            )
//
//            Text(
//                text = "Login",
//                color = Neutral2,
//                style = CalibanFoodMobileTheme.typography.button,
//                fontSize = 14.sp
//            )
//        }
//    }
//
//}
//
//
//@Composable
//fun LoginFields(
//    modifier: Modifier = Modifier.fillMaxWidth(),
//    email: String,
//    password: String,
//    onEmailChange: (String) -> Unit,
//    onPasswordChange: (String) -> Unit,
//) {
//    LoginDetailsFields(
//        value = email,
//        label = "Email Address",
//        placeholder = "Enter your email address",
//        onValueChaged = onEmailChange // Use onEmailChange for email field
//    )
//
//    Spacer(modifier = Modifier.height(15.dp))
//
//    LoginDetailsFields(
//        value = password,
//        label = "Password",
//        placeholder = "Enter your password",
//        onValueChaged = onPasswordChange // Use onPasswordChange for password field
//    )
//    Spacer(modifier = Modifier.height(15.dp))
//}
//
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun LoginDetailsFields(
//    modifier: Modifier = Modifier.fillMaxWidth(), value: String,
//    label: String,
//    placeholder: String,
//    onValueChaged: (String) -> Unit
//) {
//    OutlinedTextField(
//        shape = RoundedCornerShape(5.dp),
//        colors = TextFieldDefaults.outlinedTextFieldColors(
//            focusedBorderColor = Primary,
//            focusedLabelColor = Grey
//        ),
//        modifier = Modifier
//            .fillMaxWidth(),
//        value = value,
//        onValueChange = onValueChaged,
//
//        label = {
//            Text(text = label)
//        },
//        placeholder = {
//            Text(text = placeholder)
//        }
//    )
//}
//
//@Preview
//@Composable
//fun LoginScreenPreview(){
//    LoginScreen()
//}
//
