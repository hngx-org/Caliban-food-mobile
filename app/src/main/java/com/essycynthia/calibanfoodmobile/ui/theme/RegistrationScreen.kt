package com.essycynthia.calibanfoodmobile.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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

class RegistrationScreen {

    @Composable
    fun register(modifier: Modifier = Modifier) {
        var companyName by remember { mutableStateOf("") }
        var lunchPrice by remember { mutableStateOf("") }
        var currency by remember { mutableStateOf("") }
        //var showPassword by remember { mutableStateOf("false") }


        Column(
            modifier = modifier
                .padding(20.dp)
                .padding(top = 50.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Registration",
                style = CalibanFoodMobileTheme.typography.h1Bold,
                color = Neutral2,
                fontSize = 28.sp
            )
            Text(
                text = "let's set up your account",
                style = CalibanFoodMobileTheme.typography.bodyRegular,
                color = Neutral2,
                fontSize = 14.sp,
                modifier = modifier.padding(top = 8.dp)
            )
            Spacer(modifier = Modifier.height(55.dp))

            RegistrationFields(
                companyName = companyName,
                lunchPrice = lunchPrice,
                currency = currency,
                onCompanyNameChange = { companyName = it },
                onLunchPriceChange = { lunchPrice = it },
                onCurrencyChange = { currency = it }
            )




            Spacer(modifier = Modifier.height(55.dp))
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Primary),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = "Create", color = Neutral1)

            }
        }
    }
}

@Composable
fun RegistrationFields(
    modifier: Modifier = Modifier.fillMaxWidth(),
    companyName: String, lunchPrice: String,
    currency: String,
    onCompanyNameChange: (String) -> Unit,
    onLunchPriceChange: (String) -> Unit,
    onCurrencyChange: (String) -> Unit
) {


    DetailsFields(
        value = companyName,
        label = "Company Name",
        placeholder = "Enter your company name",
        onValueChaged = onCompanyNameChange
    )

    Spacer(modifier = Modifier.height(15.dp))

    DetailsFields(
        value = lunchPrice,
        label = "LunchPrice",
        placeholder = "Enter your lunch price",
        onValueChaged = onLunchPriceChange
    )

    Spacer(modifier = Modifier.height(15.dp))

    DetailsFields(
        value = currency,
        label = "Currency",
        placeholder = "Enter your currency",
        onValueChaged = onCurrencyChange
    )

    Spacer(modifier = Modifier.height(15.dp))

}

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
